drop database if exists furama;

create database furama;

use furama;

create table ViTri(
	idViTri int primary key,
    tenViTri varchar(45)
    );
    
create table TrinhDo(
	idTrinhDo int primary key,
    trinhDo varchar(45)
    );
    
create table BoPhan(
	idBoPhan int primary key,
    tenBoPhan varchar(45)
    );
    
create table LoaiKhach(
	idLoaiKhach int primary key,
    tenLoaiKhach varchar(45)
    );
    
create table KieuThue(
	idKieuThue int primary key,
    tenKieuThue varchar(45),
    giaThue int
    );
    
create table LoaiDichVu(
	idLoaiDichVu int primary key,
    tenLoaiDichVu varchar(45)
    );
    
create table NhanVien(
	idNhanVien int primary key,
    hotenNhanVien varchar(50) not null,
    ngaySinh date not null,
    soCMND int,
    luong double,
    soDienThoai varchar(20),
    emailNhanVien varchar(45),
    diaChiNhanVien varchar(45),
    idViTri int,
    idTrinhDo int,
    idBoPhan int,
    foreign key (idViTri) references ViTri(idViTri),
    foreign key (idTrinhDo) references TrinhDo(idTrinhDo),
    foreign key (idBoPhan) references BoPhan(idBoPhan)
    );
    
create table DichVu(
	idDichVu int primary key,
    tenDichVu varchar(45),
    dienTich int,
    soTang int,
    soNguoiToiDa int,
    chiPhiThue double,
    trangThai varchar(45),
    idKieuThue int,
    idLoaiDichVu int,
    foreign key (idKieuThue) references KieuThue(idKieuThue),
    foreign key (idLoaiDichVu) references LoaiDichVu(idLoaiDichVu)
    );
    

create table DichVuDiKem(
	idDichVuDiKem int primary key,
    tenDichVuDiKem varchar(45),
    giaDichVu int,
    trangThaiKhaDung varchar(45)
    );
    
create table KhachHang(
	idKhachHang int primary key,
    tenKhacHang varchar(45),
    ngaySinh date,
    soCMND varchar(45),
    soDienThoai varchar(45),
    emailKhachHang varchar(45),
    diaChi varchar(45),
    idLoaiKhach int,
    foreign key (idLoaiKhach) references LoaiKhach(idLoaiKhach)
    );
    
    create table HopDong(
	idHopDong int primary key,
    ngayLamHopDong date,
    ngayKetThuc date,
    tienDatCoc int,
    tongTien int,
    idNhanVien int,
    idKhachHang int,
    idDichVu int,
    foreign key (idNhanVien) references NhanVien(idNhanVien),
    foreign key (idKhachHang) references KhachHang(idKhachHang),
    foreign key (idDichVu) references DichVu(idDichVu)
    );
    
    create table HopDongChiTiet(
	idHopDongChiTiet int primary key,
    soLuong int,
    idHopDong int,
    idDichVuDiKem int,
    foreign key (idHopDong) references HopDong(idHopDong),
    foreign key (idDichVuDiKem) references DichVuDiKem(idDichVuDiKem)
    );
    