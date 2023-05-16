DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               login VARCHAR(250) NOT NULL,
                               password VARCHAR(250) NOT NULL,
                               email VARCHAR(250) DEFAULT NULL,
                               first_name VARCHAR(250) NOT NULL,
                               last_name VARCHAR(250) NOT NULL
);
DROP TABLE IF EXISTS ROLES;
CREATE TABLE ROLES (
                        id INT ,
                        name VARCHAR(250) NOT NULL,
                        foreign key (id) references USERS(id)
);