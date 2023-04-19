USE cdpr_test_db;

CREATE TABLE game (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    description varchar(500) NOT NULL,
    price double(6,2) NOT NULL,
    currency char(3) NOT NULL,
    CONSTRAINT game_pk PRIMARY KEY (id)
);

CREATE TABLE admin (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(50) NOT NULL,
    password varchar(500) NOT NULL,
    CONSTRAINT admin_pk PRIMARY KEY (id)
);
