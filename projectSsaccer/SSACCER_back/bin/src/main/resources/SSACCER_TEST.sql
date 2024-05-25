
INSERT INTO TEAM (team_name, team_img, points, goals, assists, conceded, won, drawn, lost, played, region, match_time, home_stadium) VALUES
('팀 없음', NULL, 0, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, NULL),
('울산IT고래 FC', 'src/assets/teamlogo1.png', 18, 20, 15, 10, 6, 0, 4, 10, '울산', '주말 오전', '울산 스타디움'),
('부산은도은도은 FC', 'src/assets/teamlogo1.png', 15, 18, 12, 12, 4, 3, 3, 10, '부산', '주말 오후', '부산 스타디움'),
('목동광현 FC', 'src/assets/teamlogo1.png', 21, 25, 18, 8, 7, 0, 3, 10, '서울', '평일 저녁', '목동 스타디움'),
('영등포 장산범수 FC', 'src/assets/teamlogo1.png', 14, 16, 10, 14, 4, 2, 4, 10, '서울', '평일 저녁', '영등포 스타디움'),
('대전돌굴러가유 FC', 'src/assets/teamlogo1.png', 17, 22, 14, 13, 5, 2, 3, 10, '대전', '주말 오후', '대전 스타디움'),
('수서 무적 롯데 스터디 FC', 'src/assets/teamlogo1.png', 13, 15, 11, 15, 3, 4, 3, 10, '서울', '주말 오전', '수서 스타디움'),
('광주 띵산물 FC', 'src/assets/teamlogo1.png', 19, 23, 17, 9, 6, 1, 3, 10, '광주', '주말 오후', '광주 스타디움'),
('머구는 더워 FC', 'src/assets/teamlogo1.png', 12, 14, 10, 16, 3, 3, 4, 10, '대구', '주말 오후', '대구 스타디움'),
('안성은 경기아니야 FC', 'src/assets/teamlogo1.png', 16, 20, 12, 12, 5, 1, 4, 10, '경기', '주말 오전', '안성 스타디움'),
('분당은 서울이야 FC', 'src/assets/teamlogo1.png', 20, 24, 16, 11, 6, 2, 2, 10, '경기', '주말 오후', '분당 스타디움'),
('인천 바다사자 FC', 'src/assets/teamlogo1.png', 22, 26, 19, 9, 7, 1, 2, 10, '서울', '주말 오전', '인천 스타디움'),
('청주 청룡 FC', 'src/assets/teamlogo1.png', 18, 21, 15, 11, 6, 0, 4, 10, '대전', '주말 오후', '청주 스타디움'),
('성남 은빛독수리 FC', 'src/assets/teamlogo1.png', 17, 19, 13, 12, 5, 2, 3, 10, '경기', '평일 저녁', '성남 스타디움'),
('고양 호랑이 FC', 'src/assets/teamlogo1.png', 16, 18, 14, 14, 4, 3, 3, 10, '경기', '주말 오후', '고양 스타디움'),
('전주 불사조 FC', 'src/assets/teamlogo1.png', 19, 22, 16, 10, 6, 1, 3, 10, '광주', '주말 오전', '전주 스타디움'),
('안양 불꽃 FC', 'src/assets/teamlogo1.png', 14, 17, 11, 13, 4, 2, 4, 10, '경기', '평일 저녁', '안양 스타디움'),
('포항 강철 FC', 'src/assets/teamlogo1.png', 21, 24, 17, 8, 7, 1, 2, 10, '대구', '주말 오후', '포항 스타디움'),
('평택 폭풍 FC', 'src/assets/teamlogo1.png', 13, 15, 12, 15, 3, 3, 4, 10, '경기', '주말 오전', '평택 스타디움'),
('김포 번개 FC', 'src/assets/teamlogo1.png', 20, 23, 18, 10, 6, 2, 2, 10, '경기', '주말 오후', '김포 스타디움'),
('의정부 바람 FC', 'src/assets/teamlogo1.png', 15, 18, 14, 12, 4, 3, 3, 10, '경기', '평일 저녁', '의정부 스타디움');

SELECT * from TEAM;
SELECT * from TEAM;


