CREATE TABLE player (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rank BIGINT DEFAULT 0,
    name VARCHAR(100),
    ovr BIGINT default 0,
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
    gk_reflexes BIGINT DEFAULT 0,

    price BIGINT default 0
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
    is_ai BOOLEAN,
    coin BIGINT DEFAULT 0,
    tournament_token BIGINT DEFAULT 0,
    league_token BIGINT DEFAULT 0
);

CREATE TABLE my_club (
    club_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    user_id BIGINT NOT NULL,
    ovr BIGINT DEFAULT 0,
    price BIGINT DEFAULT 0,
    age BIGINT DEFAULT 0,
    pace BIGINT DEFAULT 0,
    def BIGINT DEFAULT 0,
    atk BIGINT DEFAULT 0,
    cch BIGINT DEFAULT 0,
    stm BIGINT DEFAULT 0,
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
    idx BIGINT DEFAULT 0,
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
    season_id BIGINT DEFAULT 0,
    player1_id BIGINT DEFAULT 0,
    player1_club_id BIGINT DEFAULT 0,
    player2_id BIGINT DEFAULT 0,
    player2_club_id BIGINT DEFAULT 0,
    winner_id BIGINT DEFAULT 0,
    is_ai1 BOOLEAN,
    is_ai2 BOOLEAN,
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
    ovr BIGINT DEFAULT 0,
    price BIGINT DEFAULT 0,
    age BIGINT DEFAULT 0,
    pace BIGINT DEFAULT 0,
    def BIGINT DEFAULT 0,
    atk BIGINT DEFAULT 0,
    cch BIGINT DEFAULT 0,
    stm BIGINT DEFAULT 0
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

CREATE TABLE my_store (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT DEFAULT 0,
    player_id BIGINT default -1,
    rank BIGINT DEFAULT 0,
    name VARCHAR(100),
    ovr BIGINT default 0,
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