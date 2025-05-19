package com.example.kfc.repository;

import com.example.kfc.entity.MyPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyPlayerRepository extends JpaRepository<MyPlayer, Long> {
    Optional<MyPlayer> findByIdAndUserIdAndClubId(Long id, Long userId, Long clubId);
    Optional<List<MyPlayer>> findByUserIdAndClubId(Long userId, Long clubId);
}
