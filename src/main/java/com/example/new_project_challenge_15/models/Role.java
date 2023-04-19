package com.example.new_project_challenge_15.models;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;
  @Type(type = "list-array")

  private List<String> relations;
  @Type(type = "list-array")

  private List<String> person_properties;
  @Type(type = "list-array")

  private List<String> company_properties;

  public List<String> getRelations() {
    return relations;
  }

  public void setRelations(List<String> relations) {
    this.relations = relations;
  }

  public List<String> getPerson_properties() {
    return person_properties;
  }

  public void setPerson_properties(List<String> person_properties) {
    this.person_properties = person_properties;
  }

  public List<String> getCompany_properties() {
    return company_properties;
  }

  public void setCompany_properties(List<String> company_properties) {
    this.company_properties = company_properties;
  }

  public Role() {

  }

  public Role(ERole name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Role{" +
            "id=" + id +
            ", name=" + name +
            '}';
  }
}