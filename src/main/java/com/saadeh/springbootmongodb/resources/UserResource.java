package com.saadeh.springbootmongodb.resources;

import com.saadeh.springbootmongodb.domain.User;
import com.saadeh.springbootmongodb.dto.UserDto;
import com.saadeh.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto){
        User obj = service.fromDto(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserDto objDto,@PathVariable String id){
        User obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
