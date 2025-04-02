package com.example.kfc.repository;

import com.example.kfc.entity.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    @Override
    ArrayList<Player> findAll(); // Iterable → ArrayList 수정
}
