package com.saadeh.springbootmongodb.services;

import com.saadeh.springbootmongodb.domain.User;
import com.saadeh.springbootmongodb.dto.UserDto;
import com.saadeh.springbootmongodb.repository.UserRepository;
import com.saadeh.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Object not found!"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDto(UserDto objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
