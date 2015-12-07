CREATE TABLE USER (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  USERNAME VARCHAR (32) NOT NULL,
  NAME VARCHAR (64) NOT NULL,
  UNIQUE (USERNAME)
);

CREATE TABLE ADDRESS (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  street_name VARCHAR (50) NOT NULL,
  zip_code VARCHAR (50) NOT NULL,
  state_code VARCHAR (50) NOT NULL,
  UNIQUE (USERNAME)
);

CREATE TABLE USER_ADDRESS (
  user_id int,
 address_id int,
);