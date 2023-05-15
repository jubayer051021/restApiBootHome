package com.home.jpa.service;

import com.home.jpa.model.User;
import com.home.jpa.repository.UserRepository;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUser(long id){
        return userRepository.findById(id);
    }
   public void addUser(User user){
        userRepository.save(user);
    }
    public void deleteUser(long id){
       userRepository.deleteById(id);
        return;
    }
    public void updateUser(long id,User updateUser){
       Optional<User> optionalUser=userRepository.findById(id);
       if(optionalUser.isPresent()) {
           User user = optionalUser.get();
           user.setUserName(updateUser.getUserName());
           user.setPassword(updateUser.getPassword());
           user.setPhoneNumber(updateUser.getPhoneNumber());
           user.setAddress(updateUser.getAddress());
           userRepository.save(user);
       }
    }
}
