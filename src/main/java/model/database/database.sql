CREATE DATABASE CS;

use CS;
CREATE TABLE theloai(
                        id int auto_increment PRIMARY KEY ,
                        ten nvarchar(255) not null
);
CREATE TABLE tacgia(
                       id int auto_increment primary key ,
                       ten nvarchar(255) not null ,
                       namSinh int not null ,
                       namMat int,
                       soTacPham int not null  default 0,
                       quocTich nvarchar(255) not null,
                       linkWiki varchar(255),
                       avatar varchar(1000)
);
CREATE  TABLE sach (
                       id int primary key  auto_increment,
                       ten nvarchar(255) not null ,
                       namXuatBan int ,
                       taiBanLanThu int,
                       maISBN bigint unique ,
                       moTa text,
                       NXB nvarchar(255),
                       GPXB nvarchar(25),
                       avatar nvarchar(255),
                       view int ,
                       sachDeCu boolean,
                       sachHot boolean,
                       giaSach double not null ,
                       soLuongDaBan int default 0,
                       sachTonKho int default 0
);
CREATE TABLE sach_theloai(
                             idSach int ,
                             idTheLoai int,
                             FOREIGN KEY (idSach)references sach(id),
                             FOREIGN KEY (idTheLoai)references theloai(id)
);
CREATE TABLE sach_tacgia(
                            idSach int ,
                            idTacGia int,
                            FOREIGN KEY (idSach)references sach(id),
                            FOREIGN KEY (idTacGia)references tacgia(id)
);
CREATE TABLE users(
                      id int auto_increment PRIMARY KEY ,
                      name nvarchar(255),
                      acc nvarchar(255) not null ,
                      pass nvarchar(255) not null ,
                      role boolean not null
);
CREATE TABLE giohang(
                        id int auto_increment primary key ,
                        cartCode nvarchar(10),
                        orderDate datetime ,
                        id_khach int,
                        FOREIGN KEY (id_khach) references users(id)
);
CREATE TABLE chiTietGioHang(
                               id_giohang int,
                               id_sach int,
                               soLuongSach int,
                               FOREIGN KEY (id_giohang)references giohang(id),
                               FOREIGN KEY (id_sach)references sach(id)
);
<<<<<<< HEAD
# drop database CS;

=======
>>>>>>> master
