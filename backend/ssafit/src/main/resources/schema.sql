drop table if exists reviews;
drop table if exists login;
drop table if exists videos;
drop table if exists users;

-- 비디오 테이블 형성
CREATE TABLE IF NOT EXISTS videos (
    video_id int primary key auto_increment,
    title VARCHAR(50) not null,
    part varchar(20) not null,
    url varchar(50) not null,
    view_cnt int default 0
);

-- 샘플 영상 입력
insert into videos values (1, '영상 1', '상체', 'aaa', 0);
insert into videos values (2, '영상 2', '하체', 'aaa', 1);
insert into videos values (3, '영상 3', '어깨', 'aaa', 2);
insert into videos values (4, '영상 4', '다리', 'aaa', 3);

-- 비디오 테이블 출력
select * from videos;

-- 유저 테이블 형성
CREATE TABLE IF NOT EXISTS `users` (
    `user_id` VARCHAR(50) NOT NULL PRIMARY KEY,
    `user_password` VARCHAR(50) NOT NULL,
    `user_name` VARCHAR(50) NOT NULL
    );

-- 로그인 테이블 형성    
 CREATE TABLE IF NOT EXISTS `login` (
    `login_id` VARCHAR(50) NOT NULL ,
    CONSTRAINT `login_fk` FOREIGN KEY (`login_id`) REFERENCES `users`(`user_id`)
    );

-- 샘플 유저 입력
insert into users values ('ssafy1','ssafy1','김윤');
insert into users values ('ssafy2','ssafy2','박성혁');
insert into users values ('ssafy3','ssafy3','최은혜');
insert into users values ('ssafy4','ssafy4','황예빈');
insert into users values ('ssafy5','ssafy5','양명균');

-- 샘플 테이블 출력
select * from users;

-- 샘플 로그인유저 입력
insert into login values ('ssafy5');

-- 로그인유저 테이블 출력
select * from login;

-- 리뷰 테이블 형성
CREATE TABLE IF NOT EXISTS reviews (
  review_id INT NOT NULL AUTO_INCREMENT,
  video_id INT NOT NULL,
  user_id VARCHAR(50) NOT NULL,
  title VARCHAR(50) NOT NULL,
  user_name VARCHAR(50) NOT NULL,
  content TEXT NOT NULL,
  date TIMESTAMP DEFAULT now(),
  review_view_cnt INT NOT NULL DEFAULT 0,
  CONSTRAINT video_id_fk FOREIGN KEY (video_id) REFERENCES videos(video_id),
  CONSTRAINT `user_id_fk` FOREIGN KEY (user_id) REFERENCES users(user_id),
  CONSTRAINT `reviews_pk` PRIMARY KEY (`review_id`,`video_id`)
);

-- 리뷰 테이블 출력
select * from reviews;

