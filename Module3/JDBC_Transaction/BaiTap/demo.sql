drop database if exists demo;

CREATE database demo;

use demo;

create table users (
id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id));
 
 create table Permision(

id int(11) primary key auto_increment,

`name` varchar(50)

);

drop table permision;

create table User_Permision(

permision_id int(11),

user_id int(11)

);

insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','Kenia');

insert into Permision(`name`) values('add');

insert into Permision(`name`) values('edit');

insert into Permision(`name`) values('delete');

insert into Permision(`name`) values('view');

DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.`name`, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(`name`, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE select_all_user()

BEGIN

    SELECT *

    FROM users;

    END$$

DELIMITER ;

drop procedure select_all_user;

DELIMITER $$

CREATE PROCEDURE update_user_by_id(
IN user_id varchar(50),

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50))

BEGIN

    Update users

	set `name` = user_name,
		email = user_email,
		country = user_country
    where id = user_id;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE delete_user(idDelete int)

BEGIN
delete from users
where idDelete = id;
    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE select_user_by_id(idselect int)

BEGIN
select *
from users
where id = idselect;
    END$$

DELIMITER ;
