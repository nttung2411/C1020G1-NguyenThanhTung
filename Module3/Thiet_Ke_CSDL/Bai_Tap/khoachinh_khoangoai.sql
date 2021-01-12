drop database if exists bank_database;

create database bank_database;

use bank_database;

create table customers(
	customer_number int primary key,
    customer_name varchar(20) not null,
    customer_address varchar(40) not null
    );

create table email_customer(
	email varchar(100) primary key,
    customer_number int,
    foreign key (customer_number) references customers(customer_number)
    );

create table phone_customer(
	phone int primary key,
    customer_number int,
    foreign key (customer_number) references customers(customer_number)
    );
    
create table accounts(
	account_number int primary key,
    account_type varchar(40) not null,
    account_date date,
    balance int,
    customer_number int unique,
    foreign key (customer_number) references customers(customer_number)
    );
    
create table transactions(
	tran_number int primary key,
    account_number int,
    foreign key(account_number) references accounts(account_number),
    tran_date date not null,
    amounts int not null,
    descripttions varchar(100)
    );
    