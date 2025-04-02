package com.example.kfc.repository;

import com.example.kfc.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Override
    ArrayList<Player> findAll(); // Iterable → ArrayList 수정

    @Override
    Page<Player> findAll(Pageable pageable);

    Page<Player> findByNameContains(String name, Pageable pageable);
}
