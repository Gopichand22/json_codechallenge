CREATE TABLE address(
	address_id INT NOT NULL PRIMARY KEY COMMENT 'address id',
    street_address VARCHAR(255) NOT NULL COMMENT 'street address',
    city VARCHAR(255) NOT NULL COMMENT 'city',
    state VARCHAR(255) NOT NULL COMMENT 'state',
    postal_code VARCHAR(255) NOT NULL COMMENT 'postal code'
);