--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '442', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '442');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '433', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '433');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '4231', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '4231');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '451', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '451');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '343', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '343');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '352', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '352');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '532', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '532');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '541', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '541');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '41212', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '41212');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '4222', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '4222');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '4321', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '4321');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '4132', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '4132');
--
--INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
--SELECT '424', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
--WHERE NOT EXISTS (SELECT 1 FROM formation WHERE name = '424');
--
--INSERT INTO user_info(team_name)
--SELECT 'MyTeam'
--WHERE NOT EXISTS (SELECT 1 FROM
--user_info WHERE
--team_name = 'MyTeam');

-- 먼저 user_info
INSERT INTO user_info (username, email) VALUES ('tm1', 'tm1@example.com');
INSERT INTO user_info (username, email) VALUES ('tm2', 'tm2@example.com');
INSERT INTO user_info (username, email) VALUES ('tm3', 'tm3@example.com');
INSERT INTO user_info (username, email) VALUES ('tm4', 'tm4@example.com');
INSERT INTO user_info (username, email) VALUES ('tm5', 'tm5@example.com');
INSERT INTO user_info (username, email) VALUES ('tm6', 'tm6@example.com');
INSERT INTO user_info (username, email) VALUES ('tm7', 'tm7@example.com');
INSERT INTO user_info (username, email) VALUES ('tm8', 'tm8@example.com');


-- 그 다음 my_club
INSERT INTO my_club (name, user_id) VALUES (null,
1);
INSERT INTO my_club (name, user_id) VALUES (null, 1);
INSERT INTO my_club (name, user_id) VALUES (null, 1);

