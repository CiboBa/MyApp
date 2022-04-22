INSERT INTO users (username, user_password, user_role)
VALUES 
('admin', '1111', 'ADMIN'),
('ja', '123', 'STANDARD');

INSERT INTO users
SELECT * FROM (SELECT null,'kapar', 'mmm', 'STANDARD') AS temp
WHERE NOT EXISTS (
	SELECT username FROM users WHERE username = 'kapar')
    LIMIT 1;

INSERT INTO products (product, quantity, price, category)
VALUES
('Banana', 1, 1.00, 'FRUIT'),
('Apple', 5, 12.00, 'FRUIT'),
('Pear', 3, 5.00, 'FRUIT'),
('Carrot', 6, 54.00, 'VEGETABLE'),
('Vodka', 10, 23.00, 'DRINK'),
('Juice', 34, 67.00, 'DRINK'), 
('Cucumber', 6, 2.00, 'VEGETABLE'),
('Water', 67, 56.60, 'DRINK'),
('Tomato', 32, 134.00, 'VEGETABLE'),
('Peach', 2, 1.00, 'FRUIT');

INSERT INTO cart
VALUES (4, 31);

INSERT INTO orders (user_id, order_status)
SELECT user_id, 'PENDING' FROM cart WHERE user_id = 4;

INSERT INTO orders
VALUES (null, 4, 'Banana', 5, 'PENDING');

INSERT INTO items (product, quantity)
VALUES ('Vodka', 5);

UPDATE items
SET order_id = 1
WHERE item_id = 2;

UPDATE users
SET username = 'ja', user_password = 123
WHERE user_id = 4;