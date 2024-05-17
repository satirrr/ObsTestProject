CREATE TABLE IF NOT EXISTS ITEM(
    id BIGSERIAL PRIMARY KEY auto_increment,
    name VARCHAR(100) NOT NULL,
    price int NOT NULL
);

CREATE TABLE IF NOT EXISTS INVENTORY(
    id INT PRIMARY KEY auto_increment,
    item_id INT NOT NULL,
    qty INT NOT NULL,
    type VARCHAR(1) NOT NULL,
    CONSTRAINT fk_inv_item_id FOREIGN KEY (item_id)
    REFERENCES item(id)
);

CREATE TABLE IF NOT EXISTS "ORDER"(
    id INT PRIMARY KEY auto_increment,
    order_no VARCHAR(255) NOT NULL,
    item_id INT NOT NULL,
    qty INT NOT NULL,
    CONSTRAINT fk_odr_item_id FOREIGN KEY (item_id)
    REFERENCES item(id)
);