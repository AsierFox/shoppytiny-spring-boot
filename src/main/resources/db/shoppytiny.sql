
CREATE TABLE Categories (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80) NOT NULL
) Engine = InnoDB;

CREATE TABLE Products (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    image VARCHAR(80) NOT NULL,
    description VARCHAR(250) NOT NULL,
    price FLOAT NOT NULL
) Engine = InnoDB;

CREATE TABLE category_product (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    category_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Categories (id),
    FOREIGN KEY (product_id) REFERENCES Products (id)
) Engine = InnoDB;
