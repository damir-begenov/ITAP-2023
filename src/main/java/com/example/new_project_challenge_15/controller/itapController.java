package com.example.new_project_challenge_15.controller;


import com.example.new_project_challenge_15.entity.*;
import com.example.new_project_challenge_15.models.User;
import com.example.new_project_challenge_15.models.log;
import com.example.new_project_challenge_15.models.user_roles;
import com.example.new_project_challenge_15.repository.*;
import com.example.new_project_challenge_15.security.services.UserDetailsServiceImpl;
import com.example.new_project_challenge_15.service.*;

import lombok.AllArgsConstructor;
//import org.neo4j.springframework.data.core.Neo4jTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Robot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3000)
@RequestMapping("/api/finpol/main")
@AllArgsConstructor
public class itapController {
    PersonService personService;    @Autowired

    UserDetailsServiceImpl userDetailsService;    @Autowired

    statisticService statisticService;    @Autowired

    com.example.new_project_challenge_15.repository.logRepo logRepo;
    UserRepository userRepository;    @Autowired

    RoleRepository rRepo;    @Autowired

    newPersonService newPersonService;    @Autowired

    newAddressRepo newAddressRepo;
    @Autowired

    newCompanyRepo newCompanyRepo;
//    CompanyPersonService companyPersonService;
    @Autowired
    FiPersonsService personsService;

    @Autowired
    LogsService logsService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    user_RolesRepo userRolesRepo;

    @GetMapping("/3users")
    public List<User> get3users(){
        return statisticService.get3users();
    }

    @GetMapping("/logtest")
    public List<log> logTest(){
        return logRepo.findByUsername("damirdamird");

    }

    @GetMapping("/general")
    public Map<String, Object> getAdminStat() {
        int todayRequests = logRepo.findNumberOfRequestsThatRequestedToday();
        int userNumber = userRepository.getUserNum();
        int allLogsNum = logRepo.Number();
        Map<String, Object> stat = new HashMap<>();
        stat.put("todayRequests", todayRequests);
        stat.put("userNumber", userNumber);
        stat.put("allLogsNum", allLogsNum);
        return stat;
    }

    @GetMapping("/admin/users")
    public List<User> getUsersSearch(@RequestParam String value) {
        return userRepository.getUsersByLike(value);
    }
    @GetMapping("/changeUserRole")
//    @PreAuthorize("hasRole('ADMIN')")
    public String getChangeUserRole(@RequestParam String user, @RequestParam String role) {
        Long u = Long.valueOf(user);
        Long r = Long.valueOf(role);
        try {
            user_roles userRoles = userRolesRepo.getById(u);
            userRolesRepo.delete(userRoles);
            userRoles.setUser_id(u);
            userRoles.setRole_id(r);
            userRolesRepo.save(userRoles);
            return "Роль успешно изменена";
        } catch (Exception e){
            user_roles userRoles = new user_roles();
            userRoles.setUser_id(u);
            userRoles.setRole_id(r);
            userRolesRepo.save(userRoles);
            return "Роль успешно изменена";
        } 
    }


    @GetMapping("/getusers")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/getuserdetails")
//    @PreAuthorize("hasRole('ADMIN')")
    public statisticModel getUserDetails(@RequestParam String username) {
        return statisticService.getByUsername(username);
    }



