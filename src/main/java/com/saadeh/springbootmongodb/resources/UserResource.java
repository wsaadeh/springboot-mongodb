package com.saadeh.springbootmongodb.resources;

import com.saadeh.springbootmongodb.domain.User;
import com.saadeh.springbootmongodb.dto.UserDto;
import com.saadeh.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> finAll(){
       List<User> u = service.findAll();
       List<UserDto> listDto = u.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
       return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> finById(@PathVariable String id){
        User u = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(u));
    }
}
