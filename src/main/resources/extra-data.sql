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

UPDATE user_info
SET coin = 10000
where id = 1;

-- 그 다음 my_club
INSERT INTO my_club (name, user_id) VALUES (null,
1);
--INSERT INTO my_club (name, user_id) VALUES (null, 1);
--INSERT INTO my_club (name, user_id) VALUES (null, 1);

-- 그 다음 formation
INSERT INTO my_formation (name, club_id) VALUES
('442', 1);
--INSERT INTO my_formation (name, club_id) VALUES
--('442', 2); -- 다른 p1~p16은 생략하거나 NULL 처리
--INSERT INTO my_formation (name, club_id) VALUES
--('442', 3); -- 다른 p1~p16은 생략하거나 NULL 처리

INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
    60, 60, 60, 60, 60
);

-- buy players
INSERT INTO my_player (
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
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
    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
    dribbling, agility, balance, reactions, ball_control, composure,
    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
    jumping, stamina, strength, aggression,
    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
    age, nation, league, team, play_style, url, img,
    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
) VALUES (
    1, 1001, 1, 0, 0, 0, 0, 'Player 1001', 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60, 60,
    60, 60, 60, 60, 60,
    60, 60, 60, 60,
    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
    60, 60, 60, 60, 60
);

---- temp club 2 player insert
--
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 2, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--
--
---- temp club 3 player insert
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);
--INSERT INTO my_player (
--    user_id, player_id, club_id, yellow_card, red_card, rank, idx, name, ovr, pac, sho, pas, dri, def, phy,
--    acceleration, sprint_speed, positioning, finishing, shot_power, long_shots, volleys, penalties,
--    vision, crossing, free_kick_accuracy, short_passing, long_passing, curve,
--    dribbling, agility, balance, reactions, ball_control, composure,
--    interceptions, heading_accuracy, def_awareness, standing_tackle, sliding_tackle,
--    jumping, stamina, strength, aggression,
--    pos, weak_foot, skill_moves, preferred_foot, height, weight, alternative_positions,
--    age, nation, league, team, play_style, url, img,
--    gk_diving, gk_handling, gk_kicking, gk_positioning, gk_reflexes
--) VALUES (
--    1, 1001, 3, 0, 0, 0, 0, 'Player 1001', 60, 60,
--     60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60, 60,
--    60, 60, 60, 60, 60,
--    60, 60, 60, 60,
--    'ST', 3, 3, 'Right', '180cm', '75kg', 'CAM,CF',
--    25, 'Korea', 'K League', 'FC Seoul', 'Power Shot', 'https://player.url/1001', 'https://player.img/1001.png',
--    60, 60, 60, 60, 60
--);

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

-- my_store init 30 empty slots
INSERT INTO my_store (user_id)
SELECT 1 FROM system_range(1, 30);
