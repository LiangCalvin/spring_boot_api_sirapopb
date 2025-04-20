package com.sirapopb.sirapopb_api.repository;

import com.sirapopb.sirapopb_api.dtos.UpdateUserResponse;
import com.sirapopb.sirapopb_api.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT new com.sirapopb.sirapopb_api.dtos.UpdateUserResponse(u.fname, u.lname, u.transId) FROM User u")
    List<UpdateUserResponse> findAllUserResponses();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user (first_name, last_name, trans_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void customSave(String fname, String lname, Integer transId);

    Optional<User> findByTransId(Integer transId);

}
