package com.saadeh.springbootmongodb.repository;

import com.saadeh.springbootmongodb.domain.Post;
import com.saadeh.springbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
