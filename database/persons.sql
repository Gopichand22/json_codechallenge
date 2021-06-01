CREATE TABLE persons(
	person_id INT NOT NULL PRIMARY KEY COMMENT 'person id',
    person_fname VARCHAR(100) NOT NULL COMMENT 'person first name',
    person_lname VARCHAR(100) NOT NULL COMMENT 'person last name',
    person_gender VARCHAR(8) NOT NULL COMMENT 'person gender',
    person_age INT NOT NULL COMMENT 'person age',
    address_id INT NOT NULL COMMENT 'address id foreign',
    FOREIGN KEY (address_id) REFERENCES address(address_id) 
);