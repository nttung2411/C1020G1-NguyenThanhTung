use design_database;

create table users(
	user_id int auto_increment primary key,
    user_name varchar(50),
    `password` varchar(30),
    email varchar(100)
    );
    
create table roles(
	role_id int auto_increment primary key,
    role_name varchar(50)
    );
    
create table userroles(
	user_id int  not null,
    role_id int not null,
    primary key(user_id,role_id),
    foreign key (user_id) references users(user_id),
    foreign key (role_id) references roles(role_id)
    );
    