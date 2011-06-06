DROP DATABASE cs_homework;
CREATE DATABASE cs_homework;
USE cs_homework;

CREATE TABLE members (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       kind ENUM('consumer', 'retailer', 'wholesaler', 'factory'),
       username VARCHAR(45),
       password VARCHAR(45)
);

CREATE TABLE reports (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       filename TEXT,
       members_id INT
);

CREATE TABLE buying_wholesaler_items (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       count INT,
       account VARCHAR(45),
       state VARCHAR(45),
       members_id INT,
       factory_items_id INT
);

CREATE TABLE buying_retailer_items (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       count INT,
       account VARCHAR(45),
       state VARCHAR(45),
       members_id INT,
       wholesaler_items_id INT
);

CREATE TABLE buying_items (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       count INT,
       account VARCHAR(45),
       state VARCHAR(45),
       members_id INT,
       retailer_items_id INT
);

CREATE TABLE factory_items (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       count INT,
       items_id INT
);

CREATE TABLE wholesaler_items (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       count INT,
       items_id INT
);

CREATE TABLE retailer_items (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       count INT,
       items_id INT
);

CREATE TABLE consumer_items (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       count INT,
       desc_head TEXT,
       items_id INT
);

CREATE TABLE items (
       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(45),
       price INT,
       description TEXT
)