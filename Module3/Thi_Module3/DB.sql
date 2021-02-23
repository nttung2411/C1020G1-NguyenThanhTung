drop database if exists codegym;

Create Database codegym;

create table phuong_thuc_thanh_toan(
id_phuong_thuc_thanh_toan int primary key,
ten_phuong_thuc varchar(45)
);


create table sanpham(
ten_sanpham varchar(45) primary key,
gia_sanpham double,
giamgia_sanpham double,
ton_kho int
);



create table nhanvien(
id_nhan_vien int primary key,
ten_nhan_vien varchar(45),
nam_sinh date,
dia_chi varchar(45)
);

create table khachhang(
id_khach_hang int primary key,
ten_khach_hang varchar(45),
nam_sinh date,
dien_thoai varchar(20),
dia_chi varchar(30),
email varchar(30)
);

create table donhang(	
id_don_hang int primary key,
id_phuong_thuc_thanh_toan int,
ten_san_pham varchar(30),
id_khach_hang int,
id_nhan_vien int,
ngay_dat_hang date,
ngay_giao_hang date,
dia_chi varchar(40),
foreign key (id_khach_hang) references khachhang(id_khach_hang),
foreign key (id_nhan_vien) references nhanvien(id_nhan_vien),
foreign key (ten_san_pham) references sanpham(ten_sanpham),
foreign key (id_phuong_thuc_thanh_toan) references phuong_thuc_thanh_toan(id_phuong_thuc_thanh_toan)
);


INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Iphone X', '1000', '10', '20');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Samsam note 10', '1200', '5', '60');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Samsung A5', '400', '6', '20');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Iphone 10', '600', '10', '40');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Iphone 8', '500', '10', '10');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Oppo F10', '350', '10', '50');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Samsung A1', '500', '10', '10');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Iphone 6', '300', '20', '10');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Iphone 7', '350', '15', '10');
INSERT INTO `codegym`.`sanpham` (`ten_sanpham`, `gia_sanpham`, `giamgia_sanpham`, `ton_kho`) VALUES ('Redmi note 8', '800', '5', '5');

INSERT INTO phuong_thuc_thanh_toan values (1,"Chuyển Khoản");
INSERT INTO phuong_thuc_thanh_toan values (2,"Tiền Mặt");

INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('1', 'Nguyen Van A', '1995-11-24', '0123456780', 'Da Nang', 'abc1@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('2', 'Nguyen Van B', '1995-11-11', '0123456781', 'Da Nang', 'abc2@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('3', 'Nguyen Van C', '1995-11-11', '0123456782', 'Da Nang', 'abc3@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('4', 'Nguyen Van D', '1995-11-11', '0123456783', 'Da Nang', 'abc4@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('5', 'Nguyen Van E', '1995-11-11', '0123456784', 'Da Nang', 'abc5@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('6', 'Nguyen Van F', '1995-11-11', '0123456785', 'Da Nang', 'abc6@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('7', 'Nguyen Van G', '1995-11-11', '0123456786', 'Da Nang', 'abc7@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('8', 'Nguyen Van H', '1995-11-11', '0123456787', 'Da Nang', 'abc8@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('9', 'Nguyen Van L', '1995-11-11', '0123456788', 'Da Nang', 'abc9@gmail.com');
 INSERT INTO `codegym`.`khachhang` (`id_khach_hang`, `ten_khach_hang`, `nam_sinh`, `dien_thoai`, `dia_chi`, `email`)
 VALUES ('10', 'Nguyen Van M', '1995-11-11', '0123456789', 'Da Nang', 'abc10@gmail.com');
 
 
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('1', 'Nguyen Thi A', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('2', 'Nguyen Thi B', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('3', 'Nguyen Thi C', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('4', 'Nguyen Thi E', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('5', 'Nguyen Thi F', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('6', 'Nguyen Thi G', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('7', 'Nguyen Thi H', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('8', 'Nguyen Thi L', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('9', 'Nguyen Thi M', '2000-11-11', 'Hue');
 INSERT INTO `codegym`.`nhanvien` (`id_nhan_vien`, `ten_nhan_vien`, `nam_sinh`, `dia_chi`) 
 VALUES ('10', 'Nguyen Thi N', '2000-11-11', 'Hue');
 
 
 INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`, `ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('1', '1', 'Iphone X', '1', '1', '2021-02-01', '2021-02-03', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('2', '2','Iphone 6', '2', '2', '2021-02-01', '2021-02-04', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('3', '1','Iphone 6', '3', '3', '2021-02-01', '2021-02-04', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('4', '2','Iphone 7', '4', '4', '2021-02-01', '2021-02-04', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('5', '1','Oppo F10', '5', '5', '2021-02-01', '2021-02-04', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('6', '1','Redmi note 8', '6', '6', '2021-02-01', '2021-02-04', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('7', '2','Iphone 6', '7', '7', '2021-02-01', '2021-02-04', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('8', '1','Samsung A1', '8', '8', '2021-02-01', '2021-02-04', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('9', '1','Samsung A5', '9', '9', '2021-02-01', '2021-02-04', 'Da Nang');
  INSERT INTO `codegym`.`donhang` (`id_don_hang`, `id_phuong_thuc_thanh_toan`,`ten_san_pham`, `id_khach_hang`, `id_nhan_vien`, `ngay_dat_hang`, `ngay_giao_hang`, `dia_chi`) 
 VALUES ('10', '1','Iphone 6', '10', '10', '2021-02-01', '2021-02-04', 'Da Nang');


DELIMITER $$

CREATE PROCEDURE select_all_product()

BEGIN
    
    SELECT *

    FROM sanpham;

    END$$

DELIMITER ;



DELIMITER $$

CREATE PROCEDURE add_new_product(
in new_product_name varchar(45),
in new_product_price double,
in new_product_discount double,
in new_product_stock int)

BEGIN
    
    Insert into sanpham
	values(new_product_name,new_product_price,new_product_discount,new_product_stock);
    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE select_by_date(in start_date date,
in end_date date)

BEGIN
    
    SELECT sanpham.ten_sanpham,sanpham.gia_sanpham,sanpham.giamgia_sanpham,sanpham.ton_kho

    FROM sanpham
    inner join donhang on donhang.ten_san_pham = sanpham.ten_sanpham
    where donhang.ngay_dat_hang between start_date and end_date;

    END$$

DELIMITER ;

drop procedure select_by_date;
