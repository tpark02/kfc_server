package com.example.kfc.config;

import com.example.kfc.entity.AiClub;
import com.example.kfc.entity.AiFormation;
import com.example.kfc.repository.AiClubRepository;
import com.example.kfc.repository.AiFormationRepository;
import com.example.kfc.service.AiClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AiStartupRunner implements ApplicationRunner {

    private final AiClubRepository aiClubRepository;
    private final AiFormationRepository aiFormationRepository;
    private final AiClubService aiClubService;
    public static List<AiClub> aiClubList = new ArrayList<>();
    public static Map<Long, List<AiFormation>> aiFormationList = new HashMap<>();

    @Override
    public void run(ApplicationArguments args) {

// ai club beginner insert
        aiClubService.updateAiClubAndFormation(1L, "442", 630L);
        aiClubService.updateAiClubAndFormation(1L, "433", 630L);
        aiClubService.updateAiClubAndFormation(1L, "352", 630L);
        aiClubService.updateAiClubAndFormation(1L, "4231", 630L);
        aiClubService.updateAiClubAndFormation(1L, "451", 630L);
        aiClubService.updateAiClubAndFormation(1L, "343", 630L);
        aiClubService.updateAiClubAndFormation(1L, "532", 630L);
        aiClubService.updateAiClubAndFormation(1L, "541", 630L);
        aiClubService.updateAiClubAndFormation(1L, "41212", 630L);
        aiClubService.updateAiClubAndFormation(1L, "4222", 630L);
        aiClubService.updateAiClubAndFormation(1L, "4321", 630L);
        aiClubService.updateAiClubAndFormation(1L, "4132", 630L);
        aiClubService.updateAiClubAndFormation(1L, "424", 630L);

// ai club intermediate insert
        aiClubService.updateAiClubAndFormation(2L, "442", 730L);
        aiClubService.updateAiClubAndFormation(2L, "433", 730L);
        aiClubService.updateAiClubAndFormation(2L, "352", 730L);
        aiClubService.updateAiClubAndFormation(2L, "4231", 730L);
        aiClubService.updateAiClubAndFormation(2L, "451", 730L);
        aiClubService.updateAiClubAndFormation(2L, "343", 730L);
        aiClubService.updateAiClubAndFormation(2L, "532", 730L);
        aiClubService.updateAiClubAndFormation(2L, "541", 730L);
        aiClubService.updateAiClubAndFormation(2L, "41212", 730L);
        aiClubService.updateAiClubAndFormation(2L, "4222", 730L);
        aiClubService.updateAiClubAndFormation(2L, "4321", 730L);
        aiClubService.updateAiClubAndFormation(2L, "4132", 730L);
        aiClubService.updateAiClubAndFormation(2L, "424", 730L);

// ai club expert insert
        aiClubService.updateAiClubAndFormation(3L, "442", 830L);
        aiClubService.updateAiClubAndFormation(3L, "433", 830L);
        aiClubService.updateAiClubAndFormation(3L, "352", 830L);
        aiClubService.updateAiClubAndFormation(3L, "4231", 830L);
        aiClubService.updateAiClubAndFormation(3L, "451", 830L);
        aiClubService.updateAiClubAndFormation(3L, "343", 830L);
        aiClubService.updateAiClubAndFormation(3L, "532", 830L);
        aiClubService.updateAiClubAndFormation(3L, "541", 830L);
        aiClubService.updateAiClubAndFormation(3L, "41212", 830L);
        aiClubService.updateAiClubAndFormation(3L, "4222", 830L);
        aiClubService.updateAiClubAndFormation(3L, "4321", 830L);
        aiClubService.updateAiClubAndFormation(3L, "4132", 830L);
        aiClubService.updateAiClubAndFormation(3L, "424", 830L);


        for (Long i = 1l; i <= 3L; i++) {
            Long finalI = i;
            AiClub club = aiClubRepository.findById(i)
                    .orElseThrow(() -> new IllegalArgumentException("AI Club does not exist with club id - " + finalI));
            aiClubList.add(club);

            List<AiFormation> lst = aiFormationRepository.findByClub_ClubId(finalI).orElseThrow(
                    () -> new IllegalArgumentException("AI Formation does not exist with club id - " + finalI)); ;

            aiFormationList.put(finalI, lst);
        }
    }
}
