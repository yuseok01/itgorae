DROP DATABASE IF EXISTS SSACCER;
CREATE DATABASE SSACCER;

USE SSACCER;

CREATE TABLE TEAM (
	team_id	INT	AUTO_INCREMENT, -- 팀 고유 번호
	team_name VARCHAR(100) NOT NULL, -- 팀 명
	team_img VARCHAR(255), -- 로고
	points	INT DEFAULT 0, -- 승점
	goals INT DEFAULT 0, -- 골
	assists	INT DEFAULT 0, -- 어시스트
	conceded INT DEFAULT 0, -- 실점
	won	INT DEFAULT 0, -- 승
	drawn INT DEFAULT 0, -- 무
	lost INT DEFAULT 0, -- 패
	played INT DEFAULT 0, -- 총 경기수
    region	VARCHAR(50), -- 지역
	match_time VARCHAR(100), -- 주 활동 시간
	create_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 생성일자
	home_stadium VARCHAR(100), -- 홈 구장
    PRIMARY KEY(team_id)
);

CREATE TABLE USER ( -- 사용자
	user_id	INT	AUTO_INCREMENT, -- 사용자 고유번호
	team_id	INT DEFAULT 0, -- 소속 팀
	user_name VARCHAR(50), -- 이름
	nickname VARCHAR(50) UNIQUE, -- 닉네임
	email VARCHAR(100), -- 이메일
	password VARCHAR(100), -- 비밀번호
	user_image VARCHAR(255), -- 사용자 사진
	user_goals INT DEFAULT 0, -- 득점 수
	user_assists INT DEFAULT 0, -- 도움 수
	user_rank ENUM('1','2','3','4') DEFAULT '4', -- 1: 감독, 2: 코치, 3: 선수, 4: 팀 없음
    position VARCHAR(50), -- 주 포지션
    PRIMARY KEY(user_id),
    FOREIGN KEY(team_id) REFERENCES TEAM(team_id)
);

CREATE TABLE MATCH_REQUEST ( -- 시합 요청
	match_request_id INT AUTO_INCREMENT, -- 시합 요청 고유 번호
    team_id_from INT, -- 요청 팀 고유번호
    team_id_to INT, -- 요청받은 팀 고유번호
    team_name_from VARCHAR(100), -- 요청 팀 이름
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 요청
    PRIMARY KEY(match_request_id),
    FOREIGN KEY(team_id_from) REFERENCES TEAM(team_id),
    FOREIGN KEY(team_id_to) REFERENCES TEAM(team_id)
);

CREATE TABLE TEAM_BOARD ( -- 경기 수락 시에, 팀 별로 생성
	board_id INT AUTO_INCREMENT, -- 보드 고유 번호
	team_id	INT	NOT NULL, -- 팀 고유번호
	title VARCHAR(200), -- 제목
	content	TEXT, -- 경기 내용
	video_url VARCHAR(255), -- 피드백 영상 주소
    squad_url VARCHAR(255), -- 스쿼드 주소
    goals INT,
	conceded INT,
	result ENUM('win', 'loss', 'draw'),
	create_at DATETIME,
    PRIMARY KEY(board_id),
    FOREIGN KEY(team_id) REFERENCES TEAM(team_id)
);

CREATE TABLE BOARD_DETAIL ( -- 경기 상세
    board_detail_id INT AUTO_INCREMENT, -- 경기 상세 고유번호
    board_id INT, -- 경기 고유번호 참조
    user_id INT, -- 득점, 도움한 선수 참조
    goals INT DEFAULT 0, -- 득점 수
    assists INT DEFAULT 0, -- 도움 수
    position VARCHAR(50), -- 포지션
    PRIMARY KEY (board_detail_id),
    FOREIGN KEY (board_id) REFERENCES TEAM_BOARD (board_id),
    FOREIGN KEY (user_id) REFERENCES USER (user_id)
);

CREATE TABLE TEAM_BOARD_REVIEW ( -- 경기 피드백
	review_id INT AUTO_INCREMENT,
	board_id INT NOT NULL,
	team_id	INT	NOT NULL,
	user_id	INT	NOT NULL,
	comment	TEXT, -- 피드백 내용
    PRIMARY KEY(review_id),
    FOREIGN KEY(board_id) REFERENCES TEAM_BOARD(board_id),
    FOREIGN KEY(team_id) REFERENCES USER(team_id),
    FOREIGN KEY(user_id) REFERENCES USER(user_id)
);

