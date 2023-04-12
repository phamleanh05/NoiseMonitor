//package com.java.NoiseMonitor.service;
//
//import com.java.NoiseMonitor.models.User;
//import com.java.NoiseMonitor.repository.LoginRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoginService {
//    @Autowired
//    private LoginRepository loginRepository;
//
//    public LoginService(LoginRepository loginRepository) {
//        this.loginRepository = loginRepository;
//    }
//
//    public User registerUser(String username, String password, String email, String role){
//        if(username != null && password != null){
//            return null;
//        }else {
//            User user = new User();
//            user.setName(username);
//            user.setPassword(password);
//            user.setEmail(email);
//            user.setRole(role);
//            return loginRepository.save(user);
//        }
//    }
//
//    public User authenticate(String username, String password){
//        return loginRepository.findByPassword(username,password).orElse(null);
//    }
//}
