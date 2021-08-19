CREATE TABLE `product` (
  `product_id` bigint NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `is_active` int DEFAULT '1',
  PRIMARY KEY (`product_id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `category` (
  `category_id` bigint NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `medicaredb`.`product`
(`product_id`,`description`,`product_name`,`category_id`,`brand_name`,`image`,`price`,`quantity`,`is_active`)
VALUES
(9;"150 ML Cough syrup";"Benedryl";1;"Benedryl";"uploads/Benedryl.jpg ";70.0;100;1);

INSERT INTO `medicaredb`.`product`
(`product_id`,`description`,`product_name`,`category_id`,`brand_name`,`image`,`price`,`quantity`,`is_active`)
VALUES
(10;"Covid 19 injection";"Remdesiver";8;"Covifor";"uploads/remdesivar2.jpg ";1245.0;600;1);

INSERT INTO `medicaredb`.`product`
(`product_id`,`description`,`product_name`,`category_id`,`brand_name`,`image`,`price`,`quantity`,`is_active`)
VALUES
(11;"180 ml";"Aluminium Magnisum and Simthicoral  suspenstion";1;"OMNE";"uploads/omee_mps_colmint_syrup_170ml_0.jpg ";0.0;50;1);

INSERT INTO `medicaredb`.`product`
(`product_id`,`description`,`product_name`,`category_id`,`brand_name`,`image`,`price`,`quantity`,`is_active`)
VALUES
(12;"subahaanallah";"yaallaah madhadh kar";4;"Allahuakbar";"uploads/Benedryl.jpg ";4979779.0;0;1);

INSERT INTO `medicaredb`.`product`
(`product_id`,`description`,`product_name`,`category_id`,`brand_name`,`image`,`price`,`quantity`,`is_active`)
VALUES
(13;"170ML";"Remdesivar";8;"Covifor";"uploads/remdesivar2.jpg ";1245.0;0;1);

INSERT INTO `medicaredb`.`product`
(`product_id`,`description`,`product_name`,`category_id`,`brand_name`,`image`,`price`,`quantity`,`is_active`)
VALUES
(14;"cough syrup";"Benedrayl";1;"BenedRyl";"uploads/Benedryl.jpg ";60.0;50;0);

INSERT INTO `medicaredb`.`product`
(`product_id`,`description`,`product_name`,`category_id`,`brand_name`,`image`,`price`,`quantity`,`is_active`)
VALUES
(15;"10ml dosage";"CoviSheild";8;"Seerum";"uploads/banner.jpg ";150.0;5000;0);

INSERT INTO `medicaredb`.`product`
(`product_id`,`description`,`product_name`,`category_id`,`brand_name`,`image`,`price`,`quantity`,`is_active`)
VALUES
(16;"test";"test";3;"test";"uploads/corosal3.jpg ";4655.0;454;0);

INSERT INTO `medicaredb`.`category`
(`category_id`,`category_name`)
VALUES
(1;"Liquid");
INSERT INTO `medicaredb`.`category`
(`category_id`,`category_name`)
VALUES
(2;"Tablets");
INSERT INTO `medicaredb`.`category`
(`category_id`,`category_name`)
VALUES
(3;"Capsules");
INSERT INTO `medicaredb`.`category`
(`category_id`,`category_name`)
VALUES
(4;"Topical medicines");
INSERT INTO `medicaredb`.`category`
(`category_id`,`category_name`)
VALUES
(5;"Suppositories");
INSERT INTO `medicaredb`.`category`
(`category_id`,`category_name`)
VALUES
(6;"Drops");
INSERT INTO `medicaredb`.`category`
(`category_id`,`category_name`)
VALUES
(7;"Inhalers");
INSERT INTO `medicaredb`.`category`
(`category_id`,`category_name`)
VALUES
(8;"Injection");


INSERT INTO `medicaredb`.`admin_table`
(`user_id`,
`password`,
`user_name`)
VALUES
(1,"Admin12345","Admin");

INSERT INTO `medicaredb`.`admin`
(`user_id`,
`password`,
`user_name`)
VALUES
(1,"admin12345","admin");

INSERT INTO `medicaredb`.`admin`
(`admin_id`,
`password`,
`user_name`)
VALUES
(2,"password123","manager");

UPDATE `medicaredb`.`admin` SET `password` = ? WHERE `user_name` = ?1 AND  `password` = ?2;
 
