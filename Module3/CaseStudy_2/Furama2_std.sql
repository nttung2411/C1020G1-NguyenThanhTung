DELIMITER $$

CREATE PROCEDURE select_all_customer()

BEGIN
    
    SELECT customer_name,customer_gender,customer_email,customer_phone,customer_type,customer_address,customer_birthday,customer_id

    FROM customer;

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE search_customer(in search_name_customer varchar(50))

BEGIN
    
    SELECT customer_name,customer_gender,customer_email,customer_phone,customer_type,customer_address,customer_birthday

    FROM customer
    
    where customer_name = search_name_customer;

    END$$

DELIMITER ;




DELIMITER $$

CREATE PROCEDURE add_new_customer(
	in new_customer_id int ,
	in new_customer_type int,
    in new_customer_name varchar(45),
	in new_customer_birthday varchar(45),
    in new_customer_gender int(1),
    in new_customer_id_card varchar(45),
    in new_customer_phone varchar(45),
    in new_customer_email varchar(45),
    in new_customer_address varchar(45)
)
BEGIN

    insert into customer
    values(new_customer_id,new_customer_type,new_customer_name,new_customer_birthday,new_customer_gender,new_customer_id_card,new_customer_phone,new_customer_email,new_customer_address);
    
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE select_all_employee()

BEGIN
    
    SELECT *

    FROM employee;

    END$$

DELIMITER ;

drop procedure select_all_employee;

DELIMITER $$

CREATE PROCEDURE add_new_employee(
	in new_employee_id int ,
    in new_employee_name varchar(45),
	in new_employee_birthday varchar(45),
	in new_customer_gender int(1),
    in new_employee_id_card varchar(45),
    in new_employee_salary double,
    in new_employee_phone varchar(45),
    in new_employee_email varchar(45),
    in new_employee_address varchar(45),
    in new_employee_position int
)
BEGIN

    insert into employee
    values(new_employee_id,new_employee_name,new_employee_birthday,new_customer_gender,new_employee_id_card,new_employee_salary,new_employee_phone,new_employee_email,new_employee_address,new_employee_position);
    
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE search_employee(in search_employee_name varchar(50))

BEGIN
    
    SELECT employee_name,employee_gender,employee_email,employee_phone,position_id,employee_address,employee_birthday

    FROM employee
    
    where employee_name = search_employee_name;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE select_customer_by_id(in id_customer int)

BEGIN
    
    SELECT *

    FROM customer
    
    where id_customer = customer_id;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE update_customer(
in id_customer int,
in name_customer varchar(45),
in type_customer int,
in dateOfBirth_customer varchar(45),
in gender_customer int,
in id_card_customer varchar(45),
in phone_customer varchar(45),
in email_customer varchar(45),
in address_customer varchar(45))

BEGIN
	Update customer
    set customer_name = name_customer,
    customer_type = type_customer,
    customer_birthday = dateOfBirth_customer,
    customer_gender = gender_customer,
    customer_id_card = id_card_customer,
    customer_phone = phone_customer,
    customer_email = email_customer,
    customer_address = address_customer
    where customer_id = id_customer;
    End$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE delete_customer(in id_customer int)

BEGIN
    
    DELETE FROM customer
    
    where id_customer = customer_id;

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE delete_employee(in id_employee int)

BEGIN
    
    DELETE FROM employee
    
    where id_employee = employee_id;

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE update_employee(
in id_employee int,
in name_employee varchar(45),
in position_employee int,
in dateOfBirth_employee varchar(45),
in gender_employee int,
in id_card_employee varchar(45),
in phone_employee varchar(45),
in email_employee varchar(45),
in address_employee varchar(45),
in salary_employee double)

BEGIN
	Update employee
    set employee_name = name_employee,
    position_id = position_employee,
    employee_birthday = dateOfBirth_employee,
    employee_gender = gender_employee,
    employee_id_card = id_card_employee,
    employee_phone = phone_employee,
    employee_email = email_employee,
    employee_address = address_employee,
    employee_salary = salary_employee
    where employee_id = id_employee;
    End$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE select_employee_by_id(in id_employee int)

BEGIN
    
    SELECT *

    FROM employee
    
    where id_employee = employee_id;

    END$$

DELIMITER ;