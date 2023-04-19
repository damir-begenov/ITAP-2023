package com.example.new_project_challenge_15.service;

import com.example.new_project_challenge_15.modelsPhoto.photoDb;
import com.example.new_project_challenge_15.repositoryPhoto.newPhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class newPhotoService {
    @Autowired
    com.example.new_project_challenge_15.repositoryPhoto.newPhotoRepo newPhotoRepo;

    public photoDb getPhotoByIIN(String iin){
        return newPhotoRepo.findByIin(iin);
    }
}
