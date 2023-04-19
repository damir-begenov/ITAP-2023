package com.example.new_project_challenge_15.repository;

import com.example.new_project_challenge_15.entity.Address;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface newAddressRepo extends Neo4jRepository<Address,Long> {
    @Query("match (m:Address) return m limit 10")
    List<Address> getAddress();
}
