package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Movie;
import com.example.new_project_challenge_15.entity.Person;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@RelationshipProperties
public class ACTED_IN {
    @Id
    @GeneratedValue
    private Long id;
    private List<String> roles;
    private Long start;
    private Long end;

    public Long getStart() {
        return start;
    }
    public Long getEnd() {
        return end;
    }
    public void setStart(Long start) {
        this.start = start;
    }
    public void setEnd(Long start) {
        this.end = start;
    }
    
    // @TargetNode
    // private Person person;
    @TargetNode
    private Movie movie;

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getId() {
        return "acted_in_"+id;
    }
    

    public void setIdd(Long id) {
        this.id= id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Movie getMovie() {
        return movie;
    }
    



    // @Override
    // public String toString() {
    //     return "ACTED_IN{" +
    //             "id=" + id +
    //             ", roles=" + Arrays.toString(roles) +
    //             ", movie=" + movie +
    //             '}';
    // }
}
