


CREATE TABLE IF NOT EXISTS `User` (
  `userNumber` varchar(40) NOT NULL,
  `userId` varchar(40) NOT NULL,
  `userPassword` varchar(40) NOT NULL,
  `userName` varchar(40) NOT NULL,
  `userEmail` varchar(40) NOT NULL,
  `img` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`userNumber`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `videoBoard` (
`video_no` int NOT NULL AUTO_INCREMENT,
`title` varchar(100) NOT NULL,
`part` varchar(10) NOT NULL,
`description` varchar(1000) NOT NULL,
`video_url` varchar(1000) NOT NULL,
`uploader_id` varchar(50) NOT NULL,
`upload_data` DATETIME NOT NULL,
`view_cnt` INT DEFAULT 0, 
PRIMARY KEY(`videoNo`)
)ENGINE = innoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `reviews` (
`review_seq` INT NOT NULL AUTO_INCREMENT,
`content` VARCHAR(1000) NOT NULL,
`rating` INT NOT NULL,
`user_id` VARCHAR(50),
`video_seq` INT NOT NULL,
`review_date` DATETIME NOT NULL,
PRIMARY KEY(`review_seq`)
)ENGINE = innoDB DEFAULT CHARACTER SET = utf8mb4;


INSERT INTO users (id, password, name, email, age) values ("ssafy", "1234", "김싸피", "ssafy.kim@ssafy.com", 20);

SELECT * FROM users;