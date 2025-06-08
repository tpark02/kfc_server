package com.example.kfc.controller;

import com.example.kfc.Request.MyStoreUpdateRequest;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.dto.MyStoreDto;
import com.example.kfc.entity.MyStore;
import com.example.kfc.entity.Player;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.manager.LockManager;
import com.example.kfc.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MyStoreController {
    private final PlayerService playerService;
    private final MyPlayerService myPlayerService;
    private final UserInfoService userInfoService;
    private final LockManager<Long> userLockManager = new LockManager<>();

    @PutMapping("/mystore/buyplayer/")
    public ResponseEntity<String> buyplayer(@RequestBody MyStoreUpdateRequest request) {
        Long userId = request.getUserId();
        Long playerId = request.getPlayerId();
        // 🔐 Lock per userId
        userLockManager.lock(userId);

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
//            List<MyStore> lst = myStoreService.getMyStore(userId);
//            var storeOpt = lst.stream().filter(m -> m.getPlayerId().equals(0L)).findFirst();
//
//            if (storeOpt.isEmpty()) {
//                return ResponseEntity.ok().body("❌ No empty slot found. userId = " + userId);
//            }
            Player dummy = playerService.findMaxId();
            var emptySpot = myPlayerService.getMyPlayersByPlayerId(userId, 1L, dummy.getId());

            if (emptySpot.size() <= 0) {
                return ResponseEntity.ok().body("❌ No Empty Space for a new player");
            }

            // 💸 Deduct coin
            userinfo.setCoin(userCoin - price);
            userInfoService.save(userinfo);

            // ✅ Update store
            boolean res = myPlayerService.updateNewPlayer(player, emptySpot.get(0));

            if (res) {
                return ResponseEntity.ok("✅ Updated successfully.");
            } else {
                return ResponseEntity.badRequest().body("❌ Update failed. No matching row.");
            }
        } catch (Exception e) {
            log.error("❌ Exception during store update: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("❗ Internal server error.");
        } finally {
            userLockManager.unlock(userId);
        }
    }
}


