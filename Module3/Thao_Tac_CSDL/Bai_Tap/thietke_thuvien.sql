drop database if exists libary;

create database libary;

use libary;

create table books(
	book_name varchar(50) primary key,
    book_author varchar(50) not null,
    date_publication date
);
    
create table category (
	category_book varchar(50) not null,
    book_name varchar(50) unique,
    foreign key (book_name) references books(book_name)
);
    
create table students (
	student_id varchar(15) primary key,
    student_name varchar(50) not null,
    student_email varchar(50) not null,
    student_image blob
);

create table address(
	city varchar(50) not null,
    country varchar(50) not null,
    student_id varchar(15),
    foreign key (student_id) references students(student_id)
);    

create table borrowOder(
	student_id varchar(15),
    book_name varchar(50),
    primary key (student_id , book_name),
    foreign key (student_id) references students(student_id),
    foreign key (book_name) references books(book_name)
);