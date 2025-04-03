package com.example.kfc.api;

import com.example.kfc.dto.PlayerForm;
import com.example.kfc.dto.PlayerPageResponse;
import com.example.kfc.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            p.setMaxPageSize(100);       // 한 페이지에 10개씩 출력
        };
    }

    @GetMapping("/api/player")
    public PlayerPageResponse getPlayerPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size,
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "AGE_DESC") String sortType) {

        Sort sort = Sort.by("age").descending(); // 기본값

        if ("AGE_ASC".equals(sortType)) {
            sort = Sort.by("age").ascending();
        } else if ("AGE_DESC".equals(sortType)) {
            sort = Sort.by("age").descending();
        } else if ("RANK_ASC".equals(sortType)) {
            sort = Sort.by("rank").descending();
        } else if ("RANK_DESC".equals(sortType)) {
            sort = Sort.by("rank").ascending();
        } else if ("OVR_ASC".equals(sortType)) {
            sort = Sort.by("ovr").ascending();
        } else if ("OVR_DESC".equals(sortType)) {
            sort = Sort.by("ovr").descending();
        }

        Pageable sortedPageable = PageRequest.of(
                page,
                size,
                sort
        );

        Page<PlayerForm> p = playerService.searchPlayers(search, 0L, 100L, 0L, 999999L, 0L, 1000L, sortedPageable);

        return new PlayerPageResponse(
                p.getContent(),
                p.getNumber(),
                p.getSize(),
                p.getTotalPages(),
                p.getTotalElements()
        );
    }
}
