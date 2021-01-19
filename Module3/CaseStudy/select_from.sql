use furama;
-- yêu cầu 2
select *
from nhanvien
where (nhanvien.hotenNhanVien like "K%"
or nhanvien.hotenNhanVien like "T%" 
or nhanvien.hotenNhanVien like "H%")
and length(hotenNhanVien) < 15;

-- yêu cầu 3
select *
from KhachHang
where (year(current_timestamp) - year(KhachHang.ngaySinh) > 18) AND (khachhang.diaChi = "Đà Nẵng" or khachhang.diaChi = "Quảng Trị");

-- yêu cầu 4

SELECT 
    khachhang.tenKhacHang,
    COUNT(hopdong.idHopDong) AS 'Lần đặt phòng'
FROM 
    khachhang
        INNER JOIN
     hopdong ON khachhang.idKhachHang = hopdong.idKhachHang
        INNER JOIN
    loaikhach ON khachhang.idLoaiKhach = loaikhach.idLoaiKhach
WHERE
    loaikhach.tenLoaiKhach = "DiaMond"
    group by khachhang.idKhachHang order by 'Lần đặt phòng';
 
-- yêu cầu 5
select khachhang.idKhachHang , khachhang.tenKhacHang , loaikhach.tenLoaiKhach , 
		hopdong.idHopDong , dichvu.tenDichVu , hopdong.ngayLamHopDong , hopdong.ngayKetThuc,
        sum(dichvu.chiPhiThue + dichvudikem.giaDichVu*hopdongchitiet.soLuong) as TongTien
from khachhang
left join loaikhach on khachhang.idLoaiKhach = loaikhach.idLoaiKhach
left join hopdong on khachhang.idKhachHang = hopdong.idKhachHang
left join dichvu on hopdong.idDichVu = dichvu.idDichVu
left join hopdongchitiet on hopdong.idHopDong = hopdongchitiet.idHopDong
left join dichvudikem on hopdongchitiet.idDichVuDiKem = dichvudikem.idDichVuDiKem
group by hopdong.idHopDong;

-- yêu cầu 6
select dichvu.idDichVu , dichvu.tenDichVu , dichvu.dienTich , dichvu.chiPhiThue , loaidichvu.tenLoaiDichVu
from dichvu
inner join loaidichvu on dichvu.idLoaiDichVu = loaidichvu.idLoaiDichVu
inner join hopdong on dichvu.idDichVu = hopdong.idDichVu
where hopdong.ngayLamHopDong not in (select hopdong.ngayLamHopDong
from hopdong
where (ngayLamHopDong between "2019-01-01" and "2019-03-01"));

-- yêu cầu 7
SELECT 
    dichvu.idDichVu,
    dichvu.tenDichVu,
    dichvu.dienTich,
    dichvu.chiPhiThue,
    loaidichvu.tenLoaiDichVu
FROM
    dichvu
        INNER JOIN
    loaidichvu ON dichvu.idLoaiDichVu = loaidichvu.idLoaiDichVu
        INNER JOIN
    hopdong ON dichvu.idDichVu = hopdong.idDichVu
WHERE
    hopdong.ngayLamHopDong IN (SELECT 
            hopdong.ngayLamHopDong
        FROM
            hopdong
        WHERE
            (ngayLamHopDong < '2019-01-01'))
        AND hopdong.ngayLamHopDong NOT IN (SELECT 
            hopdong.ngayLamHopDong
        FROM
            hopdong
        WHERE
            (ngayLamHopDong BETWEEN '2019-01-01' AND '2020-01-01'))
            group by dichvu.idDichVu;
-- yêu cầu 8
select distinct khachhang.tenKhacHang
from khachhang;

select khachhang.tenKhacHang
from khachhang
union
select khachhang.tenKhacHang
from khachhang;

select khachhang.tenKhacHang
from khachhang
group by khachhang.tenKhacHang;

