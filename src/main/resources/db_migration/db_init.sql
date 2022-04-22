create table users
(
    user_id  int primary key auto_increment not null,
    username   varchar(15) not null,
    user_password    varchar(15) not null,
    user_role         varchar(10) not null
);

create table products
(
	product varchar(20) not null primary key,
    quantity int not null,
    price double not null,
    category varchar (15)  not null
    );

create table items
(
	item_id int primary key auto_increment,
	product varchar(20) not null, foreign key (product) references products (product),
    quantity int not null,
    order_id int, foreign key (order_id) references orders (order_id)
    );

create table cart
(
	user_id int not null, foreign key (user_id) references users (user_id),
	item_id int, foreign key (item_id) references items (item_id)
	);
    
create table orders
(
	order_id int primary key auto_increment,
	user_id int not null, foreign key (user_id) references users (user_id),
    -- item_id int, foreign key (item_id) references items (item_id),
    order_status varchar (10) not null
    );
    
create table discounts
(
	discount varchar(30) not null,
    username varchar(20),
    product varchar(20),
    active boolean
    );
    
create role 'ADMIN', 'STANDARD_USER';

ALTER TABLE orders ;

DROP TABLE orders;