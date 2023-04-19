package com.example.new_project_challenge_15.controller;

import com.example.new_project_challenge_15.models.log;
import com.example.new_project_challenge_15.repository.logRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/finpol/main")
@CrossOrigin(origins = "*", maxAge = 3000)

public class LogController {
    @Autowired
    logRepo logRepo;

    @GetMapping("/admin/searchuserlogs")
    public List<log> searchByIdAndId(@RequestParam String value, @RequestParam String username) {
        List<log> result = logRepo.findByUsernameAndInput(username, value);
        return result;
    }

}
