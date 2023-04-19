package com.example.new_project_challenge_15.repositoryPhoto;

import com.example.new_project_challenge_15.modelsPhoto.photoDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface newPhotoRepo extends JpaRepository<photoDb, Long> {
    photoDb findByIin(String iin);
}
