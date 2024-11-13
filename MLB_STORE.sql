CREATE DATABASE MLB_STORE;
GO
USE MLB_STORE;
GO
--Use master
--GO

CREATE TABLE DanhMuc (
    ID_DanhMuc INT IDENTITY(1,1) PRIMARY KEY ,
    TenDanhMuc NVARCHAR(50) ,
    TrangThai nvarchar(30)
);

CREATE TABLE MauSac (
    ID_MauSac INT IDENTITY(1,1) PRIMARY KEY ,
    TenMauSac NVARCHAR(50) ,
    TrangThai nvarchar(30) 
);

CREATE TABLE Size (
    ID_Size INT IDENTITY(1,1) PRIMARY KEY ,
    TenSize NVARCHAR(50) ,
    TrangThai nvarchar(30)  
);

CREATE TABLE ChatLieu (
	ID_ChatLieu INT IDENTITY(1,1) PRIMARY KEY ,
    TenChatLieu NVARCHAR(50) ,
    TrangThai nvarchar(30) 
);

CREATE TABLE NhanVien(
	ID_Nhanvien INT IDENTITY(1,1) PRIMARY KEY ,
	MaNhanVien VARCHAR(10) ,
	TenNhanVien NVARCHAR(50),
	GioiTinh NVARCHAR(10) ,
	NgaySinh DATE  NULL,
	DiaChi NVARCHAR(100),
	Email VARCHAR(100),
	SDT VARCHAR(10),
	TaiKhoan VARCHAR(50),
	MatKhau VARCHAR(50) ,
	VaiTro Nvarchar(30) ,
	TrangThai Nvarchar(30) 
)

CREATE TABLE KhachHang (
    ID_KhachHang INT IDENTITY(1,1) PRIMARY KEY ,
    MaKhachHang VARCHAR(10) ,
    TenKhachHang NVARCHAR(50) ,
    GioiTinh NVARCHAR(10) ,
    SDT VARCHAR(10) ,
    DiaChi NVARCHAR(200) 
);

CREATE TABLE SanPham (
    ID_SanPham INT IDENTITY(1,1) PRIMARY KEY ,
    MaSanPham VARCHAR(10) ,
    TenSP NVARCHAR(50) ,
    GiaBan FLOAT ,
    SoLuong INT ,
    ID_Size INT ,
    ID_MauSac INT ,
    ID_ChatLieu INT ,
    ID_DanhMuc INT ,
    TrangThai nvarchar(30) ,
    FOREIGN KEY (ID_Size) REFERENCES Size(ID_Size),
    FOREIGN KEY (ID_MauSac) REFERENCES MauSac(ID_MauSac),
    FOREIGN KEY (ID_ChatLieu) REFERENCES ChatLieu(ID_ChatLieu),
    FOREIGN KEY (ID_DanhMuc) REFERENCES DanhMuc(ID_DanhMuc)
);

CREATE TABLE Voucher (
    ID_Voucher INT IDENTITY(1,1) PRIMARY KEY ,
    MaVoucher VARCHAR(20) ,
	TenVoucher nvarchar(100) ,
    NgayBatDau DATE ,
    NgayKetThuc DATE ,
	TiLeGiam float ,
    SoLuong INT ,
	DonHangToiThieu float ,
	GiamToiDa float ,
    TrangThai nvarchar(30)   
);

CREATE TABLE HoaDon (
    ID_Hoadon INT IDENTITY(1,1) PRIMARY KEY ,
	MaHD varchar(25) ,
    ID_Nhanvien INT ,
    ID_KhachHang INT ,
    ID_Voucher INT ,
    NgayTao DATE DEFAULT GETDATE(), -- Sử dụng GETDATE() để đặt ngày hiện tại làm giá trị mặc định
	TongTien FLOAT,
    TrangThai nvarchar(30) ,
	GhiChu nvarchar(300) ,
    FOREIGN KEY (ID_Nhanvien) REFERENCES NhanVien(ID_Nhanvien),
    FOREIGN KEY (ID_KhachHang) REFERENCES KhachHang(ID_KhachHang),
    FOREIGN KEY (ID_Voucher) REFERENCES Voucher(ID_Voucher)
);


CREATE TABLE HoaDonCT (
    ID_HoaDonCT INT IDENTITY(1,1) PRIMARY KEY ,
    ID_HoaDon INT  ,
    ID_SanPham INT  ,
    GiaBan FLOAT,
    SoLuongMua INT ,
	ThanhTien float,
    FOREIGN KEY (ID_HoaDon) REFERENCES HoaDon(ID_Hoadon),
    FOREIGN KEY (ID_SanPham) REFERENCES SanPham(ID_SanPham)
);



insert into NhanVien values 
	('NV01', N'Đào Thị Phương Thảo',N'Nữ', '2004-05-28', N'Ninh Bình', 'thaodtph45301@fpt.edu.vn', '0983299130', 'thao2854','Thao2854@', N'Quản lý', N'Đang làm việc'),
	('NV02', N'Vũ Thị Hoài Phương',N'Nữ', '2004-01-20', N'Ninh Bình', 'phuongvthph45125@fpt.edu.vn', '0983299131', 'phuong123','Phuong1234@', N'Nhân viên', N'Đang làm việc'),
	('NV03', N'Chử Đức Dũng',N'Nam', '2004-12-22', N'Phú Thọ', 'thaodtph45301@fpt.edu.vn', '0983299132', 'dung345','Dung345@', N'Nhân viên', N'Nghỉ việc'),
	('NV04', N'Hoàng Anh Tuấn',N'Nam', '2004-09-21', N'Nam Định', 'thaodtph45301@fpt.edu.vn', '0983299135', 'tuan567','Tuan567@', N'Nhân viên', N'Đang làm việc');
	
