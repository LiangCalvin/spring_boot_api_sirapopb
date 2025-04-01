package com.sirapopb.sirapopb_api.service;

import com.sirapopb.sirapopb_api.entity.User;
import com.sirapopb.sirapopb_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    //import repo
    private UserRepository _userRepository;

    @Autowired //create constructor
    public UserService(UserRepository _userRepository) {
        this._userRepository = _userRepository;
    }

    @Override //ifc
    public User save(User user) {
        return _userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return _userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> result = _userRepository.findById(id);
        User data = null;
        if(result.isPresent()){
            data = result.get();
        } else {
            throw new RuntimeException("Not found"+id);
        }
        return data;
//        return _userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + id + " not found"));

    }

    @Override
    public void deleteById(Integer id) {

        _userRepository.deleteById(id);
    }

    @Override
    public void updateById(Integer id, User newUser) {
        User existingUser = getUserById(id);

        if (existingUser != null) {
            existingUser.setFname(newUser.getFname());
            existingUser.setLname(newUser.getLname());
            _userRepository.save(existingUser);
        }
    }


}
