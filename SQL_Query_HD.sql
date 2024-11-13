USE MLB_STORE;
GO
-- Truy vấn thông tin hóa đơn theo MaHĐ
SELECT KH.ID_KhachHang , KH.TenKhachHang , HD.MaHD , NV.MaNhanVien , HD.NgayTao , 
HD.TongTien , V.MaVoucher , KH.MaKhachHang
FROM HoaDon HD
INNER JOIN KhachHang KH on kh.ID_KhachHang = HD.ID_KhachHang
INNER JOIN NhanVien NV on NV.ID_Nhanvien = hd.ID_Nhanvien
LEFT JOIN Voucher V on V.ID_Voucher = hd.ID_Voucher
WHERE HD.MaHD = N'HD87675'
select * from HoaDon
select * from Voucher
select * from KhachHang



select MaVoucher, NgayBatDau, NgayKetThuc, TiLeGiam, SoLuong, DonHangToiThieu, GiamToiDa, TrangThai
from Voucher where MaVoucher = N'VC01'

select ID_KhachHang, MaKhachHang, TenKhachHang, SDT from KhachHang
where KhachHang.MaKhachHang = 

update HoaDon
set ID_KhachHang  = 2

slee
where ID_Hoadon= 37 

--Truy vấn Voucher hợp lệ lên combobox.
SELECT * FROM Voucher V where V.TrangThai = N'Đang áp dụng' 
AND	V.NgayBatDau <= CURRENT_TIMESTAMP 
AND V.NgayKetThuc > CURRENT_TIMESTAMP
AND V.SoLuong > 0
--Truy Vấn voucher theo maVoucher
SELECT * FROM Voucher V where V.MaVoucher = N'VC02'




--Truy vấn danh sách hóa đơn
SELECT HD.MaHD , NV.TenNhanVien ,KH.TenKhachHang ,HD.NgayTao , HD.TrangThai
FROM HoaDon HD
INNER JOIN KhachHang KH on kh.ID_KhachHang = HD.ID_KhachHang
INNER JOIN NhanVien NV on NV.ID_Nhanvien = hd.ID_Nhanvien
WHERE HD.TrangThai = N'Chờ thanh toán'

--Tạo hóa đơn
--INSERT INTO HoaDon (MaHD , ID_Nhanvien , ID_KhachHang  , TrangThai )
--VALUES 
--(?,?,?,?)


update SanPham 
set SoLuong = 	19
where ID_SanPham = 1
TrangThai = N'Đang bán'

Select * from SanPham
Select * from HoaDonCT
delete  from HoaDonCT
--Truy vấn danh sách sản phẩm bán hàng
SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP , size.TenSize , MS.TenMauSac , DM.TenDanhMuc 
, CL.TenChatLieu , SP.SoLuong , SP.GiaBan 
FROM SanPham SP 
inner join Size size on size.ID_Size = sp.ID_Size
inner join MauSac ms on ms.ID_MauSac = sp.ID_MauSac
inner join DanhMuc dm on dm.ID_DanhMuc = sp.ID_DanhMuc
inner join ChatLieu cl on cl.ID_ChatLieu = sp.ID_ChatLieu
where sp.MaSanPham = ?
--sp.TrangThai = N'Đang bán'

--INSERT INTO HoaDonCT (ID_HoaDon , ID_SanPham , GiaBan , SoLuongMua , ThanhTien ) 
--VALUES ( ? , ? , ? , ? , ? ) 

--Update HoaDonCT
--set SoLuongMua = ? 
--where ID_HoaDonCT = ?

--delete HoaDonCT
--where ID_HoaDonCT = ?

--update SanPham
--set SoLuong = ? 
--where ID_SanPham = ?

--update SanPham 
--set SoLuong
--where ID_SanPham = ? 

--Select SUM(hdct.ThanhTien) as N'TongTien' from HoaDon hd
--INNER JOIN HoaDonCT hdct on hdct.ID_HoaDon = hd.ID_Hoadon
--where hd.ID_Hoadon = ?

SELECT hdct.ID_HoaDonCT , sp.MaSanPham , sp.TenSP , hdct.SoLuongMua , hdct.GiaBan , hdct.ThanhTien FROM HoaDonCT hdct 
INNER JOIN HoaDon hd on hdct.ID_HoaDon = hd.ID_Hoadon
INNER JOIN SanPham sp on hdct.ID_SanPham =  sp.ID_SanPham 
where hd.ID_Hoadon  = ?

