package com.example.new_project_challenge_15.entity;

import java.util.Date;

public class edgesModel {
    private String from;
    private String to;


    public edgesModel() {

    }

    public edgesModel(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "edgesModel{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}