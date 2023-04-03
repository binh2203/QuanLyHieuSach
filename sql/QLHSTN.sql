USE master
GO
DROP DATABASE QuanLyHieuSach
GO
CREATE DATABASE QuanLyHieuSach
GO
USE QuanLyHieuSach
CREATE TABLE SanPham(
	maSP CHAR(10) PRIMARY KEY NOT NULL,
	maNCC char(10) NOT NULL,
	loaiSP nVARCHAR(20) NOT NULL,
	soLuongTon int NOT NULL,
	donVi nVARCHAR(20) NOT NULL,
	giaNhap float NOT NULL, 
	giaBan float NOT NULL,

	tenSach nVARCHAR(20),
	maTG char(10),
	theLoai nVARCHAR(20),
	maNXB char(10),
	
	tenVanPhongPham nVARCHAR(20),
	mauSac nVARCHAR(20),
	maNSX char(10)	
)
GO
CREATE TABLE NhaCungCap(
	maNCC char(10) PRIMARY KEY NOT NULL,
	tenNCC  nvarchar(50) NOT NULL,
	email varchar(40) NOT NULL,
	phone varchar(10) NOT NULL
)
GO
CREATE TABLE TacGia(
	maTG char(10) PRIMARY KEY NOT NULL,
	tenTG nvarchar(50) NOT NULL
)
GO 
CREATE TABLE NhaSanXuat(
	maNSX char(10) PRIMARY KEY NOT NULL,
	tenNSX nvarchar(50) NOT NULL
)
GO 
CREATE TABLE NhaXuatBan(
	maNXB char(10) PRIMARY KEY NOT NULL,
	tenNXB nvarchar(50) NOT NULL
)
GO 
CREATE TABLE CT_HoaDon(
	maHD char(10) NOT NULL,
	maSP char(10) NOT NULL,
	soLuong int NOT NULL,
	donGia float NOT NULL
)
GO
CREATE TABLE HoaDon(
	maHD char(10) NOT NULL,
	maNV char(10) NOT NULL,
	maKH char(10) NOT NULL,
	ngayLapHoaDon Date check (ngayLapHoaDon <= GETDATE()) NOT NULL,
	tienKhachDua float NOT NULL
)
GO 
CREATE TABLE KhachHang(
	maKH char(10) PRIMARY KEY NOT NULL,
	tenKH nvarchar(50) NOT NULL,
	gioiTinh bit NOT NULL,
	ngaySinh Date NOT NULL,
	phone varchar(10) NOT NULL,
	diaChi nvarchar(50) NOT NULL,
	email varchar(50) NOT NULL
)
GO
CREATE TABLE PhieuDatHang(
	maPDH char(10) PRIMARY KEY NOT NULL,
	maNV char(10) NOT NULL,
	maKH char(10) NOT NULL,
	ngayLapPDH Date NOT NULL,
	ngayLayHang Date NOT NULL 
)
GO
CREATE TABLE CT_PhieuDatHang(
	maPDH char(10) NOT NULL,
	maSP char(10) NOT NULL,
	soLuong int NOT NULL,
	donGia float NOT NULL
)
GO
CREATE TABLE NhanVien(
	maNV char(10) PRIMARY KEY NOT NULL,
	tenNV nvarchar(50) NOT NULL,
	gioiTinh bit NOT NULL,
	ngaySinh Date NOT NULL,
	phone char(10) NOT NULL,
	diaChi nvarchar(50) NOT NULL,
	email varchar(50) NOT NULL
)
GO
CREATE TABLE TaiKhoan(
	tenDangNhap varchar(20) check (len(tenDangNhap) >= 5) NOT NULL,
	matKhau varchar(20) check (len(matKhau) >= 8) NOT NULL,
	maNV char(10) NOT NULL,
	quyen bit NOT NULL
)
-- ADD PRIMARY KEY
GO
ALTER TABLE TaiKhoan
ADD CONSTRAINT PK_TaiKhoan PRIMARY KEY(tenDangNhap)
GO
ALTER TABLE CT_PhieuDatHang
ADD CONSTRAINT PK_CT_PDH PRIMARY KEY(maPDH, maSP)
GO
ALTER TABLE HoaDon
ADD CONSTRAINT PK_HD PRIMARY KEY(maHD)
GO
ALTER TABLE CT_HoaDon
ADD CONSTRAINT PK_CT_HD PRIMARY KEY (maHD, maSP)
GO
-- ADD FOREIGN KEY
ALTER TABLE CT_PhieuDatHang
ADD CONSTRAINT FR_CT_PDH_PDH
FOREIGN KEY (maPDH)
REFERENCES PhieuDatHang(maPDH)
GO
ALTER TABLE CT_PhieuDatHang
ADD CONSTRAINT FR_CT_PDH_SP
FOREIGN KEY (maSP)
REFERENCES SanPham(maSP)
GO
ALTER TABLE PhieuDatHang
ADD CONSTRAINT FR_PDH_NV
FOREIGN KEY (maNV)
REFERENCES NhanVien(maNV)
GO
ALTER TABLE PhieuDatHang
ADD CONSTRAINT FR_PDH_KH
FOREIGN KEY (maKH)
REFERENCES KhachHang(maKH)
GO
ALTER TABLE HoaDon
ADD CONSTRAINT FR_HD_KH
FOREIGN KEY (maKH)
REFERENCES KhachHang(maKH)
GO
ALTER TABLE HoaDon
ADD CONSTRAINT FR_HD_NV
FOREIGN KEY (maNV)
REFERENCES NhanVien(maNV)
GO
ALTER TABLE TaiKhoan
ADD CONSTRAINT FR_TK_NV
FOREIGN KEY (maNV)
REFERENCES NhanVien(maNV)
GO
ALTER TABLE CT_HoaDon
ADD CONSTRAINT FR_CT_HD_HD
FOREIGN KEY (maHD)
REFERENCES HoaDon(maHD)
GO
ALTER TABLE CT_HoaDon
ADD CONSTRAINT FR_CT_HD_SP
FOREIGN KEY (maSP)
REFERENCES SanPham(maSP)
GO
ALTER TABLE SanPham
ADD CONSTRAINT FR_SP_NCC
FOREIGN KEY (maNCC)
REFERENCES NhaCungCap(maNCC)
GO
ALTER TABLE SanPham
ADD CONSTRAINT FR_SP_TG
FOREIGN KEY (maTG)
REFERENCES TacGia(maTG)
GO
ALTER TABLE SanPham
ADD CONSTRAINT FR_SP_NSX
FOREIGN KEY (maNSX)
REFERENCES NhaSanXuat(maNSX)
GO
ALTER TABLE SanPham
ADD CONSTRAINT FR_SP_NXB
FOREIGN KEY (maNXB)
REFERENCES NhaXuatBan(maNXB)

