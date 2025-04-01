package com.sirapopb.sirapopb_api.controllers;

import com.sirapopb.sirapopb_api.entity.User;
import com.sirapopb.sirapopb_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService _userService;

    @Autowired
    public UserController(UserService _userService) {
        this._userService = _userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> data = new ArrayList<User>();
        data.add(new User("Kim","K"));
        data.add(new User("Ky","J"));
        return data;
    }

    @PostMapping("/create")
    public User addUser(@RequestBody User user) {
        user.setId(0);//ส่งแค่ชื่อนามสกุลไม่ส่ง id มันรัน auto
        return _userService.save(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {

        return _userService.getAll();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id) {
        User result = _userService.getUserById(id);
        if (result == null){
            throw new RuntimeException("Not found" + id);
        }
        return result;
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        User result = _userService.getUserById(id);
        if (result == null) {
            throw new RuntimeException("Not found id " + id);
        }
        _userService.deleteById(id);
        return ResponseEntity.ok("User with ID " + id + " deleted successfully.");

    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody User newUser) {
        User existingUser = _userService.getUserById(id);

        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID" + id + "not found.");
        }

        _userService.updateById(id, newUser);
        return ResponseEntity.ok("User with ID"+ id + "updated successfully.");
    }

    }
