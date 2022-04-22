USE app_database;

SHOW TABLES;

SELECT * FROM orders;

SELECT 
	user_id
FROM 
	users
WHERE
	username = 'ja';
    
DELETE FROM items WHERE item_id BETWEEN 14 AND 28;
DELETE FROM cart WHERE user_id = 4;

SELECT i.product, i.quantity, p.price, (i.quantity * p.price)
AS value
FROM products p
INNER JOIN items i ON p.product = i.product;

SELECT i.item_id, i.product, i.quantity, p.price, (i.quantity * p.price)
AS value
FROM cart c
JOIN users u ON u.user_id=c.user_id
JOIN items i ON c.item_id=i.item_id
JOIN products p ON p.product=i.product
WHERE u.user_id = 4;

SELECT *,
ROW_NUMBER() OVER (ORDER BY category) AS lp 
FROM products;

SELECT * 
FROM products 
WHERE category= 'drink'
ORDER BY product DESC;

SELECT order_id
FROM orders
ORDER BY order_id DESC
LIMIT 1;

SET @row_num=0;
SELECT
(@row_num:=@row_num+1) AS id,
product, quantity, price, category
FROM products 
WHERE product LIKE'%';

-- delete by row number
delete cl
    from products cl join
         (select cl.*, row_number() over (order by product) as seqnum
          from products cl
         ) cl2
         on cl2.product = cl.product
    where cl2.seqnum BETWEEN 1 AND 7;

INSERT INTO products
SELECT * FROM (SELECT 'Agrest', 10, 115.00, 'FRUIT') AS temp
WHERE NOT EXISTS (
	SELECT product FROM products WHERE product = 'Agrest')
    LIMIT 1;
    
UPDATE items
SET order_id = 5
WHERE item_id IN (35);
