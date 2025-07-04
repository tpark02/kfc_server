package com.example.kfc.repository.Season;

import com.example.kfc.entity.Season.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Long> {
    List<Season> findByStartedFalse();
    List<Season> findByUserId(Long userId);
}

