Tables needed for tommorow(22-04-2024)


create database javaproject;
use javaproject;

Admin
create table Admin(id int primary key,username varchar(30) not null,password varchar(30) not null);

Customer
create table Customer(name varchar(30),phoneNo varchar(11) primary key,points int,member varchar(5) default 'NO');

Cashier
create table Cashier(id int primary key,username varchar(20) unique,password varchar(20),cname varchar(30));

-- PRODUCTS --
 CREATE TABLE products (
    batch_id VARCHAR(30),
    product_id INT,
    prodname VARCHAR(30),
    price INT,
    quantity INT,
    sold_quantity INT DEFAULT 0,
    INDEX idx_batch_id (batch_id),
    INDEX idx_product_id (product_id)
);


-- BILL --
create table bill(bill_id int primary key AUTO_INCREMENT,cashier_id int,bill_date DATE, foreign key (cashier_id)references cashier(id));

-- CUSTOMER -- 
 create table customer(phone_no varchar(15) primary key,cname varchar(20), points int default 0, ismember varchar(5) default "NO",dob DATE);

 -- SALES TRANSCATION --
  CREATE TABLE salesmaster (
    ->     stransid INT AUTO_INCREMENT PRIMARY KEY,
    ->     phoneno VARCHAR(15),
    ->     salesamt DECIMAL(10,2),
    ->     stransdate DATE,
    ->     FOREIGN KEY (phoneno) REFERENCES customer(phone_no),
    ->     INDEX idx_stransid (stransid) -- Add index on stransid
    -> );

-- SALES DETAILS --
 CREATE TABLE salesdetails (
    sales_details_id INT AUTO_INCREMENT PRIMARY KEY,
    stransid INT,
    batch_id VARCHAR(30),
    product_id INT,
    quantity INT,
    FOREIGN KEY (stransid) REFERENCES salesmaster(stransid),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (batch_id) REFERENCES products(batch_id),
    INDEX idx_batch_id (batch_id),
    INDEX idx_product_id (product_id)
);
