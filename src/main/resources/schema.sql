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
    password VARCHAR(255),
    is_ai BOOLEAN
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

CREATE TABLE my_formation (
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
--    p18 INT,
--    p19 INT,
--    p20 INT,
--    p21 INT,
--    p22 INT,
--    p23 INT,
--    p24 INT,
--    p25 INT,
--    p26 INT,
    FOREIGN KEY (club_id) REFERENCES my_club(club_id)
);

CREATE TABLE my_player (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT DEFAULT 0,
    player_id BIGINT DEFAULT 0,
    club_id BIGINT DEFAULT 0,
    yellow_card BIGINT DEFAULT 0,
    red_card BIGINT DEFAULT 0,
    seq_cnt BIGINT DEFAULT 0,

    rank BIGINT DEFAULT 0,
    name VARCHAR(100),
    ovr BIGINT DEFAULT 0,
    pac BIGINT DEFAULT 0,
    sho BIGINT DEFAULT 0,
    pas BIGINT DEFAULT 0,
    dri BIGINT DEFAULT 0,
    def BIGINT DEFAULT 0,
    phy BIGINT DEFAULT 0,

    acceleration BIGINT DEFAULT 0,
    sprint_speed BIGINT DEFAULT 0,
    positioning BIGINT DEFAULT 0,
    finishing BIGINT DEFAULT 0,
    shot_power BIGINT DEFAULT 0,
    long_shots BIGINT DEFAULT 0,
    volleys BIGINT DEFAULT 0,
    penalties BIGINT DEFAULT 0,

    vision BIGINT DEFAULT 0,
    crossing BIGINT DEFAULT 0,
    free_kick_accuracy BIGINT DEFAULT 0,
    short_passing BIGINT DEFAULT 0,
    long_passing BIGINT DEFAULT 0,
    curve BIGINT DEFAULT 0,

    dribbling BIGINT DEFAULT 0,
    agility BIGINT DEFAULT 0,
    balance BIGINT DEFAULT 0,
    reactions BIGINT DEFAULT 0,
    ball_control BIGINT DEFAULT 0,
    composure BIGINT DEFAULT 0,

    interceptions BIGINT DEFAULT 0,
    heading_accuracy BIGINT DEFAULT 0,
    def_awareness BIGINT DEFAULT 0,
    standing_tackle BIGINT DEFAULT 0,
    sliding_tackle BIGINT DEFAULT 0,

    jumping BIGINT DEFAULT 0,
    stamina BIGINT DEFAULT 0,
    strength BIGINT DEFAULT 0,
    aggression BIGINT DEFAULT 0,

    pos VARCHAR(10),
    weak_foot BIGINT DEFAULT 0,
    skill_moves BIGINT DEFAULT 0,
    preferred_foot VARCHAR(10),
    height VARCHAR(30),
    weight VARCHAR(30),
    alternative_positions VARCHAR(50),

    age BIGINT DEFAULT 0,
    nation VARCHAR(50),
    league VARCHAR(100),
    team VARCHAR(100),
    play_style VARCHAR(255),

    url VARCHAR(255),
    img VARCHAR(255),

    gk_diving BIGINT DEFAULT 0,
    gk_handling BIGINT DEFAULT 0,
    gk_kicking BIGINT DEFAULT 0,
    gk_positioning BIGINT DEFAULT 0,
    gk_reflexes BIGINT DEFAULT 0
);

CREATE TABLE season_match (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    season_id BIGINT,
    player1_id BIGINT,
    player2_id BIGINT,
    winner_id BIGINT,
    round INT
);

CREATE TABLE season (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    started BOOLEAN,
    created_at TIMESTAMP DEFAULT
    CURRENT_TIMESTAMP,
    finished_at TIMESTAMP DEFAULT
                    CURRENT_TIMESTAMP,
    user_id BIGINT
);

CREATE TABLE season_participant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    season_id BIGINT,
    user_id BIGINT,
    club_id BIGINT,
    round INT,
    eliminated BOOLEAN,
    active BOOLEAN
);

-- ai club
CREATE TABLE ai_club (
    club_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    ovr INT,
    price INT,
    age INT,
    pace INT,
    def INT,
    atk INT,
    cch INT,
    stm INT
--    FOREIGN KEY (user_id) REFERENCES user_info(id)
);

-- ai formation
CREATE TABLE ai_formation (
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
--    p18 INT,
--    p19 INT,
--    p20 INT,
--    p21 INT,
--    p22 INT,
--    p23 INT,
--    p24 INT,
--    p25 INT,
--    p26 INT,
    FOREIGN KEY (club_id) REFERENCES ai_club
    (club_id)
);