select MaNhanVien, TenNhanVien, Vaitro, Taikhoan, MatKhau, GioiTinh, Ngaysinh, SDT, Email, Diachi, Trangthai from NhanVien
select *from NhanVien


insert into KhachHang values 
	('KH01', N'Khách vãng lai', null, null, null),
	('KH02', N'Đỗ Hồng Quân', N'Nam', '0983299130', N'Yên Bái'),
	('KH03', N'Mai Thị Thư', N'Nữ', '0123456789', N'Ninh Bình'),
	('KH04', N'Trần Thị Thu Phương', N'Nữ', '0222222222', N'Nam Định');
select * from KhachHang

insert into Size values 
	(N'S', N'null'),
	(N'M', N'null'),
	(N'L', N'null'),
	(N'XL', N'null');
select * from Size


insert into MauSac values 
	(N'Xanh', N'null'),
	(N'Đỏ', N'null'),
	(N'Đen', N'null'),
	(N'Trắng', N'null');
select * from MauSac


insert into ChatLieu values 
	(N'Cotton', N'null'),
	(N'Vải', N'null'),
	(N'Da', N'null'),
	(N'Nhung', N'null');
select * from ChatLieu


insert into DanhMuc values 
	(N'Áo mùa hè', N'null'),
	(N'Áo mùa đông', N'null'),
	(N'Áo mùa thu', N'null');
select * from DanhMuc

insert into SanPham values 
	('SP01', N'Áo cổ lọ', 120000, 20, 1,2,3,3, N'Đang bán'),
	('SP02', N'Áo thun tay ngắn', 100000, 10, 1,2,3,2,N'Dừng bán' ),
	('SP03', N'Áo cổ V', 200000, 50, 3,1,3,3, N'Đang bán');
select * from SanPham

insert into Voucher values 
	('VC01', N'Giảm giá đặc biệt ', '2024-04-03', '2024-04-12', 15, 10, 200000, 500000, N'Đang áp dụng ');
INSERT INTO Voucher VALUES 
('VC02', N'Ưu đãi mùa xuân', '2024-04-13', '2024-04-20', 20, 15, 150000, 600000, N'Đang áp dụng');
INSERT INTO Voucher VALUES 
('VC03', N'Khuyến mãi hè', '2024-04-21', '2024-04-30', 25, 20, 100000, 700000, N'Đang áp dụng');
	select*from Voucher

--insert into HoaDon values 
--	('HD01', 1,2,1,'2024-04-03', 0, N'Đã thanh toán', '');
select*from HoaDon

--insert into HoaDonCT values 
--	(1, 2, 200000, 10,0);
select * from HoaDonCT



--select sp.MaSanPham, sp.TenSP, s.TenSize, ms.TenMauSac, cl.TenChatLieu, sp.SoLuong, sp.GiaBan, dm.TenDanhMuc, sp.TrangThai from SanPham sp
--join Size s on sp.ID_Size = s.ID_Size
--join ChatLieu cl on sp.ID_ChatLieu = cl.ID_ChatLieu
--join MauSac ms on sp.ID_MauSac = ms.ID_MauSac
--join DanhMuc dm on sp.ID_DanhMuc = dm.ID_DanhMuc
--where dm.TenDanhMuc = N'Áo mùa thu'

--SELECT hd.ID_Hoadon, 
--       hd.MaHD, 
--       nv.TenNhanVien, 
--       kh.TenKhachHang, 
--       vc.GiamToiDa, 
--       hd.NgayTao, 
--       hd.TrangThai, 
--       hd.GhiChu 
--FROM HoaDon hd
--JOIN NhanVien nv ON hd.ID_NhanVien = nv.ID_Nhanvien
--JOIN KhachHang kh ON hd.ID_KhachHang = kh.ID_KhachHang
--JOIN Voucher vc ON hd.ID_Voucher = vc.ID_Voucher;

--SELECT hd.ID_HoaDon, 
--       sp.TenSP, 
--       ct.GiaBan, 
--       ct.SoLuong, 
--       (ct.GiaBan * ct.SoLuong ) as N'Thanh tiền '

--FROM HoaDonCT ct
--JOIN HoaDon hd ON ct.ID_HoaDon = hd.ID_Hoadon
--JOIN SanPham sp ON ct.ID_SanPham = sp.ID_SanPham


--select ct.ID_HoaDonCT , TenSP, sp.GiaBan, ct.SoLuong, hd.ThanhTien from HoaDonCT ct 
--join SanPham sp on ct.ID_SanPham = sp.ID_SanPham 
--join HoaDon hd on ct.ID_HoaDon = hd.ID_HoaDon 
--Where hd.ID_HoaDon = 2 and sp.ID_SanPham = 2


