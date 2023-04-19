package com.example.new_project_challenge_15.entity;

import java.util.List;
import java.util.Map;

public class relationModel {
    private Long from;
    private Long to;
    private String type;
    private Map<String, Object> properties;

    public relationModel(Long start, Long end, Map<String, Object> propertiesModels) {
        this.from = start;
        this.to = end;
        this.properties = propertiesModels;
    }

    public Long getFrom() {
        return from;
    }
    public Long getTo() {
        return to;
    }
    public String getType() {
        return type;
    }
    public Map<String, Object> getProperties() {
        return properties;
    }
    public void setFrom(Long start) {
        this.from = start;
    }
    public void setTo(Long end) {
        this.to = end;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
