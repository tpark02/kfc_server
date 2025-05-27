package com.example.kfc.repository;

import com.example.kfc.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);

    @Query("SELECT MAX(u.id) FROM UserInfo u")
    Long findMaxId();
}