INSERT INTO USER (team_id, user_name, nickname, email, password, user_image, user_goals, user_assists, user_rank, position)
VALUES 
(1, 'John Doe', 'JohnnyD', 'john.doe@example.com', 'password123', 'https://via.placeholder.com/150?text=John', 15, 10, '4', 'Forward'),
(1, 'Emily Davis', 'EmilyD', 'emily.davis@example.com', 'password321', 'https://via.placeholder.com/150?text=Emily', 7, 12, '4', 'Goalkeeper'),
(1, 'Daniel Lee', 'DannyL', 'daniel.lee@example.com', 'password000', 'https://via.placeholder.com/150?text=Daniel', 12, 11, '4', 'Defender'),
(1, 'Laura Martinez', 'LauraM', 'laura.martinez@example.com', 'password333', 'https://via.placeholder.com/150?text=Laura', 8, 9, '4', 'Midfielder'),
(2, 'Jane Smith', 'JaneS', 'jane.smith@example.com', 'password456', 'https://via.placeholder.com/150?text=Jane', 5, 8, '2', 'Midfielder'),
(2, 'Michael Johnson', 'MikeJ', 'michael.johnson@example.com', 'password654', 'https://via.placeholder.com/150?text=Michael', 18, 20, '1', 'Forward'),
(2, 'Sarah Kim', 'SarahK', 'sarah.kim@example.com', 'password111', 'https://via.placeholder.com/150?text=Sarah', 3, 7, '4', 'Goalkeeper'),
(3, 'Robert Brown', 'RobbyB', 'robert.brown@example.com', 'password789', 'https://via.placeholder.com/150?text=Robert', 20, 15, '3', 'Defender'),
(3, 'Jessica Wilson', 'JessW', 'jessica.wilson@example.com', 'password987', 'https://via.placeholder.com/150?text=Jessica', 10, 6, '2', 'Midfielder'),
(3, 'David Clark', 'DaveC', 'david.clark@example.com', 'password222', 'https://via.placeholder.com/150?text=David', 25, 18, '1', 'Forward');

