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
INSERT INTO user_info (username, email, is_ai)
VALUES ('tm1', 'tm1@example.com', false);
INSERT INTO user_info (username, email, is_ai)
VALUES ('tm2', 'tm2@example.com', false);
INSERT INTO user_info (username, email, is_ai)
VALUES ('tm3', 'tm3@example.com', false);
INSERT INTO user_info (username, email, is_ai)
VALUES ('tm4', 'tm4@example.com', false);
INSERT INTO user_info (username, email, is_ai)
VALUES ('tm5', 'tm5@example.com', false);
INSERT INTO user_info (username, email, is_ai)
VALUES ('tm6', 'tm6@example.com', false);
INSERT INTO user_info (username, email, is_ai)
VALUES ('tm7', 'tm7@example.com', false);
INSERT INTO user_info (username, email, is_ai)
VALUES
('tm8', 'tm8@example.com', false);


-- 그 다음 my_club
INSERT INTO my_club (name, user_id) VALUES (null,
1);
INSERT INTO my_club (name, user_id) VALUES (null, 1);
INSERT INTO my_club (name, user_id) VALUES (null, 1);

-- 그 다음 formation
INSERT INTO my_formation (name, club_id) VALUES
('442', 1);
INSERT INTO my_formation (name, club_id) VALUES
('442', 2); -- 다른 p1~p16은 생략하거나 NULL 처리
INSERT INTO my_formation (name, club_id) VALUES
('442', 3); -- 다른 p1~p16은 생략하거나 NULL 처리

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

-- temp club 2 player insert

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

-- temp club 3 player insert
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

--INSERT INTO season (id, name, started) VALUES (1, '테스트 시즌', FALSE);

-- avg ovr - 66.7962451372836443592490275
-- ai club insert - beginner level - 63
INSERT INTO ai_club (name) VALUES ('AI');
INSERT INTO ai_club (name) VALUES ('AI');
INSERT INTO ai_club (name) VALUES ('AI');

-- ai formation insert - beginner level - 63
INSERT INTO ai_formation (name, club_id) VALUES ('442', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('433', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('352', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('4231', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('451', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('343', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('532', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('541', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('41212', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('4222', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('4321', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('4132', 1);
INSERT INTO ai_formation (name, club_id) VALUES ('424', 1);

INSERT INTO ai_formation (name, club_id) VALUES ('442', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('433', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('352', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('4231', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('451', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('343', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('532', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('541', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('41212', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('4222', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('4321', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('4132', 2);
INSERT INTO ai_formation (name, club_id) VALUES ('424', 2);

INSERT INTO ai_formation (name, club_id) VALUES ('442', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('433', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('352', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('4231', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('451', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('343', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('532', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('541', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('41212', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('4222', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('4321', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('4132', 3);
INSERT INTO ai_formation (name, club_id) VALUES ('424', 3);


-- ai user info insert
INSERT INTO user_info (username, email, is_ai)
VALUES ('Michael Carter', 'm.carter@example.com', true);

INSERT INTO user_info (username, email, is_ai)
VALUES ('Sophie Kim', 'sophie.kim@example.com', true);

INSERT INTO user_info (username, email, is_ai)
VALUES ('Daniel Ruiz', 'daniel.ruiz@example.com', true);

INSERT INTO user_info (username, email, is_ai)
VALUES ('Emily Zhang', 'emily.zhang@example.com', true);

INSERT INTO user_info (username, email, is_ai)
VALUES ('Liam O''Connor', 'liam.oconnor@example.com', true);

INSERT INTO user_info (username, email, is_ai)
VALUES ('Ava Müller', 'ava.muller@example.com', true);

INSERT INTO user_info (username, email, is_ai)
VALUES ('Noah Yamamoto', 'noah.yamamoto@example.com', true);

INSERT INTO user_info (username, email, is_ai)
VALUES ('Isabella Rossi', 'isabella.rossi@example.com', true);
