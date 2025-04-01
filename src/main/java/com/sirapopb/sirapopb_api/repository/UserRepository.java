package com.sirapopb.sirapopb_api.repository;

import com.sirapopb.sirapopb_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
