create database view_index_sp;

use view_index_sp;

create table products(
	idProduct int primary key auto_increment,
    productCode varchar(30),
    productName varchar(50),
    productPrice double,
    productAmount int,
    productDescription varchar(100),
    productStatus varchar(100)
    );
    
create unique index index_products_code
on products(productCode);

create unique index index_products_name_price
on products(productName,productPrice);

select *
from products;

show index from products;

-- tạo view

create view view_products as
select productCode,productName,productStatus,productPrice
from products;

select *
from view_products;

update view_products
set productName = "Iphone"
where productName = "Nokia";

drop view view_products;

-- stored procedure

Delimiter //
create procedure show_all_products()
Begin
select * from products;
End;//
Delimiter ;

call show_all_products();

Delimiter //
create procedure insert_products()
Begin
insert into products(productCode,productName,productPrice,productAmount,productDescription,productStatus) values ("A02","Nokia",100.3,1,null,"Cũ");
End;//
Delimiter ;

call insert_products();

Delimiter //
create procedure update_products(in id int)
Begin
update products
set productCode = "A03"
where idProduct = id;
End;//
Delimiter ;

set @idUpdate = 3;

call update_products(@idUpdate);

call show_all_products();


Delimiter //
create procedure delete_products(in id int)
Begin
delete from products
where idProduct = id;
End;//
Delimiter ;

set @id = 2;
call delete_products(@id);
call show_all_products();