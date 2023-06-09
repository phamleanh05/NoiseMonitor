//package com.java.NoiseMonitor.models;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//
//    private Integer id;
//    private String name;
//
//    private String password;
//    private String email;
//    private String role;
//
//    public User() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(role, user.role);
//    }
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, password, email, role);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "Name='" + name + '\'' +
//                ", Email='" + email + '\'' +
//                ", Role='" + role + '\'' +
//                '}';
//    }
//}
