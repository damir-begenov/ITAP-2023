package com.example.new_project_challenge_15.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Node
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer released;
    private String tagline;

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getTagline() {
        return tagline;
    }
    public Integer getReleased() {
        return released;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setReleased(Integer released) {
        this.released = released;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", released=" + released +
                ", tagline='" + tagline + '\'' +
                '}';
    }
}
