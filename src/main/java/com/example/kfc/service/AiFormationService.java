package com.example.kfc.service;

import com.example.kfc.repository.AiFormationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiFormationService {
    private final AiFormationRepository aiFormationRepository;

    public void updateFormationPlayers(Long clubId, String formation,
                                       Integer p1, Integer p2, Integer p3, Integer p4, Integer p5,
                                       Integer p6, Integer p7, Integer p8, Integer p9, Integer p10,
                                       Integer p11, Integer p12, Integer p13, Integer p14, Integer p15, Integer p16, Integer p17) {
        int updatedRows = aiFormationRepository.updateAiFormation(clubId,
                                                                  formation, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                                                                  p11, p12, p13, p14, p15, p16, p17);

        if (updatedRows == 0) {
            throw new IllegalStateException("⚠️ Formation update failed: No such formation = " + formation);
        }

        System.out.println("✅ Formation updated successfully: " + formation);
    }
}