INSERT INTO TEAM_RECRUITMENT_BOARD (team_id, title, content, status) VALUES
(2, '🔥 IT고래 FC에서 선수를 모집합니다 🔥', '가족같은 분위기로 즐겁게 참여할 선수를 모집합니다. 주 큰경기 1회, 풋살 1회 진행하고 있습니다. 주 경기 시간은 토요일 오후 울산 스타디움에서 진행합니다.', 'open'),
(3, '⚽ 부산은도은도은 FC에서 선수를 모집합니다 ⚽', '부산은도은도은 FC에서 열정적인 선수를 모집합니다. 주 경기 시간은 주말 오후 부산 스타디움에서 진행됩니다.', 'open'),
(4, '🏆 목동광현 FC에서 선수를 모집합니다 🏆', '목동광현 FC에서 경기에 참여할 선수를 찾고 있습니다. 주 경기 시간은 평일 저녁 목동 스타디움에서 진행됩니다.', 'open'),
(5, '💪 영등포 장산범수 FC에서 선수를 모집합니다 💪', '영등포 장산범수 FC에서 새로운 선수를 모집합니다. 주 경기 시간은 평일 저녁 영등포 스타디움에서 진행됩니다.', 'open'),
(6, '🚀 대전돌굴러가유 FC에서 선수를 모집합니다 🚀', '대전돌굴러가유 FC에서 함께할 선수를 찾고 있습니다. 주 경기 시간은 주말 오후 대전 스타디움에서 진행됩니다.', 'open'),
(7, '⚡ 수서 무적 롯데 스터디 FC에서 선수를 모집합니다 ⚡', '수서 무적 롯데 스터디 FC에서 팀을 강화할 선수를 모집합니다. 주 경기 시간은 주말 오전 수서 스타디움에서 진행됩니다.', 'open'),
(8, '🌟 광주 띵산물 FC에서 선수를 모집합니다 🌟', '광주 띵산물 FC에서 경기에 참여할 선수를 모집합니다. 주 경기 시간은 주말 오후 광주 스타디움에서 진행됩니다.', 'open'),
(9, '🔥 머구는 더워 FC에서 선수를 모집합니다 🔥', '머구는 더워 FC에서 새로운 선수를 찾고 있습니다. 주 경기 시간은 주말 오후 대구 스타디움에서 진행됩니다.', 'open'),
(10, '🚀 안성은 경기아니야 FC에서 선수를 모집합니다 🚀', '안성은 경기아니야 FC에서 함께할 선수를 모집합니다. 주 경기 시간은 주말 오전 안성 스타디움에서 진행됩니다.', 'open'),
(11, '⚽ 분당은 서울이야 FC에서 선수를 모집합니다 ⚽', '분당은 서울이야 FC에서 경기에 참여할 선수를 찾고 있습니다. 주 경기 시간은 주말 오후 분당 스타디움에서 진행됩니다.', 'open'),
(12, '🏆 인천 바다사자 FC에서 선수를 모집합니다 🏆', '인천 바다사자 FC에서 새로운 선수를 모집합니다. 주 경기 시간은 주말 오전 인천 스타디움에서 진행됩니다.', 'open'),
(13, '💪 청주 청룡 FC에서 선수를 모집합니다 💪', '청주 청룡 FC에서 팀을 강화할 선수를 찾고 있습니다. 주 경기 시간은 주말 오후 청주 스타디움에서 진행됩니다.', 'open'),
(14, '🌟 성남 은빛독수리 FC에서 선수를 모집합니다 🌟', '성남 은빛독수리 FC에서 경기에 참여할 선수를 모집합니다. 주 경기 시간은 평일 저녁 성남 스타디움에서 진행됩니다.', 'open'),
(15, '🔥 고양 호랑이 FC에서 선수를 모집합니다 🔥', '고양 호랑이 FC에서 새로운 선수를 찾고 있습니다. 주 경기 시간은 주말 오후 고양 스타디움에서 진행됩니다.', 'open'),
(16, '⚡ 전주 불사조 FC에서 선수를 모집합니다 ⚡', '전주 불사조 FC에서 팀을 강화할 선수를 모집합니다. 주 경기 시간은 주말 오전 전주 스타디움에서 진행됩니다.', 'open'),
(17, '💪 안양 불꽃 FC에서 선수를 모집합니다 💪', '안양 불꽃 FC에서 새로운 선수를 찾고 있습니다. 주 경기 시간은 평일 저녁 안양 스타디움에서 진행됩니다.', 'open'),
(18, '🚀 포항 강철 FC에서 선수를 모집합니다 🚀', '포항 강철 FC에서 경기에 참여할 선수를 모집합니다. 주 경기 시간은 주말 오후 포항 스타디움에서 진행됩니다.', 'open'),
(19, '⚽ 평택 폭풍 FC에서 선수를 모집합니다 ⚽', '평택 폭풍 FC에서 팀을 강화할 선수를 찾고 있습니다. 주 경기 시간은 주말 오전 평택 스타디움에서 진행됩니다.', 'open'),
(20, '🏆 김포 번개 FC에서 선수를 모집합니다 🏆', '김포 번개 FC에서 새로운 선수를 모집합니다. 주 경기 시간은 주말 오후 김포 스타디움에서 진행됩니다.', 'open'),
(21, '💪 의정부 바람 FC에서 선수를 모집합니다 💪', '의정부 바람 FC에서 경기에 참여할 선수를 찾고 있습니다. 주 경기 시간은 평일 저녁 의정부 스타디움에서 진행됩니다.', 'open'),
(2, '🔥 IT고래 FC 추가 모집 🔥', 'IT고래 FC에서 추가로 선수를 모집합니다. 주 경기 시간은 토요일 오후 울산 스타디움에서 진행합니다.', 'open'),
(3, '⚽ 부산은도은도은 FC 추가 모집 ⚽', '부산은도은도은 FC에서 추가로 선수를 모집합니다. 주 경기 시간은 주말 오후 부산 스타디움에서 진행됩니다.', 'open'),
(4, '🏆 목동광현 FC 추가 모집 🏆', '목동광현 FC에서 추가로 경기에 참여할 선수를 모집합니다. 주 경기 시간은 평일 저녁 목동 스타디움에서 진행됩니다.', 'open'),
(5, '💪 영등포 장산범수 FC 추가 모집 💪', '영등포 장산범수 FC에서 추가로 새로운 선수를 모집합니다. 주 경기 시간은 평일 저녁 영등포 스타디움에서 진행됩니다.', 'open'),
(6, '🚀 대전돌굴러가유 FC 추가 모집 🚀', '대전돌굴러가유 FC에서 추가로 함께할 선수를 찾고 있습니다. 주 경기 시간은 주말 오후 대전 스타디움에서 진행됩니다.', 'open'),
(7, '⚡ 수서 무적 롯데 스터디 FC 추가 모집 ⚡', '수서 무적 롯데 스터디 FC에서 추가로 팀을 강화할 선수를 모집합니다. 주 경기 시간은 주말 오전 수서 스타디움에서 진행됩니다.', 'open'),
(8, '🌟 광주 띵산물 FC 추가 모집 🌟', '광주 띵산물 FC에서 추가로 경기에 참여할 선수를 모집합니다. 주 경기 시간은 주말 오후 광주 스타디움에서 진행됩니다.', 'open'),
(9, '🔥 머구는 더워 FC 추가 모집 🔥', '머구는 더워 FC에서 추가로 새로운 선수를 찾고 있습니다. 주 경기 시간은 주말 오후 대구 스타디움에서 진행됩니다.', 'open');

