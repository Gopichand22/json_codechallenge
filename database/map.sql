CREATE TABLE map(
	map_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'mapping id',
    ph_id INT NOT NULL COMMENT 'phone number id foreign',
    person_id INT NOT NULL COMMENT 'person id foreign',
    FOREIGN KEY (ph_id) REFERENCES phone_numbers(ph_id),
    FOREIGN KEY (person_id) REFERENCES persons(person_id)
);