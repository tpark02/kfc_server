package com.example.kfc.controller;

import com.example.kfc.Request.MyStoreUpdateRequest;
import com.example.kfc.Response.BuyPlayerResponse;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.dto.MyStoreDto;
import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.MyStore;
import com.example.kfc.entity.Player;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.manager.LockManager;
import com.example.kfc.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
    public BuyPlayerResponse buyplayer(@RequestBody MyStoreUpdateRequest request) {
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
                return new BuyPlayerResponse(new ArrayList<>(), "❌ Not enough coin", "NO PLAYER");
            }

            Player dummy = playerService.findMaxId();
            var emptySpot = myPlayerService.getMyPlayersByPlayerId(userId, 1L, dummy.getId());

            if (emptySpot.size() <= 0) {
                return new BuyPlayerResponse(new ArrayList<>(), "❌ No Empty Space for a new player", "NO PLAYER");
            }

            // 💸 Deduct coin
            userinfo.setCoin(userCoin - price);
            userInfoService.save(userinfo);

            // ✅ Update store
            boolean res = myPlayerService.updateNewPlayer(player, emptySpot.get(0));

            List<MyPlayer> resultList = new ArrayList<>();
            if (res) {
                resultList = myPlayerService.getMyPlayers(userId, 1L);
                return new BuyPlayerResponse(resultList, String.format("%s purchased successfully!", player.getName()), player.getName());
            } else {
                return new BuyPlayerResponse(new ArrayList<>(), "Purchase failed", "NO PLAYER");
            }
        } catch (Exception e) {
            String error = toString().formatted("❌ Exception during store update: {}", e.getMessage(), e);
            log.error(error);
            return new BuyPlayerResponse(new ArrayList<>(), error, "NO PLAYER");
        } finally {
            userLockManager.unlock(userId);
        }
    }
}