    @GetMapping("/fltree")
    public doubleReturn getFlTree(Principal principal,@RequestParam String person, @RequestParam List<String> relations, @RequestParam int depth, @RequestParam int limit,
                                  @RequestParam(required = false) String orderNum, @RequestParam(required = false) String approvement_type,
                                  @RequestParam(required = false) String caseNum,
                                  @RequestParam(required = false) String orderDate,
                                  @RequestParam(required = false) String articleName,
                                  @RequestParam(required = false) String checkingName,
                                  @RequestParam(required = false) String otherReasons,
                                  @RequestParam(required = false) String organName,
                                  @RequestParam(required = false) String sphereName,
                                  @RequestParam(required = false) String tematikName,
                                  @RequestParam(required = false) String rukName) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add(person);
        log log = new log();
        String obwii = "Раскрыть связь ФЛ: " + person+ ", лимит: " + limit + ", уровень: " + depth;
        List<String> approvements = new ArrayList<>();
        String approvement_data = "";
        if (approvement_type != "") {
            approvements.add("ОСНОВАНИЕ ПРОВЕРКИ: " + approvement_type);
        }
        if (orderNum != "") {
            approvements.add("НОМЕР ПРИКАЗА:" + orderNum);
        }
        if (caseNum != "") {
            approvements.add("НОМЕР ДЕЛА: " + caseNum);
        }
        if (orderDate != "") {
            approvements.add("ДАТА ПРИКАЗА: " + orderDate);
        }
        if (articleName != "") {
            approvements.add("НАЗВАНИЕ СТАТЬИ: " + articleName);
        }
        if (checkingName != "") {
            approvements.add("ИМЯ ПРОВЕРЯЮЩЕГО: " + checkingName);
        }
        if (otherReasons != "") {
            approvements.add("ДРУГАЯ ПРИЧИНА: " + otherReasons);
        }
        if (organName != "") {
            approvements.add("НАЗВАНИЕ ОРГАНА: " + organName);
        }
        if (sphereName != "") {
            approvements.add("НАЗВАНИЕ СФЕРЫ: " + sphereName);
        }
        if (tematikName != "") {
            approvements.add("НАЗВАНИЕ ТЕМАТИКИ: " + tematikName);
        }
        if (rukName != "") {
            approvements.add("ИМЯ РУКОВОДИТЕЛЯ: " + rukName);
        }
        for (String reason: approvements) {
            approvement_data = approvement_data + reason + ", ";
        }
        log.setObwii(obwii);
        log.setApprovement_data(approvement_data);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setLimit_(limit);
        log.setDepth_(depth);
        log.setRequest_body(request_bodies);
        log.setRequest_rels(relations);
        logsService.SaveLog(log);
        return personsService.getPersonTree(user.getId(), person, depth, limit, relations);
    }
    @GetMapping("/flFIOtree")
    public doubleReturn getFlTree(@RequestParam String lastName1,@RequestParam String firstName1,@RequestParam String fatherName1, @RequestParam List<String> relations, @RequestParam int depth, @RequestParam int limit, @RequestParam(required = false) String orderNum,
                                  @RequestParam(required = false) String caseNum, @RequestParam(required = false) String approvement_type,
                                  @RequestParam(required = false) String orderDate,
                                  @RequestParam(required = false) String articleName,
                                  @RequestParam(required = false) String checkingName,
                                  @RequestParam(required = false) String otherReasons,
                                  @RequestParam(required = false) String organName,
                                  @RequestParam(required = false) String sphereName,
                                  @RequestParam(required = false) String tematikName,
                                  @RequestParam(required = false) String rukName,Principal principal,
                                  @RequestParam(required = false) boolean check1) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add(lastName1 + " " + firstName1 + " " + fatherName1);
        log log = new log();
        String obwii = "Раскрыть связь ФЛ: " + lastName1 + " " + firstName1 + " " + fatherName1 + ", лимит: " + limit + ", уровень: " + depth;
        List<String> approvements = new ArrayList<>();
        String approvement_data = "";
        if (approvement_type != "") {
            approvements.add("ОСНОВАНИЕ ПРОВЕРКИ: " + approvement_type);
        }
        if (orderNum != "") {
            approvements.add("НОМЕР ПРИКАЗА:" + orderNum);
        }
        if (caseNum != "") {
            approvements.add("НОМЕР ДЕЛА: " + caseNum);
        }
        if (orderDate != "") {
            approvements.add("ДАТА ПРИКАЗА: " + orderDate);
        }
        if (articleName != "") {
            approvements.add("НАЗВАНИЕ СТАТЬИ: " + articleName);
        }
        if (checkingName != "") {
            approvements.add("ИМЯ ПРОВЕРЯЮЩЕГО: " + checkingName);
        }
        if (otherReasons != "") {
            approvements.add("ДРУГАЯ ПРИЧИНА: " + otherReasons);
        }
        if (organName != "") {
            approvements.add("НАЗВАНИЕ ОРГАНА: " + organName);
        }
        if (sphereName != "") {
            approvements.add("НАЗВАНИЕ СФЕРЫ: " + sphereName);
        }
        if (tematikName != "") {
            approvements.add("НАЗВАНИЕ ТЕМАТИКИ: " + tematikName);
        }
        if (rukName != "") {
            approvements.add("ИМЯ РУКОВОДИТЕЛЯ: " + rukName);
        }
        for (String reason: approvements) {
            approvement_data = approvement_data + reason + ", ";
        }
        log.setObwii(obwii);
        log.setApprovement_data(approvement_data);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setLimit_(limit);
        log.setDepth_(depth);
        log.setRequest_body(request_bodies);
        log.setRequest_rels(relations);
        logsService.SaveLog(log);
        System.out.println(check1);
        System.out.println(fatherName1.contains(".*"));
        if (fatherName1.contains(".*") ){
            System.out.println(lastName1.toUpperCase());
            return personsService.getPersonByFIO_withoutO(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(), depth, limit, relations);
        }
        System.out.println(check1);
        if(fatherName1.equals("")  & check1 == true){
            return personsService.getPersonByFIO_Accurate(user.getId(),lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),depth,limit,relations);
        }
        if(!fatherName1.equals("")  & check1 == true){
            return personsService.getPersonByFIO_Accurate(user.getId(),lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),depth,limit,relations);
        }
        if (fatherName1.equals(".*") || fatherName1.equals(".*.*") ){
            System.out.println(lastName1.toUpperCase());
            return personsService.getPersonByFIO_withoutO(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(), depth, limit, relations);
        }
