//package com.java.NoiseMonitor.repository;
//
//import com.java.NoiseMonitor.models.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface LoginRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT s FROM User s WHERE s.password = ?1")
//    Optional<User> findByPassword (String username, String password);
//}
