CREATE TABLE newsletter(
id int AUTO_INCREMENT,
name varchar(60),
email varchar(60) UNIQUE,
PRIMARY KEY(id));


CREATE TABLE guest(
id int AUTO_INCREMENT,
name varchar(60),
description varchar(255),
PRIMARY KEY(id));