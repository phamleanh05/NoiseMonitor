//package com.java.NoiseMonitor.service;
//
////import com.java.NoiseMonitor.models.Servicerate;
//import com.java.NoiseMonitor.models.User;
//import com.java.NoiseMonitor.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public Optional<User> findByEmail(@PathVariable String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public Optional<User> findById(@PathVariable Integer id) {
//        return userRepository.findById(id);
//    }
//
//    public void deleteById(@PathVariable Integer id) {userRepository.deleteById(id);}
//
//    public boolean existsById(@PathVariable Integer id) {
//        return userRepository.existsById(id);
//    }
//
////    public User save(@RequestBody User newUser) { return userRepository.save(newUser);}
//}
