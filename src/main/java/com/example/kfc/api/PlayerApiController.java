package com.example.kfc.api;

import com.example.kfc.dto.CountryFilter;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.dto.PlayerPageResponse;
import com.example.kfc.dto.PlayerSearchRequest;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
public class PlayerApiController {
    @Autowired
    private PlayerService playerService;
    private List<CountryFilter> filters = new ArrayList<>();

    @Bean
    public PageableHandlerMethodArgumentResolverCustomizer customize() {
        return p -> {
            p.setOneIndexedParameters(false);    // 1 페이지 부터 시작
            p.setMaxPageSize(100);       // 한 페이지에 10개씩 출력
        };
    }

    @PostMapping("/api/player")
    public PlayerPageResponse getPlayerPage(@RequestBody PlayerSearchRequest request) {
        int page = request.getPage();
        int size = request.getSize() > 0 ? request.getSize() : 100;
        String search = request.getSearch();
        String sortType = request.getSortType();
        filters = request.getFilters();

        getPlayerPrintLog(page, size, search, sortType);

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

        List<String> nation = filters.stream()
                .map(CountryFilter::getName)
                .toList();

        Pageable sortedPageable = PageRequest.of(
                page,
                size,
                sort
        );

        Page<PlayerDto> p = playerService.searchPlayers(search, 0L, 100L, 0L, 999999L, 0L, 1000L, nation.isEmpty() ? null : nation, sortedPageable);

        return new PlayerPageResponse(
                p.getContent(),
                p.getNumber(),
                p.getSize(),
                p.getTotalPages(),
                p.getTotalElements()
        );
    }

    private void getPlayerPrintLog(int page, int size, String search, String sortType) {
        log.info("===== getPlayer =====");
        log.info("page: {}, size: {}, search: {}, sortType: {}", page, size, search, sortType);

        if (filters == null) {
            filters = new ArrayList<>();
        }

        if (!filters.isEmpty()) {
            for (CountryFilter filter : filters) {
                log.info("name: {}, code: {}", filter.getName(), filter.getCode());
            }
        } else {
            log.info("No countries selected!!!");
        }
    }
}
