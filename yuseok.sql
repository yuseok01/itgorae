CREATE TABLE IF NOT EXISTS users (
  `id` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

INSERT INTO users (id, password, name, email) VALUES ("uniqlo", "1234", "김유석", "kurladbtjr@naver.com");

CREATE TABLE IF NOT EXISTS product (
    product_Id INT NOT NULL,
    product_Code INT NOT NULL,
    production_Num INT NULL,
    color INT NULL,
    size INT NULL,
    cnt INT NULL,
    registration_date DATETIME,
    PRIMARY KEY (product_Id)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;
    
CREATE TABLE IF NOT EXISTS location (
	location INT AUTO_INCREMENT NOT NULL,
    type VARCHAR(7) NOT NULL,
    warehousing_Date DATETIME,
    PRIMARY KEY (location)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;