//        System.out.println(lastName1.toUpperCase());
        return personsService.getPersonByFIO_(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(), depth, limit, relations);
    }

    @GetMapping("/shortestpaths")
//    @PreAuthorize("hasRole('LEVEL_3_USER') or hasRole('LEVEL_2_USER') or hasRole('LEVEL_1_USER') or hasRole('VIP') or hasRole('ADMIN')")
    public doubleReturn getShortestPaths(@RequestParam String person, @RequestParam String person2, @RequestParam List<String> relations, @RequestParam(required = false) String orderNum,
                                         @RequestParam(required = false) String caseNum, @RequestParam(required = false) String approvement_type,
                                         @RequestParam(required = false) String orderDate,
                                         @RequestParam(required = false) String articleName,
                                         @RequestParam(required = false) String checkingName,
                                         @RequestParam(required = false) String otherReasons,
                                         @RequestParam(required = false) String organName,
                                         @RequestParam(required = false) String sphereName,
                                         @RequestParam(required = false) String tematikName,
                                         @RequestParam(required = false) String rukName,Principal principal) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add(person);
        request_bodies.add(person2);
        log log = new log();
        String obwii = "Ракрыть путь ФЛ-ФЛ: " + person+ " и " + person2;
        List<String> approvements = new ArrayList<>();
        String approvement_data = "";
        if (approvement_type != null) {
            approvements.add("ОСНОВАНИЕ ПРОВЕРКИ: " + approvement_type);
        }
        if (orderNum != null) {
            approvements.add("НОМЕР ПРИКАЗА:" + orderNum);
        }
        if (caseNum != null) {
            approvements.add("НОМЕР ДЕЛА: " + caseNum);
        }
        if (orderDate != null) {
            approvements.add("ДАТА ПРИКАЗА: " + orderDate);
        }
        if (articleName != null) {
            approvements.add("НАЗВАНИЕ СТАТЬИ: " + articleName);
        }
        if (checkingName != null) {
            approvements.add("ИМЯ ПРОВЕРЯЮЩЕГО: " + checkingName);
        }
        if (otherReasons != null) {
            approvements.add("ДРУГАЯ ПРИЧИНА: " + otherReasons);
        }
        if (organName != null) {
            approvements.add("НАЗВАНИЕ ОРГАНА: " + organName);
        }
        if (sphereName != null) {
            approvements.add("НАЗВАНИЕ СФЕРЫ: " + sphereName);
        }
        if (tematikName != null) {
            approvements.add("НАЗВАНИЕ ТЕМАТИКИ: " + tematikName);
        }
        if (rukName != null) {
            approvements.add("ИМЯ РУКОВОДИТЕЛЯ: " + rukName);
        }
        for (String reason: approvements) {
            approvement_data = approvement_data + reason + ", ";
        }
        log.setObwii(obwii);
        log.setApprovement_data(approvement_data);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setRequest_body(request_bodies);
        log.setRequest_rels(relations);
        logsService.SaveLog(log);
        return personsService.getShortestPaths(user.getId(), person, person2, relations);
    }
    @GetMapping("/shortestpathsByFIO")
