create database A_TEST_TOPGUN;

use A_TEST_TOPGUN;

CREATE TABLE Person(
CCCD VARCHAR(11) PRIMARY KEY,
ho_ten NVARCHAR(255),
ngay_sinh VARCHAR(20),
gioi_tinh VARCHAR(255),
so_dien_thoai VARCHAR(11),
email VARCHAR(255),
so_the_BHYT VARCHAR(20),
nghe_nghiep NVARCHAR(255),
dia_chi NVARCHAR(255),
ngay_dang_ky NVARCHAR(20),
trang_thai_tiem INT
);

CREATE TABLE TiemChung(
ma_tc INT IDENTITY PRIMARY KEY,
CCCD VARCHAR(11),
ngay_tiem VARCHAR(20),
lan_tiem INT,
ten_vac_xin NVARCHAR(255),
FOREIGN KEY (CCCD) REFERENCES Person(CCCD)
);


  select p.CCCD, p.ho_ten, p.ngay_sinh, p.gioi_tinh, p.so_dien_thoai, p.email, p.so_the_BHYT, p.nghe_nghiep, p.dia_chi, p.ngay_dang_ky, p.trang_thai_tiem, count(tc.CCCD) as so_lan_tiem, Max(tc.ngay_tiem) as ngay_tiem_gan_nhat from Person p left join TiemChung tc
  on p.CCCD = tc.CCCD group by p.CCCD, p.ho_ten, p.ngay_sinh, p.gioi_tinh, p.so_dien_thoai, p.email, p.so_the_BHYT, p.nghe_nghiep, p.dia_chi, p.ngay_dang_ky, p.trang_thai_tiem;