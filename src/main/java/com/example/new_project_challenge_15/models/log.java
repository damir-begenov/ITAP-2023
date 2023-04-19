package com.example.new_project_challenge_15.models;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.neo4j.core.schema.Property;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "log")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    private String username;
    @Type(type = "list-array")
    private List<String> request_body;
    @Type(type = "list-array")
    private List<String> request_rels;
    private Integer limit_;
    private Integer depth_;

    private String obwii;

    private String approvement_data;

    public String getApprovement_data() {
        return approvement_data;
    }

    public void setApprovement_data(String approvement_data) {
        this.approvement_data = approvement_data;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRequest_body() {
        return request_body;
    }

    public void setRequest_body(List<String> request_body) {
        this.request_body = request_body;
    }

    public List<String> getRequest_rels() {
        return request_rels;
    }

    public void setRequest_rels(List<String> request_rels) {
        this.request_rels = request_rels;
    }

    public Integer getLimit_() {
        return limit_;
    }

    public void setLimit_(Integer limit_) {
        this.limit_ = limit_;
    }

    public Integer getDepth_() {
        return depth_;
    }

    public void setDepth_(Integer depth_) {
        this.depth_ = depth_;
    }

    public String getObwii() {
        return obwii;
    }

    public void setObwii(String obwii) {
        this.obwii = obwii;
    }
}