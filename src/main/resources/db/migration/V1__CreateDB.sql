CREATE TABLE delivery (
    id SERIAL PRIMARY KEY,
    to_address VARCHAR(60) NOT NULL,
    from_address VARCHAR(60) NOT NULL,
    user_id INTEGER NOT NULL,
    status VARCHAR(30) NOT NULL
);

CREATE TABLE delivery_product (
    id SERIAL PRIMARY KEY,
    delivery_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    FOREIGN KEY(delivery_id) REFERENCES delivery(id)
);