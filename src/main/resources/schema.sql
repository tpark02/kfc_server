CREATE TABLE player (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rank INT,
    name VARCHAR(100),
    ovr VARCHAR(5),
    pac INT,
    sho INT,
    pas INT,
    dri INT,
    def INT,
    phy INT,

    acceleration INT,
    sprint_speed INT,
    positioning INT,
    finishing INT,
    shot_power INT,
    long_shots INT,
    volleys INT,
    penalties INT,

    vision INT,
    crossing INT,
    free_kick_accuracy INT,
    short_passing INT,
    long_passing INT,
    curve INT,

    dribbling INT,
    agility INT,
    balance INT,
    reactions INT,
    ball_control INT,
    composure INT,

    interceptions INT,
    heading_accuracy INT,
    def_awareness INT,
    standing_tackle INT,
    sliding_tackle INT,

    jumping INT,
    stamina INT,
    strength INT,
    aggression INT,

    pos VARCHAR(10),
    weak_foot INT,
    skill_moves INT,
    preferred_foot VARCHAR(10),
    height VARCHAR(30),
    weight VARCHAR(30),
    alternative_positions VARCHAR(50),

    age INT,
    nation VARCHAR(50),
    league VARCHAR(100),
    team VARCHAR(100),
    play_style VARCHAR(255),

    url VARCHAR(255),
    img VARCHAR(255),

    gk_diving INT,
    gk_handling INT,
    gk_kicking INT,
    gk_positioning INT,
    gk_reflexes INT
);

CREATE TABLE team (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    team VARCHAR(100) NOT NULL,
    url VARCHAR(255)
);

CREATE TABLE league (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    url VARCHAR(255)
);

CREATE TABLE user_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100),
    team_name VARCHAR(100)
);

CREATE TABLE my_club (
    club_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    user_id BIGINT NOT NULL,
    ovr INT,
    price INT,
    age INT,
    pace INT,
    def INT,
    atk INT,
    cch INT,
    stm INT,
    FOREIGN KEY (user_id) REFERENCES user_info(id)
);

CREATE TABLE formation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    club_id BIGINT,
    p1 INT,
    p2 INT,
    p3 INT,
    p4 INT,
    p5 INT,
    p6 INT,
    p7 INT,
    p8 INT,
    p9 INT,
    p10 INT,
    p11 INT,
    p12 INT,
    p13 INT,
    p14 INT,
    p15 INT,
    p16 INT,
    p17 INT,
    p18 INT,
    p19 INT,
    p20 INT,
    p21 INT,
    p22 INT,
    p23 INT,
    p24 INT,
    p25 INT,
    p26 INT,
    FOREIGN KEY (club_id) REFERENCES my_club(club_id)
);
