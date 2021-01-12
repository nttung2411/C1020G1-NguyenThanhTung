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