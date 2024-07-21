package org.practice.controller;


import org.practice.models.SocialGroup;
import org.practice.models.SocialUser;
import org.practice.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping(value = "/social/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SocialUser>> getAllUsers(){
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/social/groups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SocialGroup>> getAllGroups(){
        return new ResponseEntity<>(socialService.getAllGroups(), HttpStatus.OK);
    }

    @PostMapping(value = "/social/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.CREATED);
    }
}
