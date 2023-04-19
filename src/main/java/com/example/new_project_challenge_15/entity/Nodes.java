package com.example.new_project_challenge_15.entity;

import com.example.new_project_challenge_15.modelsPhoto.photoDb;

import java.util.Map;

public class Nodes {
    private Long id;
    private photoDb photoDbf;
    private Map<String, Object> properties;

    public photoDb getPhotoDbf() {
        return photoDbf;
    }

    public void setPhotoDbf(photoDb photoDbf) {
        this.photoDbf = photoDbf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