-- MARKET
CREATE TABLE TEAM_RECRUITMENT_BOARD ( -- 회원 모집 게시판 (팀이 회원을 구함)
	id INT AUTO_INCREMENT, -- 게시판 고유번호
	team_id	INT, -- 팀 고유번호 참조
	title VARCHAR(200), -- 모집 제목
	content	TEXT, -- 모집 내용
	status ENUM('open', 'closed') DEFAULT 'open', -- 모집 현황
	create_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 작성 일자
    PRIMARY KEY(id),
    FOREIGN KEY(team_id) REFERENCES TEAM(team_id)
);

CREATE TABLE TEAM_RECRUITMENT_REVIEW ( -- 회원 모집 글 리뷰
	team_recruitment_review_id INT AUTO_INCREMENT, -- 리뷰 고유번호
    team_recruitment_id INT, -- 게시글 고유번호 참조
    user_id INT, -- 리뷰 작성자 고유번호 참조
    nickname VARCHAR(50), -- 작성자 닉네임
    position VARCHAR(50), -- 주 포지션
    content	TEXT, -- 리뷰 내용
    PRIMARY KEY(team_recruitment_review_id),
    FOREIGN KEY(team_recruitment_id) REFERENCES TEAM_RECRUITMENT_BOARD(id),
    FOREIGN KEY(user_id) REFERENCES USER(user_id)
);

CREATE TABLE TEAM_APPLICATION ( -- 가입 신청
    id INT AUTO_INCREMENT, -- 신청 고유번호
    recruitment_board_id INT, -- 모집 게시판 고유번호 참조
    team_id INT, -- 팀 고유번호 참조
    user_id INT, -- 신청자 ID (USERS 또는 MEMBERS 테이블을 가정)
    title VARCHAR(200), -- 신청 제목
    content TEXT, -- 신청 내용 또는 메시지
    application_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 신청 일자
    application_status ENUM('pending', 'approved', 'rejected') DEFAULT 'pending', -- 신청 상태(대기 중, 승인됨, 거절됨)
    PRIMARY KEY(id),
    FOREIGN KEY(recruitment_board_id) REFERENCES TEAM_RECRUITMENT_BOARD(id),
    FOREIGN KEY(team_id) REFERENCES TEAM(team_id), -- TEAM 테이블의 team_id를 참조
    FOREIGN KEY(user_id) REFERENCES USER(user_id) -- USERS 테이블에 user_id가 있는 경우를 가정
);




-- CREATE TABLE USER_RECRUITMENT_BOARD ( -- 팀 모집 게시판 (개인이 팀을 구함)
-- 	user_recruitment_id INT AUTO_INCREMENT, -- 게시판 고유번호
-- 	user_id INT, -- 사용자 고유번호 참조
-- 	team_id INT, -- 사용자 팀 (없는 경우 0)
-- 	title VARCHAR(50), -- 제목
-- 	content TEXT, -- 내용
-- 	team_name VARCHAR(100), -- 현재 팀 이름 (없으면 '팀 없음')
-- 	region VARCHAR(50), -- 지역
-- 	position VARCHAR(50), -- 주 포지션
-- 	create_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 작성 일자
--     PRIMARY KEY(user_recruitment_id),
--     FOREIGN KEY(user_id) REFERENCES USER(user_id),
--     FOREIGN KEY(team_id) REFERENCES USER(team_id)
-- );

-- CREATE TABLE USER_RECRUITMENT_REVIEW ( -- 팀 모집 글 리뷰
-- 	user_recruitment_review_id INT AUTO_INCREMENT, -- 리뷰 고유번호
--     user_recruitment_id INT, -- 게시글 고유번호 참조
--     user_id INT, -- 작성자 고유번호 참조
--     team_id INT, -- 리뷰 작성팀 고유번호 참조
--     team_name VARCHAR(100), -- 팀 이름
--     nickname VARCHAR(50), -- 작성자 닉네임
--     position VARCHAR(50), -- 주 포지션
--     content	TEXT, -- 리뷰 내용
--     PRIMARY KEY(user_recruitment_review_id),
--     FOREIGN KEY(user_recruitment_id) REFERENCES USER_RECRUITMENT_BOARD(user_recruitment_id),
--     FOREIGN KEY(user_id) REFERENCES USER(user_id),
--     FOREIGN KEY(team_id) REFERENCES TEAM(team_id)
-- );
-- SELECT * FROM match_request; 
