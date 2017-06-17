DROP TABLE IF EXISTS people;

CREATE TABLE people  (
  `person_id`  int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(20),
  `last_name` VARCHAR(20),
  PRIMARY KEY (`person_id`)
);