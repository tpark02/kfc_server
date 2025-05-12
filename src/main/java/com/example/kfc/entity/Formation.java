package com.example.kfc.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private MyClub club;


    //@OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    //private List<Long> players;

    private Long p1;
    private Long p2;
    private Long p3;
    private Long p4;
    private Long p5;
    private Long p6;
    private Long p7;
    private Long p8;
    private Long p9;
    private Long p10;
    private Long p11;

    // ✅ 생성자, getter, setter
    public Formation(String name,  Long p1,
                     Long p2,
                     Long p3,
                     Long p4,
                     Long p5,
                     Long p6,
                     Long p7,
                     Long p8,
                     Long p9,
                     Long p10,
                     Long p11) {
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
        this.p10 = p10;
        this.p11 = p11;
    }
}
