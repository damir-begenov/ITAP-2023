package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Movie;
import com.example.new_project_challenge_15.entity.Person;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class FOLLOWS {
    @Id
    @GeneratedValue
    private Long id;
    @TargetNode
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "FOLLOWS{" +
                "id=" + id +
                ", person=" + person +
                '}';
    }
}
