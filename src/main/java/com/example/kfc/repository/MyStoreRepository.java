package com.example.kfc.repository;

import com.example.kfc.entity.MyStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MyStoreRepository extends JpaRepository<MyStore, Long> {

    Optional<MyStore> findByUserIdAndPlayerId(Long userId, Long playerId);

//    @Query("SELECT MIN(s.id), MAX(s.id) FROM MyStore s WHERE s.userId = :userId")
//    Optional<Object[]> findIdRangeByUserId(@Param("userId") Long userId);

    @Modifying
    @Query("UPDATE MyStore s SET s.playerId = :playerId WHERE s.id = :id AND s.userId = :userId")
    int updateMyStoreByIdAndUserIdAndPlayerId(
            @Param("id") Long id,
            @Param("userId") Long userId,
            @Param("playerId") Long playerId);

    @Query("SELECT s FROM MyStore s WHERE s.userId = :userId")
    List<MyStore> getMyStoreData(@Param("userId") Long userId);
}
