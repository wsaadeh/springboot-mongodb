package com.saadeh.springbootmongodb.resources;

import com.saadeh.springbootmongodb.domain.Post;
import com.saadeh.springbootmongodb.domain.User;
import com.saadeh.springbootmongodb.dto.UserDto;
import com.saadeh.springbootmongodb.resources.util.URL;
import com.saadeh.springbootmongodb.services.PostService;
import com.saadeh.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post p = service.findById(id);
        return ResponseEntity.ok().body(p);
    }

    @RequestMapping(value="/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text)
    {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

}
