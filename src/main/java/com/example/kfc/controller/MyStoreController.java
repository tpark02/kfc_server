package com.example.kfc.controller;

import com.example.kfc.Request.MyStoreUpdateRequest;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.dto.MyStoreDto;
import com.example.kfc.entity.MyStore;
import com.example.kfc.entity.Player;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.service.MyStoreService;
import com.example.kfc.service.PlayerService;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MyStoreController {
    private final PlayerService playerService;
    private final MyStoreService myStoreService;
    private final UserInfoService userInfoService;
    private final Map<Long, ReentrantLock> rowLocks = new ConcurrentHashMap<>();

    @PutMapping("/mystore/buyplayer/")
    public ResponseEntity<String> updateNewPlayer(@RequestBody MyStoreUpdateRequest request) {
        Long userId = request.getUserId();
        Long playerId = request.getPlayerId();
        // 🔐 Lock per userId
        ReentrantLock lock = rowLocks.computeIfAbsent(userId, id -> new ReentrantLock());
        lock.lock();

        try {
            // 💰 Get and check user coin balance
            var userinfo = userInfoService.getUserById(userId);
            var userCoin = userinfo.getCoin();
            var player = playerService.searchPlayerById(playerId);
            var price = player.getPrice();

            if (userCoin < price) {
                return ResponseEntity.ok().body("❌ Not enough coin");
            }

            // 🧩 Find first empty store slot
            List<MyStore> lst = myStoreService.getMyStore(userId);
            var storeOpt = lst.stream().filter(m -> m.getPlayerId().equals(0L)).findFirst();

            if (storeOpt.isEmpty()) {
                return ResponseEntity.ok().body("❌ No empty slot found. userId = " + userId);
            }

            Long rowId = storeOpt.get().getId();

            // 💸 Deduct coin
            userinfo.setCoin(userCoin - price);
            userInfoService.save(userinfo);

            // ✅ Update store
            boolean res = myStoreService.updateNewPlayer(rowId, userId, player);

            if (res) {
                return ResponseEntity.ok("✅ Updated successfully.");
            } else {
                return ResponseEntity.badRequest().body("❌ Update failed. No matching row.");
            }
        } catch (Exception e) {
            log.error("❌ Exception during store update: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("❗ Internal server error.");
        } finally {
            lock.unlock();
        }
    }

    @GetMapping("/mystore/getmystore/{userId}")
    public List<MyStoreDto> getMyStore(@PathVariable Long userId) {
        return myStoreService.getMyStore(userId).stream().map(MyStoreDto::from).toList();
    }
}


