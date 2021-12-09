-- create schema `Website`;

use `Website`;

drop table if exists `student` , `teacher` , `user`, `authorities`;

SET FOREIGN_KEY_CHECKS = 0;


-- CREATE TABLE `Student` (
--   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
--   `first_name` varchar(45) DEFAULT NULL,
--   `last_name` varchar(45) DEFAULT NULL,
--   `username` varchar(45) DEFAULT NULL,
--   `password` varchar(64) DEFAULT NULL,
--   `email` varchar(45) DEFAULT NULL,
--   `birthday` date default null, 
--   `locked` boolean,
--   `enabled` boolean,
--   PRIMARY KEY (`id`)
--   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- CREATE TABLE `Teacher` (
--   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
--   `first_name` varchar(45) DEFAULT NULL,
--   `last_name` varchar(45) DEFAULT NULL,
--   `username` varchar(45) DEFAULT NULL,
--   `password` varchar(64) DEFAULT NULL,
--   `email` varchar(45) DEFAULT NULL,
--   `birthday` date default null, 
--   `locked` boolean,
--   `enabled` boolean,
--   PRIMARY KEY (`id`)
--   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
--   
--   CREATE TABLE `User` (
--   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
--   `first_name` varchar(45) DEFAULT NULL,
--   `last_name` varchar(45) DEFAULT NULL,
--   `username` varchar(45) DEFAULT NULL,
--   `password` varchar(64) DEFAULT NULL,
--   `email` varchar(45) DEFAULT NULL,
--   `birthday` date default null, 
--   `locked` boolean,
--   `enabled` boolean,
--   PRIMARY KEY (`id`)
--   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
