package com.example.new_project_challenge_15.entity;

import java.util.Set;

public class nodeStudentModel {
    private Long id;
    private Integer born;
    private String name;
    private String BIN_IIN;
    private boolean main;

    public nodeStudentModel(Long id, Integer born, String name, boolean main) {
        this.id = id;
        this.born = born;
        this.name = name;
        this.main = main;
    }

    public nodeStudentModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }



    public String getBIN_IIN() {
        return BIN_IIN;
    }

    public void setBIN_IIN(String BIN_IIN) {
        this.BIN_IIN = BIN_IIN;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
}
