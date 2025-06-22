package com.example.kfc.repository;

import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MyClubRepository extends JpaRepository<MyClub, Long> {
    @Query("SELECT c FROM MyClub c WHERE c.user.id = :userId")
    Optional<MyClub> findByUserId(@Param("userId") Long userId);

    List<MyClub> findByUser(UserInfo user);
}

