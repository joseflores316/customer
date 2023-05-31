DROP TABLE IF EXISTS CUSTOMERS;

CREATE TABLE CUSTOMERS (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               name VARCHAR(250) NOT NULL,
                               surname VARCHAR(250) NOT NULL,
                               fichero BLOB(250) DEFAULT NULL
);