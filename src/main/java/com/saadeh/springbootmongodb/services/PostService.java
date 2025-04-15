package com.saadeh.springbootmongodb.services;

import com.saadeh.springbootmongodb.domain.Post;
import com.saadeh.springbootmongodb.repository.PostRepository;
import com.saadeh.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
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

    public List<Post> findByTitle(String text){
        return repo.searchByTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate){
        maxDate = maxDate.plusDays(1L);
        return repo.fullSearch(text, minDate, maxDate);
    }

}
