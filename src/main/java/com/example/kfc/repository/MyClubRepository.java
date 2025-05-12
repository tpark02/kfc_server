package com.example.kfc.repository;

import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyClubRepository extends JpaRepository<MyClub, Long> {
    List<MyClub> findByUser(UserInfo user);
}

