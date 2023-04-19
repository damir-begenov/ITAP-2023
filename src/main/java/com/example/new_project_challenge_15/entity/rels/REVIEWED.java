package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Movie;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class REVIEWED {
    @Id
    @GeneratedValue
    private Long id;
    private Integer rating;
    private String summary;
    @TargetNode
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "REVIEWED{" +
                "id=" + id +
                ", rating=" + rating +
                ", summary='" + summary + '\'' +
                ", movie=" + movie +
                '}';
    }
}