//    @PreAuthorize("hasRole('LEVEL_3_USER') or hasRole('LEVEL_2_USER') or hasRole('LEVEL_1_USER') or hasRole('VIP') or hasRole('ADMIN')")
    public doubleReturn getShortestPathsByFIO(@RequestParam String lastName1,@RequestParam String firstName1,@RequestParam String fatherName1,@RequestParam String lastName2,@RequestParam String firstName2,@RequestParam String fatherName2, @RequestParam List<String> relations, @RequestParam(required = false) String orderNum,
                                         @RequestParam(required = false) String caseNum, @RequestParam(required = false) String approvement_type,
                                         @RequestParam(required = false) String orderDate,
                                         @RequestParam(required = false) String articleName,
                                         @RequestParam(required = false) String checkingName,
                                         @RequestParam(required = false) String otherReasons,
                                         @RequestParam(required = false) String organName,
                                         @RequestParam(required = false) String sphereName,
                                         @RequestParam(required = false) String tematikName,
                                         @RequestParam(required = false) String rukName,Principal principal,
                                              @RequestParam(required = false) boolean check1,
                                              @RequestParam(required = false) boolean check2) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add("Фамилия: " + lastName1 + ", имя: " + firstName1 + ", отчество: " + fatherName1);
        request_bodies.add("Фамилия: " + lastName2 + ", имя: " + firstName2 + ", отчество: " + fatherName2);
        log log = new log();
        String obwii = "Ракрыть путь ФЛ-ФЛ: " + request_bodies.get(0) + ", " + request_bodies.get(1);
        List<String> approvements = new ArrayList<>();
        String approvement_data = "";
        if (approvement_type != null) {
            approvements.add("ОСНОВАНИЕ ПРОВЕРКИ: " + approvement_type);
        }
        if (orderNum != null) {
            approvements.add("НОМЕР ПРИКАЗА:" + orderNum);
        }
        if (caseNum != null) {
            approvements.add("НОМЕР ДЕЛА: " + caseNum);
        }
        if (orderDate != null) {
            approvements.add("ДАТА ПРИКАЗА: " + orderDate);
        }
        if (articleName != null) {
            approvements.add("НАЗВАНИЕ СТАТЬИ: " + articleName);
        }
        if (checkingName != null) {
            approvements.add("ИМЯ ПРОВЕРЯЮЩЕГО: " + checkingName);
        }
        if (otherReasons != null) {
            approvements.add("ДРУГАЯ ПРИЧИНА: " + otherReasons);
        }
        if (organName != null) {
            approvements.add("НАЗВАНИЕ ОРГАНА: " + organName);
        }
        if (sphereName != null) {
            approvements.add("НАЗВАНИЕ СФЕРЫ: " + sphereName);
        }
        if (tematikName != null) {
            approvements.add("НАЗВАНИЕ ТЕМАТИКИ: " + tematikName);
        }
        if (rukName != null) {
            approvements.add("ИМЯ РУКОВОДИТЕЛЯ: " + rukName);
        }
        for (String reason: approvements) {
            approvement_data = approvement_data + reason + ", ";
        }
        log.setObwii(obwii);
        log.setApprovement_data(approvement_data);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setRequest_body(request_bodies);
        log.setRequest_rels(relations);
        logsService.SaveLog(log);
        System.out.println(check1);
        System.out.println(check2);

        if(check1 == true & check2 == true){
            return personsService.getShortestPathWithFIOAccurate(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),lastName2.toUpperCase(),firstName2.toUpperCase(),fatherName2.toUpperCase(), relations);
        }
        if(check1 == true & check2 == false){
            return personsService.getShortestPathWithFIOAccurate12(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),lastName2.toUpperCase(),firstName2.toUpperCase(),fatherName2.toUpperCase(), relations);
        }
        if(check1 == false & check2 == true){
            return personsService.getShortestPathWithFIOAccurate21(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),lastName2.toUpperCase(),firstName2.toUpperCase(),fatherName2.toUpperCase(), relations);
        }
        if(fatherName1 == "" & fatherName2 == ""){
            return personsService.getShortestPathWithFIObezbez(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),lastName2.toUpperCase(),firstName2.toUpperCase(),fatherName2.toUpperCase(), relations);
        }
        if(fatherName1 == "" & fatherName2 != ""){
            return personsService.getShortestPathWithFIObezs(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),lastName2.toUpperCase(),firstName2.toUpperCase(),fatherName2.toUpperCase(), relations);
        }
        if(fatherName1 != "" & fatherName2 == ""){
            return personsService.getShortestPathWithFIOsbez(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),lastName2.toUpperCase(),firstName2.toUpperCase(),fatherName2.toUpperCase(), relations);
        }

        return personsService.getShortestPathWithFIO(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),lastName2.toUpperCase(),firstName2.toUpperCase(),fatherName2.toUpperCase(), relations);
    }
    @GetMapping("/ultree")
