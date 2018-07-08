package com.example.leonardo.avanzado01.repositories;

import com.example.leonardo.avanzado01.classes.User;
import com.orm.SugarRecord;

import java.util.List;

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static List<User> listLogin(String username, String password){
        List<User> user = SugarRecord.find(User.class, "username = ? and password = ?", username, password);
        return user;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String fullname, String username, String password){
        User user = new User(fullname, username, password);
        SugarRecord.save(user);
    }

    public static void update(String fullname, String username, String password, Long id){
        User user = SugarRecord.findById(User.class, id);
        user.setFullname(fullname);
        user.setUsername(username);
        user.setPassword(password);
        SugarRecord.save(user);
    }

    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

}
