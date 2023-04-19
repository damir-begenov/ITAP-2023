package com.example.new_project_challenge_15.entity;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
public class doubleReturn {
    private List<Nodes> nodes;
    private List<relationModel> edges;

    public doubleReturn() {
    }

    public doubleReturn(List<Nodes> nodes, List<relationModel> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Nodes> getNodes() {
        return nodes;
    }

    public void setNodes(List<Nodes> nodes) {
        this.nodes = nodes;
    }

    public List<relationModel> getEdges() {
        return edges;
    }

    public void setEdges(List<relationModel> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "doubleReturn{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