//    @PreAuthorize("hasRole('LEVEL_3_USER') or hasRole('LEVEL_2_USER') or hasRole('LEVEL_1_USER') or hasRole('VIP') or hasRole('ADMIN')")
    public doubleReturn getUlTree(@RequestParam String ul, @RequestParam List<String> relations, @RequestParam int depth, @RequestParam int limit, @RequestParam(required = false) String orderNum,
                                  @RequestParam(required = false) String caseNum, @RequestParam(required = false) String approvement_type,
                                  @RequestParam(required = false) String orderDate,
                                  @RequestParam(required = false) String articleName,
                                  @RequestParam(required = false) String checkingName,
                                  @RequestParam(required = false) String otherReasons,
                                  @RequestParam(required = false) String organName,
                                  @RequestParam(required = false) String sphereName,
                                  @RequestParam(required = false) String tematikName,
                                  @RequestParam(required = false) String rukName,Principal principal) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add(ul);
        log log = new log();
        String obwii = "Раскрыть связь ЮЛ: " + ul + ", лимит: " + limit + ", уровень: " + depth;
        List<String> approvements = new ArrayList<>();
        String approvement_data = "";
        if (approvement_type != null) {
            approvements.add("ОСНОВАНИЕ ПРОВЕРКИ: " + approvement_type);
        }
        if (orderNum != null) {
            approvements.add("НОМЕР ПРИКАЗА:" + orderNum);
        }
        if (caseNum != null) {
            approvements.add("НОМЕР ДЕЛА: " + caseNum);
        }
        if (orderDate != null) {
            approvements.add("ДАТА ПРИКАЗА: " + orderDate);
        }
        if (articleName != null) {
            approvements.add("НАЗВАНИЕ СТАТЬИ: " + articleName);
        }
        if (checkingName != null) {
            approvements.add("ИМЯ ПРОВЕРЯЮЩЕГО: " + checkingName);
        }
        if (otherReasons != null) {
            approvements.add("ДРУГАЯ ПРИЧИНА: " + otherReasons);
        }
        if (organName != null) {
            approvements.add("НАЗВАНИЕ ОРГАНА: " + organName);
        }
        if (sphereName != null) {
            approvements.add("НАЗВАНИЕ СФЕРЫ: " + sphereName);
        }
        if (tematikName != null) {
            approvements.add("НАЗВАНИЕ ТЕМАТИКИ: " + tematikName);
        }
        if (rukName != null) {
            approvements.add("ИМЯ РУКОВОДИТЕЛЯ: " + rukName);
        }
        for (String reason: approvements) {
            approvement_data = approvement_data + reason + ", ";
        }
        log.setObwii(obwii);
        log.setApprovement_data(approvement_data);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setLimit_(limit);
        log.setDepth_(depth);
        log.setRequest_body(request_bodies);
        log.setRequest_rels(relations);
        logsService.SaveLog(log);
        return personsService.getUlTree(user.getId(), ul, relations, depth, limit);
    }
    @GetMapping("/flulpath")
//    @PreAuthorize("hasRole('LEVEL_3_USER') or hasRole('LEVEL_2_USER') or hasRole('LEVEL_1_USER') or hasRole('VIP') or hasRole('ADMIN')")
    public doubleReturn getUlFlPath(@RequestParam String ul, @RequestParam String person, @RequestParam List<String> relations, @RequestParam(required = false) String orderNum,
                                    @RequestParam(required = false) String caseNum, @RequestParam(required = false) String approvement_type,
                                    @RequestParam(required = false) String orderDate,
                                    @RequestParam(required = false) String articleName,
                                    @RequestParam(required = false) String checkingName,
                                    @RequestParam(required = false) String otherReasons,
                                    @RequestParam(required = false) String organName,
                                    @RequestParam(required = false) String sphereName,
                                    @RequestParam(required = false) String tematikName,
                                    @RequestParam(required = false) String rukName,Principal principal) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add("ФЛ: " + person);
        request_bodies.add("ЮЛ: " + ul);
        log log = new log();
        String obwii = "Ракрыть путь ФЛ-ЮЛ: " + request_bodies.get(0) + ", " + request_bodies.get(1);
        List<String> approvements = new ArrayList<>();
        String approvement_data = "";
        if (approvement_type != null) {
            approvements.add("ОСНОВАНИЕ ПРОВЕРКИ: " + approvement_type);
        }
        if (orderNum != null) {
            approvements.add("НОМЕР ПРИКАЗА:" + orderNum);
        }
        if (caseNum != null) {
            approvements.add("НОМЕР ДЕЛА: " + caseNum);
        }
        if (orderDate != null) {
            approvements.add("ДАТА ПРИКАЗА: " + orderDate);
        }
        if (articleName != null) {
            approvements.add("НАЗВАНИЕ СТАТЬИ: " + articleName);
        }
        if (checkingName != null) {
            approvements.add("ИМЯ ПРОВЕРЯЮЩЕГО: " + checkingName);
        }
        if (otherReasons != null) {
            approvements.add("ДРУГАЯ ПРИЧИНА: " + otherReasons);
        }
        if (organName != null) {
            approvements.add("НАЗВАНИЕ ОРГАНА: " + organName);
        }
        if (sphereName != null) {
            approvements.add("НАЗВАНИЕ СФЕРЫ: " + sphereName);
        }
        if (tematikName != null) {
            approvements.add("НАЗВАНИЕ ТЕМАТИКИ: " + tematikName);
        }
        if (rukName != null) {
            approvements.add("ИМЯ РУКОВОДИТЕЛЯ: " + rukName);
        }
        for (String reason: approvements) {
            approvement_data = approvement_data + reason + ", ";
        }
        log.setObwii(obwii);
        log.setApprovement_data(approvement_data);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setRequest_body(request_bodies);
        log.setRequest_rels(relations);
        logsService.SaveLog(log);
        return personsService.getUlFlPath(user.getId(), ul, person, relations);
    }

    @GetMapping("/flulpathByFIO")
