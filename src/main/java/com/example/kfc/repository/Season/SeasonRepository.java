package com.example.kfc.repository.Season;

import com.example.kfc.entity.Season.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Long> {
    List<Season> findByStartedFalse(); // 👈 이거 추가
    List<Season> findByUserId(Long userId);
}

