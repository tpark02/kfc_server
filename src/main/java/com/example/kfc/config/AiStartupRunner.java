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
        aiClubService.updateAiClubAndFormation(1L, "442", 63L);
        aiClubService.updateAiClubAndFormation(1L, "433", 63L);
        aiClubService.updateAiClubAndFormation(1L, "352", 63L);
        aiClubService.updateAiClubAndFormation(1L, "4231", 63L);
        aiClubService.updateAiClubAndFormation(1L, "451", 63L);
        aiClubService.updateAiClubAndFormation(1L, "343", 63L);
        aiClubService.updateAiClubAndFormation(1L, "532", 63L);
        aiClubService.updateAiClubAndFormation(1L, "541", 63L);
        aiClubService.updateAiClubAndFormation(1L, "41212", 63L);
        aiClubService.updateAiClubAndFormation(1L, "4222", 63L);
        aiClubService.updateAiClubAndFormation(1L, "4321", 63L);
        aiClubService.updateAiClubAndFormation(1L, "4132", 63L);
        aiClubService.updateAiClubAndFormation(1L, "424", 63L);

        // ai club intermediate insert
        aiClubService.updateAiClubAndFormation(2L, "442", 73L);
        aiClubService.updateAiClubAndFormation(2L, "433", 73L);
        aiClubService.updateAiClubAndFormation(2L, "352", 73L);
        aiClubService.updateAiClubAndFormation(2L, "4231", 73L);
        aiClubService.updateAiClubAndFormation(2L, "451", 73L);
        aiClubService.updateAiClubAndFormation(2L, "343", 73L);
        aiClubService.updateAiClubAndFormation(2L, "532", 73L);
        aiClubService.updateAiClubAndFormation(2L, "541", 73L);
        aiClubService.updateAiClubAndFormation(2L, "41212", 73L);
        aiClubService.updateAiClubAndFormation(2L, "4222", 73L);
        aiClubService.updateAiClubAndFormation(2L, "4321", 73L);
        aiClubService.updateAiClubAndFormation(2L, "4132", 73L);
        aiClubService.updateAiClubAndFormation(2L, "424", 73L);

        // ai club exprt insert
        aiClubService.updateAiClubAndFormation(3L, "442", 83L);
        aiClubService.updateAiClubAndFormation(3L, "433", 83L);
        aiClubService.updateAiClubAndFormation(3L, "352", 83L);
        aiClubService.updateAiClubAndFormation(3L, "4231", 83L);
        aiClubService.updateAiClubAndFormation(3L, "451", 83L);
        aiClubService.updateAiClubAndFormation(3L, "343", 83L);
        aiClubService.updateAiClubAndFormation(3L, "532", 83L);
        aiClubService.updateAiClubAndFormation(3L, "541", 83L);
        aiClubService.updateAiClubAndFormation(3L, "41212", 83L);
        aiClubService.updateAiClubAndFormation(3L, "4222", 83L);
        aiClubService.updateAiClubAndFormation(3L, "4321", 83L);
        aiClubService.updateAiClubAndFormation(3L, "4132", 83L);
        aiClubService.updateAiClubAndFormation(3L, "424", 83L);

        for (Long i = 1l; i <= 3L; i++) {
            Long finalI = i;
            AiClub club = aiClubRepository.findById(i).orElseThrow(() -> new IllegalArgumentException("AI Club does not exist with club id - " + finalI));
            aiClubList.add(club);

            List<AiFormation> lst = aiFormationRepository.findByClub_ClubId(finalI).orElseThrow(() -> new IllegalArgumentException("AI Formation does not exist with club id - " + finalI));;

            aiFormationList.put(finalI, lst);
        }
    }
}
