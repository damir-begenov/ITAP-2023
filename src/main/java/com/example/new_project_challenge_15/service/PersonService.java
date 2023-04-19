package com.example.new_project_challenge_15.service;

import com.example.new_project_challenge_15.entity.*;
import com.example.new_project_challenge_15.entity.rels.*;
import com.example.new_project_challenge_15.repository.movieRepo;
import com.example.new_project_challenge_15.repository.objectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    objectRepo oRepo;
    @Autowired
    movieRepo movieRepo;
    @Autowired
    com.example.new_project_challenge_15.repository.logRepo logRepo;






//    private doubleReturn ConstructDoubleReturn(List<Person> db) {
//        List<Nodes> nodes = new ArrayList<>();
//        List<relationModel> edges = new ArrayList<>();
//        List<Long> ids = new ArrayList<>();
//        for (Person person : db) {
//            if (!ids.contains(person.getId())) {
//                ids.add(person.getId());
//                Nodes currNode = new Nodes(person.getId(), person.getName(), "", person.getBorn());
//                nodes.add(currNode);
//            }
//            List<ACTED_IN> acted_INs = person.getActed_ins();
//            for (ACTED_IN acted : acted_INs) {
//                List<propertiesModel> properties = new ArrayList<>();
//                for (String role: acted.getRoles()) {
//                    propertiesModel property = new propertiesModel();
//                    property.setName("role");
//                    property.setValue(role);
//                    properties.add(property);
//                }
//                relationModel currRel = new relationModel(person.getId(), acted.getMovie().getId(), properties);
//                currRel.setType("acted_in");
//                edges.add(currRel);
//                if (!ids.contains(acted.getMovie().getId())) {
//                    ids.add(acted.getMovie().getId());
//                    Nodes currMovie = new Nodes(acted.getMovie().getId(), acted.getMovie().getTitle(), acted.getMovie().getTagline(), acted.getMovie().getReleased());
//                    nodes.add(currMovie);
//                }
//            }
//            List<DIRECTED> directeds = person.getDirecteds();
//            for (DIRECTED directed : directeds) {
//                List<propertiesModel> properties = new ArrayList<>();
//                relationModel currRel = new relationModel(person.getId(), directed.getMovie().getId(), properties);
//                currRel.setType("directed");
//                edges.add(currRel);
//                if (!ids.contains(directed.getMovie().getId())) {
//                    ids.add(directed.getMovie().getId());
//                    Nodes currMovie = new Nodes(directed.getMovie().getId(), directed.getMovie().getTitle(), directed.getMovie().getTagline(), directed.getMovie().getReleased());
//                    nodes.add(currMovie);
//                }
//            }
//            List<PRODUCED> produceds = person.getProduceds();
//            for (PRODUCED produced : produceds) {
//                List<propertiesModel> properties = new ArrayList<>();
//                relationModel currRel = new relationModel(person.getId(), produced.getMovie().getId(), properties);
//                currRel.setType("produced");
//                edges.add(currRel);
//                if (!ids.contains(produced.getMovie().getId())) {
//                    ids.add(produced.getMovie().getId());
//                    Nodes currMovie = new Nodes(produced.getMovie().getId(), produced.getMovie().getTitle(), produced.getMovie().getTagline(), produced.getMovie().getReleased());
//                    nodes.add(currMovie);
//                }
//            }
//            List<REVIEWED> revieweds = person.getRevieweds();
//            for (REVIEWED reviewed : revieweds) {
//                List<propertiesModel> properties = new ArrayList<>();
//                propertiesModel newprop = new propertiesModel();
//                newprop.setName("rating");
//                newprop.setValue(""+reviewed.getRating());
//                properties.add(0, newprop);
//                propertiesModel newprop2 = new propertiesModel();
//                newprop2.setName("summary");
//                newprop2.setValue(""+reviewed.getSummary());
//                properties.add(0, newprop2);
//                relationModel currRel = new relationModel(person.getId(), reviewed.getMovie().getId(), properties);
//                currRel.setType("reviewed");
//                edges.add(currRel);
//                if (!ids.contains(reviewed.getMovie().getId())) {
//                    ids.add(reviewed.getMovie().getId());
//                    Nodes currMovie = new Nodes(reviewed.getMovie().getId(), reviewed.getMovie().getTitle(), reviewed.getMovie().getTagline(), reviewed.getMovie().getReleased());
//                    nodes.add(currMovie);
//                }
//            }
//            List<WROTE> wrotes = person.getWrotes();
//            for (WROTE wrote : wrotes) {
//                List<propertiesModel> properties = new ArrayList<>();
//                relationModel currRel = new relationModel(person.getId(), wrote.getMovie().getId(), properties);
//                currRel.setType("wrote");
//                edges.add(currRel);
//                if (!ids.contains(wrote.getMovie().getId())) {
//                    ids.add(wrote.getMovie().getId());
//                    Nodes currMovie = new Nodes(wrote.getMovie().getId(), wrote.getMovie().getTitle(), wrote.getMovie().getTagline(), wrote.getMovie().getReleased());
//                    nodes.add(currMovie);
//                }
//            }
//            List<FOLLOWS> follows = person.getFollows();
//            for (FOLLOWS follows1 : follows) {
//                List<propertiesModel> properties = new ArrayList<>();
//                relationModel currRel = new relationModel(person.getId(), follows1.getPerson().getId(), properties);
//                currRel.setType("follows");
//                edges.add(currRel);
//
//            }
//        }
//        doubleReturn doubleReturn = new doubleReturn(nodes, edges);
//        return doubleReturn;
//    }
//
//
//    public doubleReturn getShortestPaths(String FIRST, String SECOND, List<String> list) {
//        int i = 0;
//        String[] rels = {"", "", "", "", "", ""};
//        for (String rel: list) {
//            rels[i] = rel;
//            i++;
//        }
//        List<Person> db = oRepo.getAllShortestPaths(FIRST, SECOND, rels[0], rels[1], rels[2], rels[3], rels[4], rels[5] );
//        return ConstructDoubleReturn(db);
//    }
//
//    public doubleReturn getPersonTree(String person,List<String> list, int depth,  int LIMIT) {
//        int i = 0;
//        String[] rels = {"", "", "", "", "", ""};
//        for (String rel: list) {
//            rels[i] = rel;
//            i++;
//        }
//        List<Person> db = oRepo.getPersonTree(person, rels[0], rels[1], rels[2], rels[3], rels[4], rels[5], depth, LIMIT);
//        return ConstructDoubleReturn(db);
//    }
//    public doubleReturn getByMovie(String TITLE, List<String> list) {
//        int i = 0;
//        String[] rels = {"", "", "", "", "", ""};
//        for (String rel: list) {
//            rels[i] = rel;
//            i++;
//        }
//        List<Person> db = oRepo.getByMovie(TITLE, rels[0], rels[1], rels[2], rels[3], rels[4], rels[5]);
//        return ConstructDoubleReturn(db);
//    }
//    public log SaveLog(log log){
//        return logRepo.save(log);
//    }
//
//    public doubleReturn getMoviePersonRelation(String PERSON, String MOVIE, List<String> list) {
//        int i = 0;
//        String[] rels = {"", "", "", "", "", ""};
//        for (String rel: list) {
//            rels[i] = rel;
//            i++;
//        }
//        List<Person> db = oRepo.getMoviePersonRelation(PERSON, MOVIE, rels[0], rels[1], rels[2], rels[3], rels[4], rels[5]);
//        return ConstructDoubleReturn(db);
//    }
//
//    public doubleReturn shortOpen(Long id) {
//        List<Person> db = oRepo.shortOpern(id);
//        return ConstructDoubleReturn(db);
//    }
}
