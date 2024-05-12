-- USER 테이블 생성
CREATE TABLE USER (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    nickname VARCHAR(50),                          -- 유저 닉네임
    email VARCHAR(100) NOT NULL,
	phone_number VARCHAR(20),
    password VARCHAR(100) NOT NULL,
    user_image VARCHAR(255),
    user_goals INT DEFAULT 0,
    user_assists INT DEFAULT 0,
    team_id INT,
    FOREIGN KEY (team_id) REFERENCES TEAM(team_id)
);

-- TEAM 테이블 생성
CREATE TABLE Team (
    team_id INT AUTO_INCREMENT PRIMARY KEY,
    team_name VARCHAR(100) NOT NULL,
    region VARCHAR(50),
    created_at DATE,
    points INT DEFAULT 0,
    goals INT DEFAULT 0,
    assists INT DEFAULT 0,
    conceded INT DEFAULT 0,
    video_url VARCHAR(255),
    victories INT DEFAULT 0,
    defeats INT DEFAULT 0,
    draws INT DEFAULT 0,
    home_stadium VARCHAR(100),
    primary_match_time TIME,
    representative_number VARCHAR(20),
    director_id INT,  -- 감독의 사용자 ID (USER 테이블의 외래키)
    coach1_id INT,    -- 1번 코치의 사용자 ID (USER 테이블의 외래키)
    coach2_id INT,    -- 2번 코치의 사용자 ID (USER 테이블의 외래키)
    CONSTRAINT fk_director_id FOREIGN KEY (director_id) REFERENCES User(user_id),
    CONSTRAINT fk_coach1_id FOREIGN KEY (coach1_id) REFERENCES User(user_id),
    CONSTRAINT fk_coach2_id FOREIGN KEY (coach2_id) REFERENCES User(user_id),
    CONSTRAINT chk_coach_limit CHECK (
        (coach1_id IS NULL AND coach2_id IS NULL) OR
        (coach1_id IS NOT NULL AND coach2_id IS NULL) OR
        (coach1_id IS NOT NULL AND coach2_id IS NOT NULL)
    )
);

-- TEAM_BOARD 테이블 생성
CREATE TABLE TEAM_BOARD (
    board_id INT AUTO_INCREMENT PRIMARY KEY, -- 게시물 id
    team_id INT,                             -- 팀 고유 id
    title VARCHAR(200) NOT NULL,             -- 제목
    content TEXT,                            -- 경기 컨텐츠
    video_url VARCHAR(255),                  -- 경기 영상 URL
    result ENUM('win', 'loss', 'draw'),      -- 승무패 결과
    created_at DATETIME,
    FOREIGN KEY (team_id) REFERENCES TEAM(team_id)
);

-- TEAM_BOARD_REVIEW 테이블 생성
CREATE TABLE TEAM_BOARD_REVIEW (
    review_id INT AUTO_INCREMENT PRIMARY KEY, -- 팀보드리뷰
    board_id INT,                             -- 보드 고유 id 
    user_id INT,                              -- 리뷰 작성 id
    comment TEXT,                             -- 리뷰 내용 피드백
    created_at DATETIME,                      -- 작성시간 
    FOREIGN KEY (board_id) REFERENCES TEAM_BOARD(board_id),
    FOREIGN KEY (user_id) REFERENCES USER(user_id)
);

CREATE TABLE Recruitment_Board (
    recruitment_id INT AUTO_INCREMENT PRIMARY KEY,    -- 모집 고유 ID (자동 증가)
    team_id INT,                                      -- 모집하는 팀의 ID (TEAM 테이블의 외래키)
    recruitment_title VARCHAR(200) NOT NULL,          -- 모집 게시글 제목 (필수)
    recruitment_content TEXT,                         -- 모집 게시글 내용
    recruitment_status ENUM('open', 'closed') DEFAULT 'open',  -- 모집 상태 (모집 마감 모집 중)
    recruiter_user_id INT,                            -- 모집자(팀 리더)의 사용자 ID (USER 테이블의 외래키)
    created_at DATETIME,                              -- 모집 게시글 작성 일시
    FOREIGN KEY (team_id) REFERENCES TEAM(team_id),   -- TEAM 테이블의 team_id와 관계
    FOREIGN KEY (recruiter_user_id) REFERENCES USER(user_id)  -- USER 테이블의 user_id와 관계
);

CREATE TABLE User_Recruitment_Board (
    post_id INT AUTO_INCREMENT PRIMARY KEY,        -- 게시글 ID (자동 증가)
    user_id INT NOT NULL,                          -- 게시글 작성자의 사용자 ID (USER 테이블의 외래키)
    title VARCHAR(200) NOT NULL,                   -- 게시글 제목 (필수)
    content TEXT,                                  -- 게시글 내용
    team_name VARCHAR(100) NOT NULL,               -- 팀 이름 (필수)
    region VARCHAR(50),                            -- 활동 지역
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 게시글 작성 일시 (기본값: 현재 시간)
    CONSTRAINT fk_user_id_recruitment FOREIGN KEY (user_id) REFERENCES USER(user_id)
);

CREATE TABLE User_Recruitment_Review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,       -- 리뷰 ID (자동 증가)
    post_id INT NOT NULL,                           -- 리뷰 대상 게시글의 ID (User_Recruitment_Board 테이블의 외래키)
    user_id INT NOT NULL,                           -- 리뷰를 작성한 사용자의 ID (USER 테이블의 외래키)
    rating INT NOT NULL,                            -- 평점 (1~5 사이의 정수)
    comment TEXT,                                   -- 리뷰 내용
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 리뷰 작성 일시 (기본값: 현재 시간)
    CONSTRAINT fk_post_id FOREIGN KEY (post_id) REFERENCES User_Recruitment_Board(post_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES USER(user_id)
);


/*
주요기능 
1. 팀 대전 신청    (팀1 -> 팀2 대전 신청 팀2가 수락시 팀1 홈구장 경기 시간에서 경기)
2. 경기 결과 
3. 랭킹 시스템 (전국 팀 랭킹 , 각 구 팀 랭킹 , 개인 득점왕 , 지역 득점왕 등)
4. 팀원 모집 보드
5. 개인 팀 가입 보드 
6. 팀원들만 볼 수 있는 보드   경기 매칭시 자동생성 스쿼드 구성 (경기 결과 분석, 영상 분석 등 사진 전술판도 올릴 수 있으면 좋겠음 )
7. IndexPage 리그 마감 Dday 
8. 랭크 경기 일주일에 한번 

??? 
가입신청 어떻게? 
랭킹은 다 조인으로 조회??
승점올리는 방법은?? 홈팀이 결과 입력 어웨이팀이 승인? 


*/