-- 그 다음 formation
INSERT INTO my_formation (name, club_id) VALUES
('442', 1);
INSERT INTO my_formation (name, club_id) VALUES
('442', 2); -- 다른 p1~p26은 생략하거나 NULL 처리
INSERT INTO my_formation (name, club_id) VALUES
('442', 3); -- 다른 p1~p26은 생략하거나 NULL 처리

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 'Player 1001', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1002, 1, 0, 0, 0, 'Player 1002', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1002', 'https://player.img/1002.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1003, 1, 0, 0, 0, 'Player 1003', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1003', 'https://player.img/1003.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1004, 1, 0, 0, 0, 'Player 1004', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1004', 'https://player.img/1004.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1005, 1, 0, 0, 0, 'Player 1005', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1005', 'https://player.img/1005.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1006, 1, 0, 0, 0, 'Player 1006', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1006', 'https://player.img/1006.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1007, 1, 0, 0, 0, 'Player 1007', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1007', 'https://player.img/1007.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1008, 1, 0, 0, 0, 'Player 1008', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1008', 'https://player.img/1008.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1009, 1, 0, 0, 0, 'Player 1009', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1009', 'https://player.img/1009.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1010, 1, 0, 0, 0, 'Player 1010', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1010', 'https://player.img/1010.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1011, 1, 0, 0, 0, 'Player 1011', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1011', 'https://player.img/1011.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1012, 1, 0, 0, 0, 'Player 1012', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1012', 'https://player.img/1012.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1013, 1, 0, 0, 0, 'Player 1013', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1013', 'https://player.img/1013.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1014, 1, 0, 0, 0, 'Player 1014', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1014', 'https://player.img/1014.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1015, 1, 0, 0, 0, 'Player 1015', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1015', 'https://player.img/1015.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1016, 1, 0, 0, 0, 'Player 1016', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1016', 'https://player.img/1016.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1017, 1, 0, 0, 0, 'Player 1017', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1017', 'https://player.img/1017.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1018, 1, 0, 0, 0, 'Player 1018', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1018', 'https://player.img/1018.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1019, 1, 0, 0, 0, 'Player 1019', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1019', 'https://player.img/1019.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1020, 1, 0, 0, 0, 'Player 1020', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1020', 'https://player.img/1020.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1021, 1, 0, 0, 0, 'Player 1021', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1021', 'https://player.img/1021.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1022, 1, 0, 0, 0, 'Player 1022', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1022', 'https://player.img/1022.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1023, 1, 0, 0, 0, 'Player 1023', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1023', 'https://player.img/1023.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1024, 1, 0, 0, 0, 'Player 1024', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1024', 'https://player.img/1024.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1025, 1, 0, 0, 0, 'Player 1025', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1025', 'https://player.img/1025.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1026, 1, 0, 0, 0, 'Player 1026', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1026', 'https://player.img/1026.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2001, 2, 0, 0, 0, 'Player 2001', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2001', 'https://player.img/2001.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2002, 2, 0, 0, 0, 'Player 2002', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2002', 'https://player.img/2002.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2003, 2, 0, 0, 0, 'Player 2003', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2003', 'https://player.img/2003.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2004, 2, 0, 0, 0, 'Player 2004', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2004', 'https://player.img/2004.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2005, 2, 0, 0, 0, 'Player 2005', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2005', 'https://player.img/2005.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2006, 2, 0, 0, 0, 'Player 2006', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2006', 'https://player.img/2006.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2007, 2, 0, 0, 0, 'Player 2007', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2007', 'https://player.img/2007.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2008, 2, 0, 0, 0, 'Player 2008', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2008', 'https://player.img/2008.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2009, 2, 0, 0, 0, 'Player 2009', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2009', 'https://player.img/2009.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2010, 2, 0, 0, 0, 'Player 2010', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2010', 'https://player.img/2010.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2011, 2, 0, 0, 0, 'Player 2011', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2011', 'https://player.img/2011.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2012, 2, 0, 0, 0, 'Player 2012', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2012', 'https://player.img/2012.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2013, 2, 0, 0, 0, 'Player 2013', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2013', 'https://player.img/2013.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2014, 2, 0, 0, 0, 'Player 2014', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2014', 'https://player.img/2014.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2015, 2, 0, 0, 0, 'Player 2015', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2015', 'https://player.img/2015.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2016, 2, 0, 0, 0, 'Player 2016', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2016', 'https://player.img/2016.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2017, 2, 0, 0, 0, 'Player 2017', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2017', 'https://player.img/2017.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2018, 2, 0, 0, 0, 'Player 2018', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2018', 'https://player.img/2018.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2019, 2, 0, 0, 0, 'Player 2019', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2019', 'https://player.img/2019.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2020, 2, 0, 0, 0, 'Player 2020', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2020', 'https://player.img/2020.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2021, 2, 0, 0, 0, 'Player 2021', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2021', 'https://player.img/2021.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2022, 2, 0, 0, 0, 'Player 2022', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2022', 'https://player.img/2022.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2023, 2, 0, 0, 0, 'Player 2023', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2023', 'https://player.img/2023.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2024, 2, 0, 0, 0, 'Player 2024', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2024', 'https://player.img/2024.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2025, 2, 0, 0, 0, 'Player 2025', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2025', 'https://player.img/2025.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 2026, 2, 0, 0, 0, 'Player 2026', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/2026', 'https://player.img/2026.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3001, 3, 0, 0, 0, 'Player 3001', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3001', 'https://player.img/3001.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3002, 3, 0, 0, 0, 'Player 3002', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3002', 'https://player.img/3002.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3003, 3, 0, 0, 0, 'Player 3003', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3003', 'https://player.img/3003.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3004, 3, 0, 0, 0, 'Player 3004', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3004', 'https://player.img/3004.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3005, 3, 0, 0, 0, 'Player 3005', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3005', 'https://player.img/3005.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3006, 3, 0, 0, 0, 'Player 3006', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3006', 'https://player.img/3006.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3007, 3, 0, 0, 0, 'Player 3007', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3007', 'https://player.img/3007.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3008, 3, 0, 0, 0, 'Player 3008', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3008', 'https://player.img/3008.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3009, 3, 0, 0, 0, 'Player 3009', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3009', 'https://player.img/3009.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3010, 3, 0, 0, 0, 'Player 3010', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3010', 'https://player.img/3010.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3011, 3, 0, 0, 0, 'Player 3011', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3011', 'https://player.img/3011.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3012, 3, 0, 0, 0, 'Player 3012', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3012', 'https://player.img/3012.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3013, 3, 0, 0, 0, 'Player 3013', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3013', 'https://player.img/3013.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3014, 3, 0, 0, 0, 'Player 3014', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3014', 'https://player.img/3014.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3015, 3, 0, 0, 0, 'Player 3015', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3015', 'https://player.img/3015.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3016, 3, 0, 0, 0, 'Player 3016', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3016', 'https://player.img/3016.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3017, 3, 0, 0, 0, 'Player 3017', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3017', 'https://player.img/3017.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3018, 3, 0, 0, 0, 'Player 3018', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3018', 'https://player.img/3018.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3019, 3, 0, 0, 0, 'Player 3019', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3019', 'https://player.img/3019.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3020, 3, 0, 0, 0, 'Player 3020', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3020', 'https://player.img/3020.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3021, 3, 0, 0, 0, 'Player 3021', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3021', 'https://player.img/3021.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3022, 3, 0, 0, 0, 'Player 3022', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3022', 'https://player.img/3022.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3023, 3, 0, 0, 0, 'Player 3023', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3023', 'https://player.img/3023.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3024, 3, 0, 0, 0, 'Player 3024', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3024', 'https://player.img/3024.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3025, 3, 0, 0, 0, 'Player 3025', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3025', 'https://player.img/3025.png',
    60, 60, 60, 60, 60
);

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 3026, 3, 0, 0, 0, 'Player 3026', '60', 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/3026', 'https://player.img/3026.png',
    60, 60, 60, 60, 60
);

--INSERT INTO season (id, name, started) VALUES (1, '테스트 시즌', FALSE);