SELECT * FROM team_recruitment_board;


-- //////////////////////


-- INSERT INTO USER (team_id, user_name, nickname, email, password, user_image, user_goals, user_assists, user_rank, position)
-- VALUES 
-- (1, 'John Doe', 'JohnnyD', 'john.doe@example.com', 'password123', 'john_image.jpg', 15, 10, '4', 'Forward'),
-- (1, 'Emily Davis', 'EmilyD', 'emily.davis@example.com', 'password321', 'emily_image.jpg', 7, 12, '4', 'Goalkeeper'),
-- (1, 'Daniel Lee', 'DannyL', 'daniel.lee@example.com', 'password000', 'daniel_image.jpg', 12, 11, '4', 'Defender'),
-- (1, 'Laura Martinez', 'LauraM', 'laura.martinez@example.com', 'password333', 'laura_image.jpg', 8, 9, '4', 'Midfielder'),
-- (2, 'Jane Smith', 'JaneS', 'jane.smith@example.com', 'password456', 'jane_image.jpg', 5, 8, '2', 'Midfielder'),
-- (2, 'Michael Johnson', 'MikeJ', 'michael.johnson@example.com', 'password654', 'michael_image.jpg', 18, 20, '1', 'Forward'),
-- (2, 'Sarah Kim', 'SarahK', 'sarah.kim@example.com', 'password111', 'sarah_image.jpg', 3, 7, '2', 'Goalkeeper'),
-- (3, 'Robert Brown', 'RobbyB', 'robert.brown@example.com', 'password789', 'robert_image.jpg', 20, 15, '3', 'Defender'),
-- (3, 'Jessica Wilson', 'JessW', 'jessica.wilson@example.com', 'password987', 'jessica_image.jpg', 10, 6, '2', 'Midfielder'),
-- (3, 'David Clark', 'DaveC', 'david.clark@example.com', 'password222', 'david_image.jpg', 25, 18, '1', 'Forward');


-- INSERT INTO USER (team_id, user_name, nickname, email, password, user_image, user_rank, position)
-- VALUES 
-- (1, 'Jane Smith', '오른발메시', 'jane_smith@gmail.com', 'password_no_team', NULL, '4', NULL),
-- (1, 'John Doe', '왼발호날두', 'john_doe@gmail.com', 'password_no_team', NULL, '4', NULL),
-- (2, '박성호', '강남기성용', 'park@yahoo.com', 'password3', NULL, '1', NULL),
-- (3, '정미경', '해운대지동원', 'jung@hotmail.com', 'password4', NULL, '1', NULL),
-- (4, '홍길동', '동성로김신욱', 'hong@outlook.com', 'password5', NULL, '1', NULL),
-- (5, '송영준', '부평조원희', 'song@aol.com', 'password6', NULL, '1', NULL),
-- (6, '이지은', '광주이동국', 'lee2@icloud.com', 'password7', NULL, '1', NULL);

SELECT * from team;