-- Nhập dữ liệu vào các bảng
GO
INSERT INTO NhanVien
VALUES ('NV001', N'Diêm Công Bình', 0, '2002-03-22', '0853387787', N'Gò Vấp - TPHCM', 'diemcongbinh@gmail.com'),
('NV002', N'Phạm Bình Phương Duy', 0, '2002-03-22', '0853387787', N'Hooc Môn - TPHCM', 'phambinhphuongduy@gmail.com'),
('NV003', N'Huỳnh Võ Công Lĩnh', 0, '2002-03-22', '0853387787', N'Q12 - TPHCM', 'huynhvoconglinh@gmail.com')
GO
INSERT INTO TaiKhoan
VALUES ('diemcongbinh', '12345678', 'NV001', 0),
('phambinhphuongduy', '12345678','NV002',1),
('huynhvoconglinh', '12345678', 'NV003', 1)
GO 
INSERT INTO KhachHang
VALUES 
('KH001',N'Bùi Minh Anh',1,'2002-04-05','0940856853',N'Hóc Môn, TP HCM','buiminhanh@gmail.com'),
('KH002',N'Hồ Nguyễn Trâm Anh',1,'2003-04-18','0940856853',N'Củ Chi, TP HCM','honguyentramanh@gmail.com'),
('KH003',N'Nguyễn Hoàng Phương Anh',1,'2003-11-05','0940856853',N'Gò Vấp, TP HCM','nguyenhoangphuonganh@gmail.com'),
('KH004',N'Nguyễn Thị Phương Anh',1,'2003-03-26','0940856853',N'Bình Thạnh, TP HCM','nguyenthiphuonganh@gmail.com'),
('KH005',N'Lý Nguyễn Trọng Bảo',0,'2003-08-20','0940856853',N'Bình Thạnh, TP HCM','lynguyentrongbao@gmail.com'),
('KH006',N'Mai Thị Mộng Bình',1,'2003-02-12','0940856853',N'Quận 4, TP HCM','maithimongbinh@gmail.com'),
('KH007',N'Đỗ Đức Cảnh',0,'2002-11-20','0940856853',N'Củ Chi, TP HCM','doduccanh@gmail.com'),
('KH008',N'Trần Nguyễn Ngọc Châu',1,'2003-09-12','0940856853',N'Quận 4, TP HCM','trannguyenngocchau@gmail.com'),
('KH009',N'Nguyễn Thị Phương Đài',1,'2003-09-26','0940856853',N'Quận 1, TP HCM','nguyenthiphuongdai@gmail.com'),
('KH010',N'Vương Quốc Đạt',0,'2002-03-21','0940856853',N'Quận 6, TP HCM','vuongquocdat@gmail.com'),
('KH011',N'Mai Thị Diệu',1,'2003-11-20','0940856853',N'Hóc Môn, TP HCM','maithidieu@gmail.com'),
('KH012',N'Phạm Trần Công Định',0,'2003-02-12','0940856853',N'Quận 10, TP HCM','phamtrancongdinh@gmail.com'),
('KH013',N'Phạm Du',0,'2003-05-12','0940856853',N'Quận 10, TP HCM','phamdu@gmail.com'),
('KH014',N'Lê Trung Đức',0,'2003-05-16','0940856853',N'Củ Chi, TP HCM','letrungduc@gmail.com'),
('KH015',N'Ngô Thế Duy',0,'2003-11-25','0940856853',N'Quận 1, TP HCM','ngotheduy@gmail.com'),
('KH016',N'Nguyễn Phạm Khánh Duy',0,'2003-06-29','0940856853',N'Quận 9, TP HCM','nguyenphamkhanhduy@gmail.com'),
('KH017',N'Bùi Thị Mỹ Duyên',1,'2003-09-24','0940856853',N'Quận 11, TP HCM','buithimyduyen@gmail.com'),
('KH018',N'Bùi Đức Hải',0,'2003-05-24','0940856853',N'Bình Tân, TP HCM','buiduchai@gmail.com'),
('KH019',N'Huỳnh Anh Hào',0,'2003-01-14','0940856853',N'Cần Giờ, TP HCM','huynhanhhao@gmail.com'),
('KH020',N'Nguyễn Văn Hiền',0,'2003-02-16','0940856853',N'Quận 6, TP HCM','nguyenvanhien@gmail.com'),
('KH021',N'Lại Chí Hiếu',0,'2003-10-13','0940856853',N'Phú Nhuận, TP HCM','laichihieu@gmail.com'),
('KH022',N'Nguyễn Văn Hoan',0,'2003-10-02','0940856853',N'Gò Vấp, TP HCM','nguyenvanhoan@gmail.com'),
('KH023',N'Lê Vũ Hoàng',0,'2003-08-14','0940856853',N'Quận 6, TP HCM','levuhoang@gmail.com'),
('KH024',N'Ngô Thư Hoàng',0,'2003-09-16','0940856853',N'Quận 4, TP HCM','ngothuhoang@gmail.com'),
('KH025',N'Lâm Tính Huy',0,'2003-08-10','0940856853',N'Gò Vấp, TP HCM','lamtinhhuy@gmail.com'),
('KH026',N'Nguyễn Kim Quang Huy',0,'2003-03-27','0940856853',N'Quận 11, TP HCM','nguyenkimquanghuy@gmail.com'),
('KH027',N'Phạm Lê Huy',0,'2003-09-01','0940856853',N'Quận 6, TP HCM','phamlehuy@gmail.com'),
('KH028',N'Phạm Quang Huy',0,'2003-04-30','0940856853',N'Quận 8, TP HCM','phamquanghuy@gmail.com'),
('KH029',N'Võ Hoàng Huy',0,'2003-03-12','0940856853',N'Quận 5, TP HCM','vohoanghuy@gmail.com'),
('KH030',N'Nguyễn Thị Kim Huyền',1,'2003-02-10','0940856853',N'Quận 2, TP HCM','nguyenthikimhuyen@gmail.com'),
('KH031',N'Lê Thị Minh Khánh',1,'2002-07-23','0940856853',N'Quận 5, TP HCM','lethiminhkhanh@gmail.com'),
('KH032',N'Lê Anh Khôi',0,'2003-01-04','0940856853',N'Bình Tân, TP HCM','leanhkhoi@gmail.com'),
('KH033',N'Chung Gia Kiệt',0,'2003-09-23','0940856853',N'Bình Chánh, TP HCM','chunggiakiet@gmail.com'),
('KH034',N'Đoàn Ngọc Tuấn Kiệt',0,'2003-11-10','0940856853',N'Tân Bình, TP HCM','doanngoctuankiet@gmail.com'),
('KH035',N'Trịnh Ngọc Tuấn Kiệt',0,'2003-11-20','0940856853',N'Bình Tân, TP HCM','trinhngoctuankiet@gmail.com'),
('KH036',N'Huỳnh Nhật Lê',1,'2003-06-14','0940856853',N'Quận 9, TP HCM','huynhnhatle@gmail.com'),
('KH037',N'Mai Văn Linh',0,'2003-01-26','0940856853',N'Quận 1, TP HCM','maivanlinh@gmail.com'),
('KH038',N'Phạm Nguyễn Thu Loan',1,'2002-10-17','0940856853',N'Quận 11, TP HCM','phamnguyenthuloan@gmail.com'),
('KH039',N'Võ Hồng Loan',1,'2000-06-16','0940856853',N'Quận 8, TP HCM','vohongloan@gmail.com'),
('KH040',N'Nguyễn Đình Long',0,'2002-12-30','0940856853',N'Quận 4, TP HCM','nguyendinhlong@gmail.com'),
('KH041',N'Trần Hoàng Long',0,'2003-06-23','0940856853',N'Thủ Đức, TP HCM','tranhoanglong@gmail.com'),
('KH042',N'Mai Văn Luân',0,'2003-04-03','0940856853',N'Quận 1, TP HCM','maivanluan@gmail.com'),
('KH043',N'Đinh Hoài Nam',0,'2003-06-29','0940856853',N'Cần Giờ, TP HCM','dinhhoainam@gmail.com'),
('KH044',N'Bùi Thị Nha Nha',0,'2003-05-02','0940856853',N'Quận 5, TP HCM','buithinhanha@gmail.com'),
('KH045',N'Nghiêm Tường Nhi',1,'2003-09-03','0940856853',N'Quận 6, TP HCM','nghiemtuongnhi@gmail.com'),
('KH046',N'Đào Mộng Huỳnh Như',1,'2002-12-25','0940856853',N'Quận 2, TP HCM','daomonghuynhnhu@gmail.com'),
('KH047',N'Nguyễn Thị Huỳnh Như',1,'2003-12-28','0940856853',N'Quận 8, TP HCM','nguyenthihuynhnhu@gmail.com'),
('KH048',N'Hồ Ngọc Anh Phi',0,'2003-06-23','0940856853',N'Nhà Bè, TP HCM','hongocanhphi@gmail.com'),
('KH049',N'Nguyễn Hoàng Nhật Phong',0,'2003-04-21','0940856853',N'Bình Tân, TP HCM','nguyenhoangnhatphong@gmail.com'),
('KH050',N'Đặng Hoàng Phúc',0,'2003-04-22','0940856853',N'Củ Chi, TP HCM','danghoangphuc@gmail.com'),
('KH051',N'Nguyễn Văn Phúc',0,'2003-10-13','0940856853',N'Bình Chánh, TP HCM','nguyenvanphuc@gmail.com'),
('KH052',N'Lê Hồng Phương',1,'2003-06-24','0940856853',N'Củ Chi, TP HCM','lehongphuong@gmail.com'),
('KH053',N'Mai Thị Như Quỳnh',1,'2003-04-25','0940856853',N'Quận 10, TP HCM','maithinhuquynh@gmail.com'),
('KH054',N'Phan Thị Ly Sa',1,'2003-04-07','0940856853',N'Quận 7, TP HCM','phanthilysa@gmail.com'),
('KH055',N'Trần Thị Bích Sa',1,'2003-01-24','0940856853',N'Quận 12, TP HCM','tranthibichsa@gmail.com'),
('KH056',N'Nguyễn Ngọc Sơn',0,'2003-10-29','0940856853',N'Quận 3, TP HCM','nguyenngocson@gmail.com'),
('KH057',N'Trần Tấn Tài',0,'2003-02-27','0940856853',N'Hóc Môn, TP HCM','trantantai@gmail.com'),
('KH058',N'Nguyễn Phương Tâm',1,'2001-03-11','0940856853',N'Quận 11, TP HCM','nguyenphuongtam@gmail.com'),
('KH059',N'Văn Nhật Tân',0,'2001-06-15','0940856853',N'Tân Bình, TP HCM','vannhattan@gmail.com'),
('KH060',N'Đặng Quang Thái',0,'2003-03-06','0940856853',N'Bình Tân, TP HCM','dangquangthai@gmail.com'),
('KH061',N'Huỳnh Hiếu Thảo',0,'2003-06-15','0940856853',N'Quận 5, TP HCM','huynhhieuthao@gmail.com'),
('KH062',N'Lê Thị Thu Thảo',1,'2003-06-09','0940856853',N'Quận 8, TP HCM','lethithuthao@gmail.com'),
('KH063',N'Nguyễn Đức Thiện',0,'2003-10-20','0940856853',N'Bình Thạnh, TP HCM','nguyenducthien@gmail.com'),
('KH064',N'Phạm Minh Thông',0,'2003-10-31','0940856853',N'Quận 12, TP HCM','phamminhthong@gmail.com'),
('KH065',N'Vũ Thị Hồng Thu',1,'2003-09-22','0940856853',N'Phú Nhuận, TP HCM','vuthihongthu@gmail.com'),
('KH066',N'Nguyễn Quốc Tính',0,'2003-01-21','0940856853',N'Quận 7, TP HCM','nguyenquoctinh@gmail.com'),
('KH067',N'Nguyễn Minh Trí',0,'2003-12-31','0940856853',N'Quận 2, TP HCM','nguyenminhtri@gmail.com'),
('KH068',N'Lê Thị Phương Trinh',1,'2003-05-15','0940856853',N'Gò Vấp, TP HCM','lethiphuongtrinh@gmail.com'),
('KH069',N'Lê Minh Tuấn',0,'2003-05-10','0940856853',N'Tân Bình, TP HCM','leminhtuan@gmail.com'),
('KH070',N'Lê Văn Túc',0,'2002-07-11','0940856853',N'Quận 8, TP HCM','levantuc@gmail.com'),
('KH071',N'Hồ Thị Tuyền',1,'2003-10-01','0940856853',N'Quận 4, TP HCM','hothituyen@gmail.com'),
('KH072',N'Lê Thị Ngân Uyển',1,'2003-08-09','0940856853',N'Phú Nhuận, TP HCM','lethinganuyen@gmail.com'),
('KH073',N'Nguyễn Thị Anh Vân',1,'2003-12-25','0940856853',N'Nhà Bè, TP HCM','nguyenthianhvan@gmail.com'),
('KH074',N'Hồ Trần Thị Thảo Vy',1,'2003-07-10','0940856853',N'Bình Tân, TP HCM','hotranthithaovy@gmail.com'),
('KH075',N'Nguyễn Vân Tường Vy',1,'2003-10-22','0940856853',N'Gò Vấp, TP HCM','nguyenvantuongvy@gmail.com'),
('KH076',N'Trần Hồ Hạnh Vy',1,'2003-10-14','0940856853',N'Quận 6, TP HCM','tranhohanhvy@gmail.com'),
('KH077',N'Nguyễn Thị Thanh Xuân',1,'2003-12-07','0940856853',N'Củ Chi, TP HCM','nguyenthithanhxuan@gmail.com'),
('KH078',N'Nguyễn Thị Hồng Yến',1,'2003-08-13','0940856853',N'Quận 8, TP HCM','nguyenthihongyen@gmail.com'),
('KH079',N'Nguyễn Thị Ngọc Yến',1,'2003-02-07','0940856853',N'Nhà Bè, TP HCM','nguyenthingocyen@gmail.com')
GO 
INSERT INTO NhaSanXuat
VALUES ('NSX001', 'Pentel'),
('NSX002', 'Flexoffice'),
('NSX003', N'Hồng Hà'),
('NSX004', N'Bến Nghé'),
('NSX005',N'Cửu Long'),
('NSX006', N'Bến Thành'),
('NSX007', N'Thanh Thảo'),
('NSX008', N'Thiên Long'),
('NSX009', N'Hòa Phát'),
('NSX010', N'Ngọc Duy'),
('NSX011', N'Vạn Phát')
GO 
INSERT INTO NhaCungCap
VALUES ('NCC001', N'Việt Hoàng', 'viethoang@gmail.com', '0845678123'),
('NCC002', N'An Phát', 'anphat@gmail.com', '0987654234'),
('NCC003', N'Thiên Long', 'thienlong@gmail.com', '0284562354'),
('NCC004', N'Thiên Phát', 'thienphat@gmail.com', '0381592358'),
('NCC005', N'Vạn Phát', 'vanphat@gmail.com', '0973542678'),
('NCC006', N'Becamex IDC', 'becamexIDC@gmail.com', '0287381234'),
('NCC007', N'Hòa Phát', 'hoaphat@gmail.com', '0986596969'),
('NCC008', N'Ngọc Trời', 'ngoctroi@gmail.com', '0961234567'),
('NCC009', N'Dakota', 'dakota@gmail.com', '0287896789'),
('NCC010', N'Phát Tài', 'phattai@gmail.com', '0975662345')
GO
INSERT INTO NhaXuatBan
VALUES 
('NXB001', N'NXB Trẻ'),
('NXB002', N'NXB Kim Đồng'),
('NXB003', N'NXB Tổng hợp Tp HCM'),
('NXB004', N'NXB Hội Nhà văn'),
('NXB005', N'NXB Chính trị quốc gia Sự thật '),
('NXB006', N'NXB Phụ nữ Việt Nam'),
('NXB007', N'NXB Lao Động'),
('NXB008', N'NXB Nhã Nam '),
('NXB009', N'NXB Đinh Tị Books'),
('NXB010', N'NXB Đông A'),
('NXB011', N'NXB Elsevier'),
('NXB012', N'NXB Pearson'),
('NXB013', N'NXB Springer Nature')
GO 
INSERT INTO TacGia
VALUES 
('TG001', N'Nguyễn Nhật Ánh'),
('TG002', N'Nguyễn Quang Sáng'),
('TG003', N'Gào'),
('TG004', N'Anh Khang'),
('TG005', N'Hồ Anh Thái'),
('TG006', N'Nguyễn Vĩnh Nguyên'),
('TG007', N'Nguyễn Trương Quý'),
('TG008', N'Đỗ Bích Thúy'),
('TG009', N'Nguyễn Mai Chi'),
('TG010', N'Hemingway'),
('TG011', N'J.R.R.Tolkien'),
('TG012', N'Robert M. Pirsig'),
('TG013', N'Richard Adams'),
('TG014', N'Randy Pausch'),
('TG015', N'Bill Bryson'),
('TG016', N'Viktor Frankl'),
('TG017', N'Joe Haldeman'),
('TG018', N'Carl Sagan'),
('TG019', N'Herman Melville'),
('TG020', N'Art Spiegelman')
GO
INSERT INTO SanPham
VALUES													 --Tên sách,mã TG,thể loại, mã nxb
('SP001', N'NCC001', N'Sách', '20', N'Quyển', 100000, 100000+(100000*0.2), N'Mắt biếc', 'TG001', N'Truyện dài','NXB001', null, null, null),
('SP002', N'NCC001', N'Sách', '50', N'Quyển', 120000, 120000+(120000*0.2), N'Cho tôi xin một vé', 'TG001', N'Truyện dài','NXB001', null, null, null),
('SP003', N'NCC001', N'Sách', '25', N'Quyển', 240000, 240000+(240000*0.2), N'Cho em gần anh', 'TG003', N'Truyện dài','NXB001', null, null, null),
('SP004', N'NCC001', N'Sách', '75', N'Quyển', 758000, 758000+(758000*0.2), N'Tự sát', 'TG003', N'Văn học','NXB001', null, null, null),
('SP005', N'NCC001', N'Sách', '100', N'Quyển', 104200, 104200+(104200*0.2), N'Nhật ký son môi', 'TG003', N'Văn học','NXB001', null, null, null),
('SP006', N'NCC001', N'Sách', '35', N'Quyển', 230000, 230000+(230000*0.2), N'Tiếng thở dài', 'TG005', N'Truyện ngắn','NXB002', null, null, null),
('SP007', N'NCC002', N'Sách', '80', N'Quyển', 89000, 89000+(89000*0.2), N'Cuộc đổi chác', 'TG005', N'Truyện ngắn','NXB002', null, null, null),
('SP008', N'NCC002', N'Sách', '110', N'Quyển', 99000, 99000+(99000*0.2), N'Đức Phật và tôi', 'TG005', N'Truyện ngắn','NXB002', null, null, null),
('SP009', N'NCC002', N'Sách', '200', N'Quyển', 181000, 181000+(181000*0.2), N'Ông già và biển cả', 'TG010', N'Văn học','NXB002', null, null, null),
('SP010', N'NCC002', N'Sách', '180', N'Quyển', 230000, 230000+(230000*0.2), N'Chuông nguyện hồn ai', 'TG010', N'Văn học','NXB002', null, null, null),
('SP011', N'NCC002', N'Sách', '15', N'Quyển', 155000, 155000+(155000*0.2), N'Vườn địa đàng', 'TG010', N'Văn học','NXB002', null, null, null)
GO 
INSERT INTO SanPham
VALUES
('SP012', N'NCC003', N'Viết', '50', N'Cây', 3500, 5000, null, null, null, null, N'Viết Xanh', N'Xanh Dương', 'NSX008'),
('SP013', N'NCC003', N'Viết', '30', N'Cây', 3500, 5000, null, null, null, null, N'Viết Đỏ', N'Đỏ', 'NSX008'),
('SP014', N'NCC003', N'Viết', '40', N'Cây', 3500, 5000, null, null, null, null, N'Viết Đen', N'Đen', 'NSX008'),
('SP015', N'NCC002', N'Thước', '40', N'Cây', 8000, 10000, null, null, null, null, N'Thước thẳng', N'Trong suốt', 'NSX002'),
('SP016', N'NCC002', N'Thước', '30', N'Cây', 7500, 9000, null, null, null, null, N'Thước đo độ', N'Trong suốt', 'NSX002'),
('SP017', N'NCC003', N'Đồ Bấm', '30', N'Cây', 17500, 22000, null, null, null, null, N'Đồ bấm', N'Đen', 'NSX008'),
('SP018', N'NCC003', N'Kim Bấm', '50', N'Hộp', 6500, 8000, null, null, null, null, N'Kim Bấm', N'Xám', 'NSX008'),
('SP019', N'NCC010', N'Màu', '20', N'Hộp', 35000, 48000, null, null, null, null, N'Hộp Bút Màu', N'Nhiều Màu', 'NSX004'),
('SP020', N'NCC009', N'Tệp Hồ Sơ', '40', N'Cái', 18000, 26000, null, null, null, null, N'Tệp Hồ Sơ', N'Trong suốt', 'NSX007'),
('SP021', N'NCC005', N'Vở', '50', N'Quyển', 5500, 8000, null, null, null, null, N'Vở Trắng', N'Nhiều màu', 'NSX003'),
('SP022', N'NCC004', N'Compa', '30', N'Cây', 17500, 25000, null, null, null, null, N'Compa', N'Đen', 'NSX009'),
('SP023', N'NCC006', N'Máy tính', '50', N'Cái', 250000, 380000, null, null, null, null, N'Máy Tính Bỏ Túi', N'Xám', 'NSX006'),
('SP024', N'NCC008', N'Kéo', '30', N'Cây', 21500, 26000, null, null, null, null, N'Kéo Cắt Giấy', N'Đen', 'NSX001'),
('SP025', N'NCC006', N'Viết', '30', N'Cây', 15000, 19000, null, null, null, null, N'Viết Highlight', N'Vàng', 'NSX001')
GO 
INSERT INTO HoaDon
VALUES 
('HD001','NV002','KH048','2023-01-02',600000),
('HD002','NV003','KH064','2023-01-15',500000),
('HD003','NV001','KH072','2023-01-18',300000),
('HD004','NV002','KH074','2023-01-24',500000),
('HD005','NV003','KH072','2023-01-26',500000),
('HD006','NV001','KH021','2023-01-27',400000),
('HD007','NV003','KH042','2023-02-03',100000),
('HD008','NV001','KH013','2023-02-06',100000),
('HD009','NV003','KH023','2023-02-08',40000),
('HD010','NV002','KH041','2023-02-09',280000),
('HD011','NV001','KH047','2023-02-09',110000),
('HD012','NV003','KH054','2023-02-10',500000),
('HD013','NV002','KH065','2023-02-15',1000000),
('HD014','NV001','KH059','2023-02-25',120000),
('HD015','NV001','KH049','2023-02-28',180000),
('HD016','NV001','KH043','2023-03-03',300000),
('HD017','NV002','KH055','2023-03-25',54000),
('HD018','NV003','KH001','2023-03-26',400000),
('HD019','NV002','KH035','2023-04-01',16000),
('HD020','NV002','KH001','2023-04-02',160000)
GO
INSERT INTO CT_HoaDon
VALUES 
('HD001','SP019',3,144000),
('HD001','SP023',1,380000),
('HD002','SP001',1,120000),
('HD002','SP008',1,118800),
('HD003','SP002',1,144000),
('HD003','SP018',10,80000),
('HD004','SP013',3,15000),
('HD004','SP009',1,217200),
('HD005','SP019',3,144000),
('HD005','SP005',1,125040),
('HD006','SP002',1,144000),
('HD006','SP018',10,80000),
('HD007','SP024',3,78000),
('HD008','SP022',4,100000),
('HD009','SP015',4,40000),
('HD010','SP010',1,276000),
('HD011','SP007',1,106800),
('HD012','SP011',1,186000),
('HD012','SP003',1,288000),
('HD013','SP005',1,125040),
('HD013','SP020',8,208000),
('HD013','SP023',1,380000),
('HD014','SP001',1,120000),
('HD015','SP002',1,144000),
('HD015','SP014',7,35000),
('HD016','SP012',10,50000),
('HD016','SP017',4,88000),
('HD016','SP025',4,76000),
('HD017','SP016',6,54000),
('HD018','SP024',3,78000),
('HD018','SP006',1,276000),
('HD019','SP021',2,16000),
('HD020','SP015',4,40000),
('HD020','SP001',1,120000)
