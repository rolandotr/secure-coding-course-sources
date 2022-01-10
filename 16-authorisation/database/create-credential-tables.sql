--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` bool NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('lecturer','{bcrypt}$2a$10$ssIuBDODB0X4IsvXYpy7oO6RhkpWbrw3fZHMQWPAAtdOxRtlslqoi',1),
('student','{bcrypt}$2a$10$bZ81.wh6dogcBP6EwPq08e7udbxxmz4LAPTCvYsWqV0zDdiaQrP7m',1),
('admin','{bcrypt}$2a$10$vo/jAPWgU9qUljO064rP5OiACMMoV72h0AfpjNADVLCatCQ6ClWTq',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('lecturer','ROLE_LECTURER'),
('student','ROLE_STUDENT'),
('admin','ROLE_ADMIN');