//    @PreAuthorize("hasRole('LEVEL_3_USER') or hasRole('LEVEL_2_USER') or hasRole('LEVEL_1_USER') or hasRole('VIP') or hasRole('ADMIN')")
    public doubleReturn getUlFlPathByFIO(@RequestParam String ul, @RequestParam String lastName1,@RequestParam String firstName1,@RequestParam String fatherName1, @RequestParam List<String> relations, @RequestParam(required = false) String orderNum,
                                    @RequestParam(required = false) String caseNum, @RequestParam(required = false) String approvement_type,
                                    @RequestParam(required = false) String orderDate,
                                    @RequestParam(required = false) String articleName,
                                    @RequestParam(required = false) String checkingName,
                                    @RequestParam(required = false) String otherReasons,
                                    @RequestParam(required = false) String organName,
                                    @RequestParam(required = false) String sphereName,
                                    @RequestParam(required = false) String tematikName,
                                    @RequestParam(required = false) String rukName,Principal principal,
                                         @RequestParam(required = false) boolean check1) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add("Фамилия: " + lastName1 + ", имя: " + firstName1 + ", отчество: " + fatherName1);
        request_bodies.add("ЮЛ: " + ul);
        log log = new log();
        String obwii = "Ракрыть путь ФЛ-ЮЛ: " + request_bodies.get(0) + ", " + request_bodies.get(1);
        List<String> approvements = new ArrayList<>();
        String approvement_data = "";
        if (approvement_type != null) {
            approvements.add("ОСНОВАНИЕ ПРОВЕРКИ: " + approvement_type);
        }
        if (orderNum != null) {
            approvements.add("НОМЕР ПРИКАЗА:" + orderNum);
        }
        if (caseNum != null) {
            approvements.add("НОМЕР ДЕЛА: " + caseNum);
        }
        if (orderDate != null) {
            approvements.add("ДАТА ПРИКАЗА: " + orderDate);
        }
        if (articleName != null) {
            approvements.add("НАЗВАНИЕ СТАТЬИ: " + articleName);
        }
        if (checkingName != null) {
            approvements.add("ИМЯ ПРОВЕРЯЮЩЕГО: " + checkingName);
        }
        if (otherReasons != null) {
            approvements.add("ДРУГАЯ ПРИЧИНА: " + otherReasons);
        }
        if (organName != null) {
            approvements.add("НАЗВАНИЕ ОРГАНА: " + organName);
        }
        if (sphereName != null) {
            approvements.add("НАЗВАНИЕ СФЕРЫ: " + sphereName);
        }
        if (tematikName != null) {
            approvements.add("НАЗВАНИЕ ТЕМАТИКИ: " + tematikName);
        }
        if (rukName != null) {
            approvements.add("ИМЯ РУКОВОДИТЕЛЯ: " + rukName);
        }
        for (String reason: approvements) {
            approvement_data = approvement_data + reason + ", ";
        }
        log.setObwii(obwii);
        log.setApprovement_data(approvement_data);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setRequest_body(request_bodies);
        log.setRequest_rels(relations);
        logsService.SaveLog(log);
        if(fatherName1.equals("")  & check1 == true){
            return personsService.getUlFlPathByFIOAccurate(user.getId(),lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),ul,relations);
        }
        if (fatherName1.equals(".*") || fatherName1.equals(".*.*") ){
            System.out.println(lastName1.toUpperCase());
            return personsService.getUlFlPathByFIOwithoutO(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(), ul, relations);
        }
        if (fatherName1.contains(".*") ){
            System.out.println(lastName1.toUpperCase());
            return personsService.getUlFlPathByFIOwithoutO(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(), ul, relations);
        }
        if(!fatherName1.equals("")  & check1 == true){
            return personsService.getUlFlPathByFIOAccurate(user.getId(),lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),ul,relations);
        }
        return personsService.getUlFlPathByFIO(user.getId(), lastName1.toUpperCase(),firstName1.toUpperCase(),fatherName1.toUpperCase(),ul, relations);
    }

    @GetMapping("/ululpath")
