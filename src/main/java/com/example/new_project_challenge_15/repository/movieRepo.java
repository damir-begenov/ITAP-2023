package com.example.new_project_challenge_15.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.example.new_project_challenge_15.entity.Movie;

@Repository
public interface movieRepo  extends Neo4jRepository<Movie, Long> {
    @Query("match (i:Movie) return i")
    List<Movie> getAll();
}
