package com.sirapopb.sirapopb_api.service;

import com.sirapopb.sirapopb_api.dtos.UpdateUserRequest;
import com.sirapopb.sirapopb_api.dtos.UpdateUserResponse;
import com.sirapopb.sirapopb_api.entity.User;

import java.util.List;

public interface IUserService {

    UpdateUserResponse save(UpdateUserRequest updateUserRequest);
    List<UpdateUserResponse> getAll();
    UpdateUserResponse getUserByTransId(Integer transId);
//    UpdateUserResponse create(UpdateUserRequest updateUserRequest);

        //    void deleteById(Integer id);
    void updateByTransId(Integer transId, UpdateUserRequest updateUserRequest);
}
