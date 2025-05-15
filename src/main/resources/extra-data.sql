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
INSERT INTO user_info (username, email) VALUES ('tm', 'tm@example.com');

-- 그 다음 my_club
INSERT INTO my_club (name, user_id) VALUES (null,
1);
INSERT INTO my_club (name, user_id) VALUES (null, 1);
INSERT INTO my_club (name, user_id) VALUES (null, 1);

-- 그 다음 formation
INSERT INTO formation (name, club_id) VALUES
('442', 1);
INSERT INTO formation (name, club_id) VALUES
('442', 2); -- 다른 p1~p26은 생략하거나 NULL 처리
INSERT INTO formation (name, club_id) VALUES
('442', 3); -- 다른 p1~p26은 생략하거나 NULL 처리
