// dto/ParticipantDto.java
package com.example.kfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParticipantDto {
    private Long id;
    private String name;
    private Long rank;
    private Long ovr;
}
