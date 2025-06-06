package com.example.kfc.service;

import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.MyStore;
import com.example.kfc.repository.MyStoreRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyStoreService {
    private final MyStoreRepository myStoreRepository;

    public MyStore findByUserIdAndPlayerId(Long userId, Long playerId) {
        return myStoreRepository.findByUserIdAndPlayerId(userId, playerId).orElseThrow(
                () -> new IllegalArgumentException(
                        "MyStore not found for userId=" + userId + ", playerId=" + playerId));
    }

    @Transactional
    public boolean updateMyStore(Long id, Long userId, Long playerId) {
        int result = myStoreRepository.updateMyStoreByIdAndUserIdAndPlayerId(id, userId, playerId);
        return result > 0;
    }

//    public Pair<Long, Long> findIdRangeByUserId(Long userId) {
//        Object[] result = myStoreRepository.findIdRangeByUserId(userId).orElseThrow(() -> new IllegalArgumentException("No range found for userId=" + userId));
//
//        Long minId = result[0] != null ? (Long) result[0] : -1L;
//        Long maxId = result[1] != null ? (Long) result[1] : -1L;
//        return Pair.of(minId, maxId);
//    }

    public List<MyStore> getMyStore(Long userId) {
        List<MyStore> lst = myStoreRepository.getMyStoreData(userId);
        if (lst.isEmpty()) {
            throw new IllegalArgumentException("No my store data found for userId=" + userId);
        }
        return lst;
    }
}
