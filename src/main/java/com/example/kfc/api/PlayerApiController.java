package com.example.kfc.api;

import com.example.kfc.dto.PlayerForm;
import com.example.kfc.dto.PlayerPageResponse;
import com.example.kfc.entity.Player;
import com.example.kfc.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
public class PlayerApiController {
    @Autowired
    private PlayerService playerService;

    @Bean
    public PageableHandlerMethodArgumentResolverCustomizer customize() {
        return p -> {
            p.setOneIndexedParameters(false);    // 1 페이지 부터 시작
            p.setMaxPageSize(10);       // 한 페이지에 10개씩 출력
        };
    }

    // GET
    @GetMapping("/api/players")
    public List<Player> index() {
        return playerService.index();
    }

    @GetMapping("/api/playerpage")
    public PlayerPageResponse getPlayerPage(Pageable pageable) {
        Page<PlayerForm> page = playerService.findAllAsForm(pageable); // 서비스에서 DTO로 변환
        return new PlayerPageResponse(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements()
        );
    }



    // PageRequest 사용 예제
    @GetMapping("/api/find-by-name")
    public Page<Player> findByName(@RequestParam(required = false, defaultValue = "0") int page) {
        return playerService.findByName(10);
    }
}
