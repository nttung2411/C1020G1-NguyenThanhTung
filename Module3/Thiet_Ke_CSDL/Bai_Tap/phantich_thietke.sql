drop database if exists cars_shop;

create database cars_shop;

use cars_shop;

create table productlines(
	productLine varchar(50) primary key,
    textDescription text,
    image varchar(200)
    );

create table offices(
	officeCode int(10) primary key,
    city varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    state varchar(50),
    country varchar(50) not null,
    postalCode varchar(15) not null
    );

create table employees(
	employeeNumber int primary key,
    employeeName varchar(100) not null,
    email varchar(100) not null,
    jobTitle varchar(50) not null,
    reportTo int,
    officeCode int,
    foreign key (reportTo) references employees(employeeNumber),
    foreign key (officeCode) references offices (officeCode)
    );

create table customers(
	customerNumber int primary key,
    customerName varchar(50) not null,
    phone int (50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postalCode varchar(15) not null,
    country varchar(50) not null,
    creditLimit double,
    salesRepEmployeeNumber int,
    foreign key (salesRepEmployeeNumber) references employees (employeeNumber)
    );
    
create table orders(
	order_number int primary key,
    order_date date not null,
    requiredDate date not null,
    shippedDate date,
    status_car varchar(15) not null,
    comments text,
    quantityOrdered int not null,
    priceEach double not null,
    customerNumber int not null,
    foreign key (customerNumber) references customers(customerNumber)
    );
    
create table payments(
	customerNumber int not null,
    foreign key (customerNumber) references customers(customerNumber),
    checkNumber int primary key,
    paymentDate date not null,
    amount double not null
    );
    
create table products(
	productCode int primary key,
    productName varchar(70) not null,
    productScale varchar(10) not null,
    productVendor varchar(50) not null,
    productDescription text not null,
    quantityInStock int not null,
    buyPrice double not null,
    MSRP double not null,
    productLine varchar(50),
    foreign key (productLine) references productLines(productLine)
    );
    
create table orderDetail(
	productCode int,
    order_number int,
    primary key (productCode , order_number),
    foreign key (productCode) references products (productCode),
    foreign key (order_number) references orders (order_number)
    );
    

    

    
    