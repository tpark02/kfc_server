INSERT INTO formation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
SELECT '442', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL
WHERE NOT EXISTS (
    SELECT 1 FROM formation WHERE name = '442'
);
