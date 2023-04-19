package com.example.new_project_challenge_15.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.example.new_project_challenge_15.entity.rels.*;

@Repository
public interface relationRepo extends Neo4jRepository<ACTED_IN, Long> {
    @Query("match ()-[r:ACTED_IN]-() return COLLECT(DISTINCT r)")
    List<ACTED_IN> getAll();
    
}
