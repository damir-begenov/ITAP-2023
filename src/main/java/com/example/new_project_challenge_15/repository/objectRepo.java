package com.example.new_project_challenge_15.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.new_project_challenge_15.entity.Person;

@Repository
public interface objectRepo extends Neo4jRepository<Person, Long> {    

    @Query("MATCH p=allShortestPaths((a:Person)-[r*]-(b:Person)) where a.name=($FIRST) and b.name=($SECOND) and ALL(rel in relationships(p) WHERE type(rel) in [$REL1, $REL2, $REL3, $REL4, $REL5, $REL6]) RETURN COLLECT(DISTINCT p)")
    List<Person> getAllShortestPaths(String FIRST, String SECOND, String REL1, String REL2, String REL3, String REL4, String REL5, String REL6 );
    
    @Query("WITH $DEPTH as d MATCH (startNode) WHERE startNode.name = ($PERSON) OPTIONAL MATCH p = (startNode)-[r*1..7]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in [$REL1, $REL2, $REL3, $REL4, $REL5, $REL6]) AND length(p)<=d WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Person> getPersonTree(String PERSON, String REL1, String REL2, String REL3, String REL4, String REL5, String REL6, int DEPTH, int LIMIT);

    @Query("MATCH p=((a:Movie)<-[r*1]-(b:Person)) where a.title=($TITLE) and ALL(rel in relationships(p) WHERE type(rel) in [$REL1, $REL2, $REL3, $REL4, $REL5, $REL6])  return COLLECT(DISTINCT p)")
    List<Person> getByMovie(String TITLE, String REL1, String REL2, String REL3, String REL4, String REL5, String REL6);    

    @Query("MATCH p=allShortestPaths((a:Person)-[r*]-(b:Movie)) where a.name=($PERSON) and b.title=($MOVIE) and ALL(rel in relationships(p) WHERE type(rel) in [$REL1, $REL2, $REL3, $REL4, $REL5, $REL6]) RETURN COLLECT(DISTINCT p)")
    List<Person> getMoviePersonRelation(String PERSON, String MOVIE, String REL1, String REL2, String REL3, String REL4, String REL5, String REL6);

    @Query("MATCH (startNode) WHERE id(startNode)=$ID OPTIONAL MATCH p = (startNode)-[r]-(endNode) WITH DISTINCT p as paths RETURN COLLECT(distinct paths)")
    List<Person> shortOpern(Long ID);
}
