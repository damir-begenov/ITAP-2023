package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Movie;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class DIRECTED {
    @Id
    @GeneratedValue
    private Long id;
    @TargetNode
    private Movie movie;

    public String getId() {
        return "directed_in_"+id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "DIRECTED{" +
                "id=" + id +
                ", movie=" + movie +
                '}';
    }
}
