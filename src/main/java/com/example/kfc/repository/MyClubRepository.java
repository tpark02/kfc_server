package com.example.kfc.repository;

import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.UserInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MyClubRepository extends JpaRepository<MyClub, Long> {
    List<MyClub> findByUser(UserInfo user);
    Optional<MyClub> findByClubIdAndUserId(Long cludId, Long userId);
}

