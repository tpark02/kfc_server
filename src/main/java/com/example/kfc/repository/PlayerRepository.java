package com.example.kfc.repository;

import com.example.kfc.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Page<Player> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