select * from HoaDonCT
where ID_HoaDonCT = ?

select * from Voucher
Select * from HoaDon
Select * from HoaDonCT

delete from HoaDon
where MaHD  = ? 
delete from HoaDonCT

SELECT * FROM HoaDon HD
INNER JOIN HoaDonCT HDCT ON HD.ID_Hoadon = HDCT.ID_HoaDon
where HD.ID_Hoadon = 11



--Update hóa đơn thanh toán
update HoaDon 
set TrangThai = N'Đã thanh toán' , GhiChu= ? 
where ID_Hoadon = ?

--Truy vấn danh sách sản phẩm bán hàng
SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP , size.TenSize , MS.TenMauSac , DM.TenDanhMuc 
, CL.TenChatLieu , SP.SoLuong , SP.GiaBan 
FROM SanPham SP 
inner join Size size on size.ID_Size = sp.ID_Size
inner join MauSac ms on ms.ID_MauSac = sp.ID_MauSac
inner join DanhMuc dm on dm.ID_DanhMuc = sp.ID_DanhMuc
inner join ChatLieu cl on cl.ID_ChatLieu = sp.ID_ChatLieu
where sp.TrangThai = N'Đang bán' and size.TenSize = N'L'

select * from NhanVien
select * from KhachHang
select  * ,  CONVERT(varchar(10), HD.NgayTao , 120)  from HoaDon HD
SELECt * FROM HoaDon
select * from HoaDonCT
select * from Voucher

--SUM của SL sản phẩm trong HDCT với trạng thái "Đã thanh toán" : Giảm dần. 
SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP  , MS.TenMauSac , CL.TenChatLieu , S.TenSize, DM.TenDanhMuc
, SUM(HDCT.SoLuongMua) as N'SLBanDuoc'
FROM HoaDonCT HDCT 
INNER JOIN SanPham SP on SP.ID_SanPham = HDCT.ID_SanPham
INNER JOIN HoaDon HD on HD.ID_Hoadon = HDCT.ID_HoaDon
INNER JOIN MauSac MS ON MS.ID_MauSac = SP.ID_MauSac
INNER JOIN ChatLieu CL ON CL.ID_ChatLieu = SP.ID_ChatLieu 
INNER JOIN Size S ON S.ID_Size = SP.ID_Size
INNER JOIN DanhMuc DM ON DM.ID_DanhMuc = SP.ID_DanhMuc
GROUP BY SP.ID_SanPham , SP.TenSP , HD.TrangThai ,MS.TenMauSac 
, CL.TenChatLieu , S.TenSize, DM.TenDanhMuc	, SP.MaSanPham 
HAVING HD.TrangThai = N'Đã thanh toán'
Order by SUM(HDCT.SoLuongMua) desc;

--Truy vấn danh sách sản phẩm với số lượng sp giảm dần
SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP  , MS.TenMauSac 
, CL.TenChatLieu , S.TenSize, DM.TenDanhMuc , SP.SoLuong
FROM SanPham SP
INNER JOIN MauSac MS ON MS.ID_MauSac = SP.ID_MauSac
INNER JOIN ChatLieu CL ON CL.ID_ChatLieu = SP.ID_ChatLieu 
INNER JOIN Size S ON S.ID_Size = SP.ID_Size
INNER JOIN DanhMuc DM ON DM.ID_DanhMuc = SP.ID_DanhMuc
WHERE SP.SoLuong <= 5 AND SP.SoLuong > 0 AND  SP.TrangThai = N'Đang bán'
SELECT * FROM SanPham

--Truy vấn doanh thu = tông tiền ( Hóa Đơn ) vs trạng thái "Đã thanh toán"
Select SUM(HD.TongTien) as N'DoanhThu'  from HoaDon HD
WHERE HD.TrangThai = N'Đã thanh toán' AND HD.NgayTao >= '2024-04-02' AND HD.NgayTao <= '2024-04-17' 

--Tổng SL SP bán
SELECT SUM(HDCT.SoLuongMua) as N'SL_SP_Ban' FROM HoaDonCT HDCT 
INNER JOIN HoaDon HD ON HD.ID_Hoadon = HDCT.ID_HoaDon
WHERE HD.TrangThai = N'Đã thanh toán' AND HD.NgayTao >= ? AND HD.NgayTao <= ?
--Tổng SL Hóa Đớn


