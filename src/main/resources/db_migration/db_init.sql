create table users
(
    user_id  int primary key auto_increment not null,
    username   varchar(15) not null,
    password    varchar(15) not null,
    role         varchar(10) not null,
    active       boolean
);

create table products
(
	product_id int primary key auto_increment not null,
	product_name varchar(20) not null,
    quantity int not null,
    price double not null,
    category varchar (15)  not null,
    active boolean
    );

create table items
(
	username varchar(20) not null,
    product_name varchar(20) not null,
    quantity int not null
    );
    
create table orders
(
	order_id int primary key auto_increment,
	username varchar(20),
    order_items varchar(20) not null,
    status varchar (10) not null
    );
    
create table discounts
(
	discount varchar(30) not null,
    username varchar(20),
    product varchar(20),
    active boolean
    );