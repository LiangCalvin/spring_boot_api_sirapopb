package com.sirapopb.sirapopb_api.controllers;

import com.sirapopb.sirapopb_api.dtos.UpdateUserRequest;
import com.sirapopb.sirapopb_api.dtos.UpdateUserResponse;
import com.sirapopb.sirapopb_api.entity.User;
import com.sirapopb.sirapopb_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

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

    @PostMapping("/save")
    public ResponseEntity<UpdateUserResponse>  addUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {
        UpdateUserResponse savedUser = _userService.save(updateUserRequest);
        return ResponseEntity.ok(savedUser); // Wrap the response correctlyP
    }

    @GetMapping("/getAll")
    public List<UpdateUserResponse> getAll() {

        return _userService.getAll();
    }

    @GetMapping("/getUserByTransId/{transId}")
    public UpdateUserResponse getUserByTransId(@PathVariable Integer transId) {
        UpdateUserResponse result = _userService.getUserByTransId(transId);
        if (result == null){
            throw new RuntimeException("Not found" + transId);
        }
        return result;
    }

//    @DeleteMapping("/deleteById/{id}")
//    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
//        UpdateUserResponse result = _userService.getUserByTransId(id);
//        if (result == null) {
//            throw new RuntimeException("Not found id " + id);
//        }
//        _userService.deleteById(id);
//        return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
//
//    }
//
    @PutMapping("/updateByTransId/{transId}")
    public ResponseEntity<String> updateByTransId(@PathVariable Integer transId, @RequestBody UpdateUserRequest updateUserRequest) {
        _userService.updateByTransId(transId, updateUserRequest);
        return ResponseEntity.ok("User with transId " + transId + " updated successfully.");
    }

    }
