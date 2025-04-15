package com.saadeh.springbootmongodb.services;

import com.saadeh.springbootmongodb.domain.Post;
import com.saadeh.springbootmongodb.domain.User;
import com.saadeh.springbootmongodb.dto.UserDto;
import com.saadeh.springbootmongodb.repository.PostRepository;
import com.saadeh.springbootmongodb.repository.UserRepository;
import com.saadeh.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(()-> new ObjectNotFoundException("Object not found!"));
    }

}
