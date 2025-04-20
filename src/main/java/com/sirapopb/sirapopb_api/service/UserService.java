package com.sirapopb.sirapopb_api.service;

import com.sirapopb.sirapopb_api.dtos.UpdateUserRequest;
import com.sirapopb.sirapopb_api.dtos.UpdateUserResponse;
import com.sirapopb.sirapopb_api.entity.User;
import com.sirapopb.sirapopb_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UpdateUserResponse save(UpdateUserRequest updateUserRequest) {
        _userRepository.customSave(
                updateUserRequest.getFirst_name(),
                updateUserRequest.getLast_name(),
                updateUserRequest.getTransId()
        );
        return new UpdateUserResponse(
                updateUserRequest.getFirst_name(),
                updateUserRequest.getLast_name(),
                updateUserRequest.getTransId()
        );
    }

//    @Override
//    public UpdateUserResponse create(UpdateUserRequest updateUserRequest) {
//        User user = new User(updateUserRequest);
//        _userRepository.save(user);
//        return new UpdateUserResponse(updateUserRequest);
//    }


    @Override
    public List<UpdateUserResponse> getAll() {
        return _userRepository.findAllUserResponses();
    }

    @Override
    public UpdateUserResponse getUserByTransId(Integer transId) {
        Optional<User> result = _userRepository.findByTransId(transId);
        User data = null;
        if(result.isPresent()){
            data = result.get();
        } else {
            throw new RuntimeException("Not found " + transId);
        }

        UpdateUserResponse response = new UpdateUserResponse(
                data.getFname(),
                data.getLname(),
                data.getTransId()
        );
        return response;
    }

//    @Override
//    public void deleteById(Integer id) {
//
//        _userRepository.deleteById(id);
//    }

    @Override
    public void updateByTransId(Integer transId, UpdateUserRequest updateUserRequest) {
        User existingUser = _userRepository.findByTransId(transId)
                .orElseThrow(() -> new RuntimeException("User with transId " + transId + " not found."));

        // Update the user entity with the new values
        existingUser.setFname(updateUserRequest.getFirst_name());
        existingUser.setLname(updateUserRequest.getLast_name());

        _userRepository.save(existingUser);

    }


}
