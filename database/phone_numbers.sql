CREATE TABLE phone_numbers(
	ph_id INT NOT NULL PRIMARY KEY COMMENT 'phone number id',
    ph_type VARCHAR(255) NOT NULL COMMENT 'phone number type',
    ph_number VARCHAR(20) NOT NULL COMMENT 'phone number'
);