-- yêu cầu 9
select temp.month , sum(hopdong.tongTien) as TongTien , count(month(hopdong.ngayLamHopDong)) as SoLuongHopDong from
(select 1 as month
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as temp
left join hopdong on month (hopdong.ngayLamHopDong) = temp.month
where (hopdong.tongTien is not null) and (year(hopdong.ngayLamHopDong)="2021")
group by temp.month
order by month;

-- yêu cầu 10
select hopdong.idHopDong , hopdong.ngayLamHopDong , hopdong.ngayKetThuc , hopdong.tienDatCoc , count(hopdongchitiet.idHopDongChiTiet) as SoLuongDVDK
from hopdong
join hopdongchitiet on hopdong.idHopDong = hopdongchitiet.idHopDong
group by hopdong.idHopDong;

-- yêu cầu 11
select khachhang.tenKhacHang,dichvudikem.tenDichVuDiKem , dichvudikem.giaDichVu , dichvudikem.trangThaiKhaDung
from dichvudikem
join hopdongchitiet on hopdongchitiet.idDichVuDiKem = dichvudikem.idDichVuDiKem
join hopdong on hopdong.idHopDong = hopdongchitiet.idHopDong
join khachhang on khachhang.idKhachHang = hopdong.idKhachHang
where (khachhang.idLoaiKhach = 1) AND (khachhang.diaChi = "Vinh" or khachhang.diaChi = "Quảng Ngãi");

-- yêu cầu 12
select hopdong.idHopDong , nhanvien.hotenNhanVien , khachhang.tenKhacHang , khachhang.soDienThoai , dichvu.tenDichVu , count(hopdongchitiet.idHopDongChiTiet) as "Số lượng DVDK" , hopdong.tienDatCoc
from khachhang
join hopdong on hopdong.idKhachHang = khachhang.idKhachHang
join nhanvien on hopdong.idNhanVien = nhanvien.idNhanVien
join dichvu on hopdong.idDichVu = dichvu.idDichVu
join hopdongchitiet on hopdong.idHopDong = hopdongchitiet.idHopDong
where hopdong.ngayLamHopDong in (select hopdong.ngayLamHopDong from hopdong where (ngayLamHopDong between "2019-10-01" and "2019-12-01"))
and hopdong.ngayLamHopDong not in (select hopdong.ngayLamHopDong from hopdong where (ngayLamHopDong between "2019-01-01" and "2019-06-01"))
group by hopdong.idHopDong;
-- yêu cầu 13

create temporary table temp
select dichvudikem.tenDichVuDiKem , sum(soLuong) as soLuong
from dichvudikem
inner join hopdongchitiet on hopdongchitiet.idDichVuDiKem = dichvudikem.idDichVuDiKem
group by dichvudikem.idDichVuDiKem;

create temporary table temp2
select max(temp.soLuong) as max
from temp;

select * from temp2;

select temp.tenDichVuDiKem , temp.soLuong
from temp
inner join temp2 on temp.soLuong = temp2.max;

-- yêu cầu 14
create temporary table temp3
select hopdong.idHopDong , dichvu.tenDichVu , dichvudikem.tenDichVuDiKem , hopdongchitiet.soLuong , count(dichvu.tenDichVu) as countService
from hopdong
join hopdongchitiet on hopdongchitiet.idHopDong = hopdong.idHopDong
join dichvu on dichvu.idDichVu = hopdong.idDichVu
join dichvudikem on dichvudikem.idDichVuDiKem = hopdongchitiet.idDichVuDiKem
group by tenDichVuDiKem;

select idHopDong , tenDichVu , tenDichVuDiKem , soLuong
from temp3
where temp3.countService = 1;

-- yêu cầu 15
create view view_employees as
select idNhanVien , hotenNhanVien , trinhdo , tenbophan , sodienthoai , diachinhanvien
from nhanvien
inner join trinhdo on trinhdo.idTrinhDo = nhanvien.idTrinhDo
inner join bophan on bophan.idBoPhan = nhanvien.idBoPhan
group by idNhanVien order by idNhanVien;

create view SLHD as
select nhanvien.idNhanVien , hopdong.ngayLamHopDong , count(nhanvien.idNhanVien) as row_HD
from nhanvien
join hopdong on hopdong.idNhanVien = nhanvien.idNhanVien
where hopdong.ngayLamHopDong between "2018-01-01" and "2019-01-01"
group by nhanvien.idNhanVien;

select view_employees.idNhanVien , hotenNhanVien , trinhdo , tenbophan , sodienthoai , diachinhanvien
from view_employees
left join SLHD on view_employees.idNhanVien = SLHD.idNhanVien
where SLHD.row_HD < 4 or SLHD.row_HD is null;

-- yêu cầu 16
Delete from nhanvien
where  idNhanVien not in (
select hopdong.idNhanVien
 from hopdong
 where (year(hopdong.ngaylamhopdong) between 2018 and 2021)
 group by nhanvien.idNhanVien);
 
 select *
 from nhanvien;
 
 -- yêu cầu 17
Update khachhang
set idLoaiKhach = 1
where khachhang.idKhachHang in (select khachhang.idKhachHang
from hopdong
join dichvu on hopdong.idDichVu = dichvu.idDichVu
join hopdongchitiet on hopdongchitiet.idHopDong = hopdong.idHopDong
join dichvudikem on hopdongchitiet.idDichVuDiKem = dichvudikem.idDichVuDiKem
where year(hopdong.ngaylamhopdong) = 2021 and khachhang.idKhachHang = 2
group by khachhang.idKhachHang
Having sum(dichvu.chiPhiThue + hopdongchitiet.soLuong*dichvudikem.giaDichVu) > 800);

select * from khachhang;

-- yêu cầu 18
delete khachhang , hopdong , hopdongchitiet
from khachhang
left join hopdong
on khachhang.idKhachHang = hopdong.idKhachHang
left join hopdongchitiet
on hopdongchitiet.idHopDong = hopdong.idHopDong
where khachhang.idKhachHang not in(
select khachhang.idKhachHang
where year(hopdong.ngayLamHopDong) between 2019 and 2021
and khachhang.idKhachHang = hopdong.idKhachHang
);

-- yêu cầu 19
update dichvudikem
join hopdongchitiet
set giaDichVu = giaDichVu * 2
where exists (select dichvudikem.idDichVuDiKem
group by dichvudikem.idDichVuDiKem
having count(dichvudikem.idDichVuDiKem)>10);

-- yêu cầu 20
select idnhanvien ID , hotennhanvien HoTen , nhanvien.ngaySinh NgaySinh , nhanvien.diaChiNhanVien DiaChi,
 nhanvien.emailNhanVien Email, nhanvien.soDienThoai SoDienThoai
from nhanvien
union
select idKhachHang ID, khachhang.tenKhacHang , khachhang.ngaySinh , khachhang.diaChi , khachhang.emailKhachHang , khachhang.soDienThoai
from khachhang
group by ID;

-- yêu cầu 21
create view V_NhanVien as
select nhanvien.*
from nhanvien
join hopdong on nhanvien.idNhanVien = hopdong.idNhanVien
where nhanvien.diaChiNhanVien = "Hải Châu"
and hopdong.ngayLamHopDong = "2019-12-12";

-- yêu cầu 22
update V_NhanVien
set V_NhanVien.diaChiNhanVien = "Liên Chiểu";
drop view V_NhanVien;

-- yêu cầu 23
delimiter //
create procedure Sp_1 (in idkhachhang int)
begin
Delete from khachhang
where khachhang.idkhachhang = idkhachhang;
end//
delimiter ;

drop procedure Sp_1;

call Sp_1(7);

-- yêu cầu 24
delimiter //
create procedure Sp_2 (in new_idhopdong int , in new_ngaylamhopdong date , in new_ngayketthuc date , in new_tiendatcoc int ,
					   in new_idnhanvien int , in new_idkhachhang int , in new_iddichvu int)
begin
if new_idhopdong not in (select idhopdong from hopdong)
	and new_idkhachhang in (select idkhachhang from khachhang)
    and new_iddichvu in (select iddichvu from dichvu)
    and new_idnhanvien in (select idnhanvien from nhanvien) then
    insert into hopdong values(new_idhopdong,new_ngaylamhopdong,new_ngayketthuc,new_tiendatcoc,new_idnhanvien,new_idkhachhang,new_iddichvu);
else
	select "Thông tin không hợp lệ";
end if;
end// 
delimiter ;

drop procedure Sp_2;

call Sp_2(10,"2021-01-01","2021-12-01",1000,2,1,1);

-- yêu cầu 25
delimiter //
create trigger Tr_1
after delete on hopdong
for each row
set @count = (select count(hopdong.idhopdong) from hopdong);
// delimiter ;

delete from hopdong where hopdong.idhopdong = 10;

select @count as TongSoHD;

-- yêu cầu 26
-- delimiter //
-- create trigger Tr_2
-- before update on hopdong
-- for each row
