/**
 * 创建user表
 */
CREATE TABLE USER(
user_id  INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(20) NOT NULL
);
ALTER TABLE USER 
ADD COLUMN `password` VARCHAR(50) NOT NULL;
ALTER TABLE USER 
ADD COLUMN `gander` VARCHAR(50) NOT NULL;
ALTER TABLE USER 
ADD COLUMN `birth_place` VARCHAR(50) NOT NULL;
ALTER TABLE USER 
ADD COLUMN `hobby` VARCHAR(200) NOT NULL;


/*---------订单表-----------*/  
CREATE TABLE `order`(
   oid VARCHAR(50) PRIMARY KEY,
   `time` VARCHAR(50) NOT NULL,
   total DOUBLE NOT NULL,
   state INT NOT NULL,
   user_id INT NOT NULL,
   cname VARCHAR(50) NOT NULL,
   address VARCHAR(100) NOT NULL,
   phone VARCHAR(20)
);  
ALTER TABLE `order` ADD CONSTRAINT fk_user_id FOREIGN KEY(user_id) 
      REFERENCES USER(user_id);
      

/*---------订单内容表-----------*/  
CREATE TABLE orderitem(
   itemid INT PRIMARY KEY AUTO_INCREMENT,
   pid INT NOT NULL,
   oid VARCHAR(50),
   COUNT INT NOT NULL,
   subtotal DOUBLE NOT NULL
);  
ALTER TABLE orderitem ADD CONSTRAINT fk_pid FOREIGN KEY(pid) 
      REFERENCES product(pid);
ALTER TABLE orderitem ADD CONSTRAINT fk_oid FOREIGN KEY(oid) 
      REFERENCES `order`(oid);