//    @PreAuthorize("hasRole('LEVEL_3_USER') or hasRole('LEVEL_2_USER') or hasRole('LEVEL_1_USER') or hasRole('VIP') or hasRole('ADMIN')")
    public doubleReturn getUlUlPath(@RequestParam String ul1,@RequestParam String ul2,@RequestParam List<String> relations,
                                    @RequestParam(required = false) String approvement_type,
                                    @RequestParam(required = false) String orderNum,
                                    @RequestParam(required = false) String caseNum,
                                    @RequestParam(required = false) String orderDate,
                                    @RequestParam(required = false) String articleName,
                                    @RequestParam(required = false) String checkingName,
                                    @RequestParam(required = false) String otherReasons,
                                    @RequestParam(required = false) String organName,
                                    @RequestParam(required = false) String sphereName,
                                    @RequestParam(required = false) String tematikName,
                                    @RequestParam(required = false) String rukName,Principal principal) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add(ul1);
        request_bodies.add(ul2);
        log log = new log();
        String obwii = "Ракрыть путь ЮЛ-ЮЛ: " + request_bodies.get(0) + ", " + request_bodies.get(1);
        List<String> approvements = new ArrayList<>();
        String approvement_data = "";
        if (approvement_type != null) {
            approvements.add("ОСНОВАНИЕ ПРОВЕРКИ: " + approvement_type);
        }
        if (orderNum != null) {
            approvements.add("НОМЕР ПРИКАЗА:" + orderNum);
        }
        if (caseNum != null) {
            approvements.add("НОМЕР ДЕЛА: " + caseNum);
        }
        if (orderDate != null) {
            approvements.add("ДАТА ПРИКАЗА: " + orderDate);
        }
        if (articleName != null) {
            approvements.add("НАЗВАНИЕ СТАТЬИ: " + articleName);
        }
        if (checkingName != null) {
            approvements.add("ИМЯ ПРОВЕРЯЮЩЕГО: " + checkingName);
        }
        if (otherReasons != null) {
            approvements.add("ДРУГАЯ ПРИЧИНА: " + otherReasons);
        }
        if (organName != null) {
            approvements.add("НАЗВАНИЕ ОРГАНА: " + organName);
        }
        if (sphereName != null) {
            approvements.add("НАЗВАНИЕ СФЕРЫ: " + sphereName);
        }
        if (tematikName != null) {
            approvements.add("НАЗВАНИЕ ТЕМАТИКИ: " + tematikName);
        }
        if (rukName != null) {
            approvements.add("ИМЯ РУКОВОДИТЕЛЯ: " + rukName);
        }
        for (String reason: approvements) {
            approvement_data = approvement_data + reason + ", ";
        }
        log.setObwii(obwii);
        log.setApprovement_data(approvement_data);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setRequest_body(request_bodies);
        log.setRequest_rels(relations);
        logsService.SaveLog(log);
        return personsService.getUlUlPath(user.getId(), ul1, ul2, relations);
    }

    @GetMapping("/shortopen")
//    @PreAuthorize("hasRole('LEVEL_3_USER') or hasRole('LEVEL_2_USER') or hasRole('LEVEL_1_USER') or hasRole('VIP') or hasRole('ADMIN')")
    public doubleReturn getShortOpen(@RequestParam Long id, @RequestParam List<String> relations, @RequestParam int limit, Principal principal) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        relations = personsService.filterRelations(user.getId(), relations);
        doubleReturn resul = personsService.shortOpen(user.getId(), id, relations, limit);
        return resul;
    }

    @GetMapping("/downloadedscheme")
