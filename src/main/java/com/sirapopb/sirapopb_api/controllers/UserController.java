package com.sirapopb.sirapopb_api.controllers;

import com.sirapopb.sirapopb_api.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> data = new ArrayList<User>();
        data.add(new User("Kim","K"));
        data.add(new User("Ky","J"));
        return data;
    }


}
