package com.example.new_project_challenge_15.repository;

import com.example.new_project_challenge_15.entity.Company;
import com.example.new_project_challenge_15.entity.Person;
import com.example.new_project_challenge_15.entity.Persons;
import org.neo4j.driver.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
public interface newPersonService extends Neo4jRepository<Persons,Long> {
//    final String query1 = "with 3 as d MATCH p=(n:Person)-[*1..3]-() RETURN p LIMIT 20";
//    @Query("WITH {0} as d MATCH (startNode:Person) WHERE startNode.`ИИН` = {1} OPTIONAL MATCH p = (startNode)-[r*1..{0}]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in {2}) AND length(p)<=d WITH DISTINCT p as paths LIMIT {3} RETURN COLLECT(distinct paths)")
//    List<Persons> getPersonTreee(int depth, String person, List<String> relations, int limit);

    @Query("MATCH p=(n:Person)-[*1..2]-() where n.`ИИН`= '040210551264' RETURN p LIMIT 20")
    List<Persons> getPersons();
//GETPERSONTREE different depth
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..1]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=1 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepthOne(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..2]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=2 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepthTwo(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..3]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=3 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepthThree(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..4]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=4 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth4(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..5]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=5 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth5(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..6]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=6 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth6(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..7]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=7 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth7(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..8]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=8 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth8(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..9]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=9 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth9(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..10]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=10 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth10(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..11]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=11 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth11(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..12]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=12 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth12(String PERSON, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..13]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=13 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTreeDepth13(String PERSON, int LIMIT, List<String> RELS);
    //--------------------------------------------------------------------------------------------------
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..1]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=1 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth1(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..2]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=2 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth2(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..3]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=3 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth3(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..4]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=4 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth4(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..5]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=5 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth5(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..6]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=6 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth6(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..7]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=7 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth7(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..8]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=8 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth8(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O) OPTIONAL MATCH p = (startNode)-[*1..9]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=9 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth9(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O)  OPTIONAL MATCH p = (startNode)-[*1..10]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=10 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth10(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O)  OPTIONAL MATCH p = (startNode)-[*1..11]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=11 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth11(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O)  OPTIONAL MATCH p = (startNode)-[*1..12]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=12 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth12(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) and startNode.`Отчество` =~ ($O)  OPTIONAL MATCH p = (startNode)-[*1..13]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=13 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth13(String F,String I,String O,int LIMIT,List<String> RELS);
    //--------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..1]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=1 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth1Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..2]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=2 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth2Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..3]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=3 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth3Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =($F) and startNode.`Имя` =($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..4]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=4 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth4Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` =($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..5]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=5 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth5Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..6]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=6 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth6Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..7]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=7 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth7Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..8]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=8 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth8Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O) OPTIONAL MATCH p = (startNode)-[*1..9]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=9 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth9Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O)  OPTIONAL MATCH p = (startNode)-[*1..10]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=10 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth10Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O)  OPTIONAL MATCH p = (startNode)-[*1..11]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=11 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth11Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O)  OPTIONAL MATCH p = (startNode)-[*1..12]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=12 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth12Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` = ($F) and startNode.`Имя` = ($I) and startNode.`Отчество` =~ ('.*' + $O)  OPTIONAL MATCH p = (startNode)-[*1..13]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=13 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth13Accurate(String F,String I,String O,int LIMIT,List<String> RELS);
    //--------------------------------------------------------------------------------------------------
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I)   OPTIONAL MATCH p = (startNode)-[*1..1]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=1 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth1withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I)  OPTIONAL MATCH p = (startNode)-[*1..2]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=2 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth2withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I)   OPTIONAL MATCH p = (startNode)-[*1..3]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=3 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth3withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)  WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) OPTIONAL MATCH p = (startNode)-[*1..4]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=4 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth4withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) OPTIONAL MATCH p = (startNode)-[*1..5]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=5 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth5withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I)  OPTIONAL MATCH p = (startNode)-[*1..6]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=6 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth6withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person)WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I)  OPTIONAL MATCH p = (startNode)-[*1..7]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=7 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth7withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) OPTIONAL MATCH p = (startNode)-[*1..8]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=8 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth8withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I)  OPTIONAL MATCH p = (startNode)-[*1..9]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=9 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth9withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) OPTIONAL MATCH p = (startNode)-[*1..10]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=10 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth10withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) OPTIONAL MATCH p = (startNode)-[*1..11]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=11 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth11withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) OPTIONAL MATCH p = (startNode)-[*1..12]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=12 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth12withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:Person) WHERE startNode.`Фамилия` =~ ($F) and startNode.`Имя` =~ ($I) OPTIONAL MATCH p = (startNode)-[*1..13]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=13 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonByFIO_Depth13withoutO(String F,String I,String O,int LIMIT,List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..1]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=1 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree1(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..2]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=2 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree2(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..3]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=3 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree3(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..4]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=4 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree4(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..5]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=5 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree5(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..6]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=6 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree6(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..7]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=7 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree7(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..8]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=8 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree8(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..9]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=9 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree9(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..10]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=10 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree10(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..11]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=11 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree11(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..12]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=12 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree12(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..13]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=13 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree13(String UL, int LIMIT, List<String> RELS);
    @Query("MATCH (startNode:COMPANY) WHERE startNode.`ИИН/БИН` = ($UL) OPTIONAL MATCH p = (startNode)-[*1..14]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=14 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getUlTree14(String UL, int LIMIT, List<String> RELS);

    //GET UL FL PATH

    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:COMPANY)) where a.`ИИН`=($PERSON) and b.`ИИН/БИН`=($UL) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getUlFlPath(String PERSON, String UL, List<String> RELS);
    //GET UL FL PATH ------------------------------------------
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:COMPANY)) WHERE a.`Фамилия` =~ ($F) and a.`Имя` = ($I) and a.`Отчество` =~ ($O) and b.`ИИН/БИН`=($UL) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getUlFlPathByFIO(String F,String I,String O, String UL, List<String> RELS);
    //GET UL UL PATH
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:COMPANY)) WHERE a.`Фамилия` = ($F) and a.`Имя` = ($I) and a.`Отчество` =~ ('.*' + $O) and b.`ИИН/БИН`=($UL) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getUlFlPathByFIOAccurate(String F,String I,String O, String UL, List<String> RELS);
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:COMPANY)) WHERE a.`Фамилия` =~ ($F) and a.`Имя` =~ ($I)  and b.`ИИН/БИН`=($UL) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getUlFlPathByFIOwithoutO(String F,String I,String O, String UL, List<String> RELS);

    @Query("MATCH p=shortestPath((a:COMPANY)-[r*]-(b:COMPANY)) where a.`ИИН/БИН`=($UL1) and b.`ИИН/БИН`=($UL2) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getUlUlPath(String UL1, String UL2, List<String> RELS);

    //GET UL UL PATH --------------------------------------------------------
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:Person)) where a.`ИИН`=($FIRST) and b.`ИИН`=($SECOND) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getPathsWithIIN(String FIRST, String SECOND, List<String> RELS);
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:Person)) where a.`Фамилия` =~ ($F1) and a.`Имя` =~ ($I1) and a.`Отчество` =~ ($O1) and b.`Фамилия` =~ ($F2) and b.`Имя` =~ ($I2) and b.`Отчество` =~ ($O2) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getPathsWithFIO(String F1,String I1,String O1, String F2,String I2,String O2, List<String> RELS);
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:Person)) where a.`Фамилия` = ($F1) and a.`Имя` = ($I1) and a.`Отчество` =~ ('.*' + $O1) and b.`Фамилия` = ($F2) and b.`Имя` = ($I2) and b.`Отчество` =~ ('.*' + $O2) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getPathsWithFIOAccurate2(String F1,String I1,String O1, String F2,String I2,String O2, List<String> RELS);
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:Person)) where a.`Фамилия` = ($F1) and a.`Имя` = ($I1) and a.`Отчество` =~ ('.*' + $O1) and b.`Фамилия` =~ ($F2) and b.`Имя` =~ ($I2) and b.`Отчество` =~ ($O2) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getPathsWithFIOAccurate12(String F1,String I1,String O1, String F2,String I2,String O2, List<String> RELS);
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:Person)) where a.`Фамилия` =~ ($F1) and a.`Имя` =~ ($I1) and a.`Отчество` =~ ($O1) and b.`Фамилия` = ($F2) and b.`Имя` = ($I2) and b.`Отчество` =~ ('.*' + $O2) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getPathsWithFIOAccurate21(String F1,String I1,String O1, String F2,String I2,String O2, List<String> RELS);
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:Person)) where a.`Фамилия` =~ ($F1) and a.`Имя` =~ ($I1) and b.`Фамилия` =~ ($F2) and b.`Имя` =~ ($I2) and b.`Отчество` =~ ($O2) and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getPathsWithFIObezs(String F1,String I1,String O1, String F2,String I2,String O2, List<String> RELS);
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:Person)) where a.`Фамилия` =~ ($F1) and a.`Имя` =~ ($I1) and a.`Отчество` =~ ($O1) and b.`Фамилия` =~ ($F2) and b.`Имя` =~ ($I2)  and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getPathsWithFIOsbez(String F1,String I1,String O1, String F2,String I2,String O2, List<String> RELS);
    @Query("MATCH p=shortestPath((a:Person)-[r*]-(b:Person)) where a.`Фамилия` =~ ($F1) and a.`Имя` =~ ($I1)  and b.`Фамилия` =~ ($F2) and b.`Имя` =~ ($I2)  and ALL(rel in relationships(p) WHERE type(rel) in $RELS) RETURN COLLECT(DISTINCT p)")
    List<Persons> getPathsWithFIObezbez(String F1,String I1,String O1, String F2,String I2,String O2, List<String> RELS);

    @Query("WITH $DEPTH as d MATCH (startNode:Person) WHERE startNode.`ИИН` = ($PERSON) OPTIONAL MATCH p = (startNode)-[*1..10]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=d WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTree(String PERSON, @Param("depth") int DEPTH, int LIMIT, List<String> RELS);

    @Query("WITH $params.depth as d MATCH (startNode:Person) WHERE startNode.`ИИН` = ($params.person) OPTIONAL MATCH p = (startNode)-[*1..$depth]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $params.relations) AND length(p)<=d WITH DISTINCT p as paths LIMIT $params.limit RETURN COLLECT(distinct paths)")
    List<Persons> getPersonTree(@Param("params") Value params, @Param("depth") Value depth);

//    @Query("MATCH (startNode) WHERE id(startNode)=$ID OPTIONAL MATCH p = (startNode)-[r]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $relations) WITH DISTINCT p as paths RETURN COLLECT(distinct paths)")
    @Query("MATCH (startNode) WHERE id(startNode) = $ID OPTIONAL MATCH p = (startNode)-[*1..1]-(endNode) WHERE ALL(rel in relationships(p) WHERE type(rel) in $RELS) AND length(p)<=1 WITH DISTINCT p as paths LIMIT $LIMIT RETURN COLLECT(distinct paths)")
    List<Persons> shortOpen(Long ID, List<String> RELS, int LIMIT);

    @Query("MATCH p=(n)-[r]->(e)  where id(r) = $ID RETURN id(startNode(r)) LIMIT 1")
    Long getEndNodeId(Long ID);
    @Query("MATCH p=(n)-[r]->(e)  where id(r) = $ID RETURN id(startNode(r)) LIMIT 1")
    Long getStartNodeId(Long ID);
//    ---------------------------------------------

}