//    @PreAuthorize("hasRole('LEVEL_3_USER') or hasRole('LEVEL_2_USER') or hasRole('LEVEL_1_USER') or hasRole('VIP') or hasRole('ADMIN')")
    public void downloadScheme(@RequestParam String first, @RequestParam String second, Principal principal) {
        User user = userDetailsService.loadUserByUsernamek(principal);
        List<String> request_bodies = new ArrayList<>();
        request_bodies.add(first);
        request_bodies.add(second);
        log log = new log();
        String obwii = "Скачал схему: " + request_bodies.get(0) + ", " + request_bodies.get(1);
        log.setObwii(obwii);
        LocalDateTime current = LocalDateTime.now();
        log.setUsername(user.getUsername());
        log.setDate(current);
        log.setRequest_body(request_bodies);
        logsService.SaveLog(log);
    }



    @GetMapping("/newd")
    public String getNdew() {
        try{
            Robot robot = new Robot();
            System.out.println("sds");
            Rectangle rectangle = new Rectangle(0,0,500,500);
            System.out.println("sds");

            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);

            ImageIO.write(bufferedImage,"JPG",new File("C:\\Users\\123\\Desktop\\project-aitab\\new_pj_15\\sreenshot.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "privet";
    }
//    @GetMapping("/photo")
//    public photoDb getPhoto(){
//        photoDb photoDb = newPhotoRepo.findByIin("040210551264");
//        System.out.println(photoDb.getPhoto());
//        return newPhotoRepo.findByIin("040502651337");
//    }

//    @GetMapping("/test")
//    public doubleReturn testDoubleReturn() {
//        return companyPersonService.Test();
//    }
//
//    @GetMapping("/fltree")
//    public

//
//    @GetMapping("/statistic")
//    public statisticModel getUserLogs(@RequestParam String username) {
//        return statisticService.getByUsername(username);
//    }
//    @PostMapping("/admin/user/ban/{id}")
//    public void userBan(@PathVariable("id") Long id){
//        statisticService.userBan(id);
//    }
//    @PostMapping("/admin/user/moderator/{id}")
//    public void userModerator(@PathVariable("id") Long id){
//        statisticService.userSetAdministrator(id);
//    }
//
//    @PostMapping("/updaterole")
//    public void updateRole(@RequestParam Integer id, @RequestParam Integer Role) {
//        userRepository.updateRole(id, Role);
//    }
//
//    @GetMapping("/role")
//    public String getRole(@RequestParam Integer id) {
//        return rRepo.FindRole(id);
//    }
//
//    @GetMapping("/logs")
//    public List<log> getLogs() {
//        return logRepo.findAll();
//    }
//
//
//    @GetMapping("/users")
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/person")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public doubleReturn getByIdLevelAndLimit(@RequestParam String person, @RequestParam List<String> relations, @RequestParam int depth, @RequestParam int limit, Principal principal) throws Exception{
//        User user  = userDetailsService.loadUserByUsernamek(principal);
//        List<String> request_bodies = new ArrayList<>();
//
//        request_bodies.add(person);
//
//        try{
//            log log = new log();
//            LocalDateTime current = LocalDateTime.now();
//            log.setDate(current);
//            log.setUsername(user.getUsername());
//            log.setRequest_body(request_bodies);
//            log.setLimit_(limit);
//            log.setDepth_(depth);
//            log.setRequest_rels(relations);
//            personService.SaveLog(log);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        List<User> users = userRepository.findAll();
//        System.out.println(users);
//        return personService.getPersonTree(person, relations, depth, limit);
//    }

//    @GetMapping("/shortestpaths")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public doubleReturn getShortestPaths(@RequestParam String person, @RequestParam String person2, @RequestParam List<String> relations, Principal principal) {
//        User user  = userDetailsService.loadUserByUsernamek(principal);
//        List<String> request_bodies = new ArrayList<>();
//        request_bodies.add(person);
//        request_bodies.add(person2);
//        try{
//            log log = new log();
//            LocalDateTime current = LocalDateTime.now();
//            log.setDate(current);
//            log.setUsername(user.getUsername());
//            log.setRequest_body(request_bodies);
//            log.setRequest_rels(relations);
//            personService.SaveLog(log);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return personService.getShortestPaths(person, person2, relations);
//    }
//
//    @GetMapping("/movie")
//    public doubleReturn retrieveMovie(@RequestParam String title, @RequestParam List<String> relations, Principal principal) {
//        User user  = userDetailsService.loadUserByUsernamek(principal);
//        List<String> request_bodies = new ArrayList<>();
//        request_bodies.add(title);
//        try{
//            log log = new log();
//            LocalDateTime current = LocalDateTime.now();
//            log.setDate(current);
//            log.setUsername(user.getUsername());
//            log.setRequest_body(request_bodies);
//            log.setRequest_rels(relations);
//            personService.SaveLog(log);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return personService.getByMovie(title, relations);
//    }
//    @GetMapping("/movieperson")
//    public doubleReturn moviePersonRelation(@RequestParam String person, @RequestParam String movie, @RequestParam List<String> relations, Principal principal ) {
//        User user  = userDetailsService.loadUserByUsernamek(principal);
//        List<String> request_bodies = new ArrayList<>();
//        request_bodies.add(person);
//        request_bodies.add(movie);
//        try{
//            log log = new log();
//            LocalDateTime current = LocalDateTime.now();
//            log.setDate(current);
//            log.setUsername(user.getUsername());
//            log.setRequest_body(request_bodies);
//            log.setRequest_rels(relations);
//            personService.SaveLog(log);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return personService.getMoviePersonRelation(person, movie, relations);
//    }
//    @GetMapping("/shortopen")
//    public doubleReturn shortOpen(@RequestParam Long id) {
//        return personService.shortOpen(id);
//    }

}