SELECT COUNT(HD.ID_Hoadon) as N'Tong_SoDonHang'  
FROM HoaDon HD 
WHERE HD.TrangThai = N'Đã thanh toán' AND HD.NgayTao >= ? AND HD.NgayTao <= ?

select hd.ID_Hoadon, hd.MaHD, nv.TenNhanVien, kh.TenKhachHang, vc.GiamToiDa,
hd.NgayTao, hd.TongTien, hd.TrangThai from HoaDon hd
join NhanVien nv on hd.ID_NhanVien = nv.ID_Nhanvien
JOIN KhachHang kh ON hd.ID_KhachHang = kh.ID_KhachHang
JOIN Voucher vc ON hd.ID_Voucher = vc.ID_Voucher

--Số tiền trả = SUM(Thanhtien) - SUM(ThanhTien) * Tỉ lệ giảm
SELECT HD.ID_Hoadon , HD.MaHD , HD.NgayTao , NV.TenNhanVien , KH.TenKhachHang, HD.TongTien
FROM HoaDon HD
INNER JOIN NhanVien NV   On NV.ID_Nhanvien = HD.ID_Nhanvien
INNER JOIN KhachHang KH  On KH.ID_KhachHang = HD.ID_KhachHang
WHERE HD.TrangThai = N'Đã thanh toán' AND HD.NgayTao >= ? AND HD.NgayTao <= ? 

SELECT V.TenVoucher , V.TiLeGiam , V.GiamToiDa 
FROM Voucher V
LEFT JOIN HoaDon HD On HD.ID_Voucher = V.ID_Voucher
WHERE HD.MaHD = 'HD58190'

SELECT SP.MaSanPham , SP.TenSP , HDCT.SoLuongMua  , HDCT.GiaBan ,
Ms.TenMauSac , S.TenSize , CL.TenChatLieu , HDCT.ThanhTien
FROM SanPham SP
INNER JOIN HoaDonCT HDCT On HDCT.ID_SanPham = SP.ID_SanPham
INNER JOIN HoaDon HD On HD.ID_Hoadon = HDCT.ID_HoaDon
INNER JOIN MauSac MS ON MS.ID_MauSac = SP.ID_MauSac
INNER JOIN ChatLieu CL ON CL.ID_ChatLieu = SP.ID_ChatLieu 
INNER JOIN Size S ON S.ID_Size = SP.ID_Size
INNER JOIN DanhMuc DM ON DM.ID_DanhMuc = SP.ID_DanhMuc
WHERE HD.MaHD = N'HD54823'




update Voucher
set SoLuong = SoLuong - 1
where ID_Voucher = 2
Select * from Voucher

--Truy vấn ra những Voucher có thể áp dụng với hóa đơn đó. <=> Tổng tiền >= Giá trị tối thiểu.
INNER JOIN
RIGHT JOIN
LEFT
GO
SELECT    V.MaVoucher , V.TenVoucher, V.NgayBatDau , V.NgayKetThuc 
, V.TiLeGiam , V.DonHangToiThieu , V.SoLuong , V.TrangThai , HD.TongTien
FROM Voucher V 
LEFT JOIN HoaDon HD On HD.ID_Voucher = V.ID_Voucher
GROUP BY HD.MaHD,  HD.TongTien  , V.MaVoucher , V.TenVoucher, V.NgayBatDau , V.NgayKetThuc 
, V.TiLeGiam , V.DonHangToiThieu , V.SoLuong , V.TrangThai, HD.TrangThai
HAVING V.TrangThai =N'Đang áp dụng'  
AND V.NgayBatDau <= CURRENT_TIMESTAMP 
AND V.NgayKetThuc > CURRENT_TIMESTAMP
AND V.SoLuong > 0 
AND HD.TongTien >= V.DonHangToiThieu
AND HD.MaHD = N'HD73299'

GO
select * from Voucher
SELECt * FROM HoaDon
where HoaDon.TrangThai = N'Chờ thanh toán'


SELECT * FROM Voucher V
LEFT JOIN HoaDon HD ON HD.ID_Voucher = V.ID_Voucher

SELECt * FROM HoaDon
select * from HoaDonCT
