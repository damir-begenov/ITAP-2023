package com.example.new_project_challenge_15.entity.rels;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Relationshipp {
    @Id
    @GeneratedValue
    private Long identity;
    private int start;
    @TargetNode 
    private int end;
    private String type;
    private Map<String, Object> properties;
    private String elementId;
    private String startNodeElementId;
    private String endNodeElementId;
    
    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public void setIdentity(Long identity) {
        this.identity = identity;
    }
    public void setEndNodeElementId(String endNodeElementId) {
        this.endNodeElementId = endNodeElementId;
    }
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
    public void setStartNodeElementId(String startNodeElementId) {
        this.startNodeElementId = startNodeElementId;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getElementId() {
        return elementId;
    }
    public int getEnd() {
        return end;
    }
    public String getEndNodeElementId() {
        return endNodeElementId;
    }
    public Long getIdentity() {
        return identity;
    }
    public Map<String, Object> getProperties() {
        return properties;
    }
    public int getStart() {
        return start;
    }
    public String getStartNodeElementId() {
        return startNodeElementId;
    }
    public String getType() {
        return type;
    }
    // Getters and setters for the fields
    // ...
}