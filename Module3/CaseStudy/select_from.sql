use furama;
-- yêu cầu 2
select *
from nhanvien
where nhanvien.hotenNhanVien like "K%"
or nhanvien.hotenNhanVien like "T%" 
or nhanvien.hotenNhanVien like "H%";

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
		hopdong.idHopDong , dichvu.tenDichVu , hopdong.ngayLamHopDong , hopdong.ngayKetThuc,sum(dichvu.chiPhiThue + dichvudikem.giaDichVu) as TongTien
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
