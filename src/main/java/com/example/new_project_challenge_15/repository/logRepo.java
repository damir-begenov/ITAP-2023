package com.example.new_project_challenge_15.repository;

import com.example.new_project_challenge_15.models.log;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface logRepo extends JpaRepository<log, Long> {
    @Query(value = "SELECT * FROM log where username like ?1", nativeQuery = true)
    List<log> findByUsername(String username);

//    @Query(value = "select count(*) from log")
    @Query(value = "SELECT COUNT(*) FROM log where to_char(date, 'YYYY-MM-dd') = to_char(NOW(), 'YYYY-MM-dd')", nativeQuery = true)
    Integer findNumberOfRequestsThatRequestedToday();
    @Query(value = "SELECT COUNT(distinct(username)) FROM log where to_char(date, 'YYYY-MM-dd') = to_char(NOW(), 'YYYY-MM-dd') ", nativeQuery = true)
    Integer findNumberOfUsersThatMadeRequestToday();
    @Query(value = "SELECT COUNT(*) FROM public.log where username like ?1", nativeQuery = true)
    Integer findNumberOfRequests(String username);

    @Query(value = "select date FROM log where username like ?1 order by date desc limit 1", nativeQuery = true)
    LocalDateTime findLastDate(String username);

    @Query(value = "select count(*) from public.log where username like ?1 and to_char(date, 'YYYY-MM-dd') = to_char(NOW(), 'YYYY-MM-dd')", nativeQuery = true)
    Integer findTodayRequestNum(String username);

    @Query(value = "SELECT COUNT(*) FROM public.log", nativeQuery = true)
    Integer Number();

    @Query(value = "select * from log where username = ?1 and ('%' || ?2 || '%' = any(request_body) or '%' || ?2 || '%' = any(request_rels) or obwii like '%' || ?2 || '%' or approvement_data like '%' || ?2 || '%')", nativeQuery = true) 
    List<log> findByUsernameAndInput(String username, String input);

}
