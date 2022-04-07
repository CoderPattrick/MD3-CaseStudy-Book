use CS;

# 20 record theloai
insert into theloai(ten)
values('Trinh thám'),
       ('Tâm lý'),
       ('Phiêu lưu'),
       ('Lãng mạn'),
       ('Tài liệu'),
       ('Kinh dị'),
       ('Giật gân'),
       ('Lịch sử'),
       ('Viễn tưởng'),
       ('Nấu ăn'),
       ('Nghệ thuật'),
       ('Phát triển bản thân'),
       ('Sức khỏe'),
       ('Du lịch'),
       ('Hướng dẫn'),
       ('Gia đình & mối quan hệ'),
       ('Kinh thánh'),
       ('Tự truyện'),
       ('Sách giáo khoa'),
       ('Sách tham khảo');



insert into tacgia (ten,namSinh,soTacPham,quocTich,linkWiki,avatar)
values ('Haruki Murakami',1949,50,'Nhật Bản','https://en.wikipedia.org/wiki/Murakami_Haruki','https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Murakami_Haruki_%282009%29.jpg/800px-Murakami_Haruki_%282009%29.jpg'),
       ('Thomas Harris',1940,40,'Mỹ','https://en.wikipedia.org/wiki/Thomas_Harris','https://trangtrinhtham.files.wordpress.com/2021/02/thomas-harris.jpg'),
       ('J.K.Rowling',1965,20,'Anh','https://en.wikipedia.org/wiki/J._K._Rowling','https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/J._K._Rowling_2010.jpg/800px-J._K._Rowling_2010.jpg'),
       ('Stephen King', 1967,80,'Mỹ','https://en.wikipedia.org/wiki/Stephen_King','https://upload.wikimedia.org/wikipedia/commons/e/e3/Stephen_King%2C_Comicon.jpg'),
       ('Sir Arthur Conan Doyle',1959,30,'Scotland','https://en.wikipedia.org/wiki/Arthur_Conan_Doyle','https://upload.wikimedia.org/wikipedia/commons/b/bd/Arthur_Conan_Doyle_by_Walter_Benington%2C_1914.png'),
       ('Maurice Leblanc',1984,20,'Pháp','https://vi.wikipedia.org/wiki/Maurice_Leblanc','https://upload.wikimedia.org/wikipedia/commons/9/9a/Maurice-leblanc.jpg'),
       ('Stephenie Meyer',1973,70,'Mỹ','https://en.wikipedia.org/wiki/Stephenie_Meyer','https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Stephenie_Meyer_by_Gage_Skidmore.jpg/800px-Stephenie_Meyer_by_Gage_Skidmore.jpg'),
       ('George Raymond Richard Martin',1948,20,'Mỹ','https://en.wikipedia.org/wiki/George_R._R._Martin','https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Portrait_photoshoot_at_Worldcon_75%2C_Helsinki%2C_before_the_Hugo_Awards_%E2%80%93_George_R._R._Martin.jpg/');
# tacgia chua biet (khong co link wiki)

insert into tacgia(ten,quocTich,namSinh)
value ('unknown','unknown',0);

# 21 record sach
insert into sach(ten, namXuatBan, taiBanLanThu, maISBN, moTa, NXB, GPXB, avatar, view, sachDeCu, sachHot, giaSach, soLuongDaBan, sachTonKho)
values('1Q84 - quyển 1',2009,1,9780307593313,'1 trong những cuốn sách bán chạy nhất của Haruki Murakami','Nhã Nam',1,'https://upload.wikimedia.org/wikipedia/vi/c/ce/1Q84-01-bia.jpg',100,true,true,100000,127,73),
      ('1Q84 - quyển 2',2009,1,9780307593314,'phần 2 của tiểu thuyết 1Q84','Nhã Nam',1,'https://upload.wikimedia.org/wikipedia/vi/c/ce/1Q84-01-bia.jpg',50,false,true,100000,97,53),
      ('1Q84 - quyển 3',2009,1,9780307593315,'phần 3 của tiểu thuyết 1Q84','Nhã Nam',1,'https://upload.wikimedia.org/wikipedia/vi/c/ce/1Q84-01-bia.jpg',35,false,true,100000,84,66),
       ('Sự im lặng của bầy cừu',1988,1,9780312022822,'Câu truyện của tên giết người nổi tiếng Hannibal Lecter','St. Martin''s Press',2,'https://upload.wikimedia.org/wikipedia/vi/6/62/Silence3.png',100,true,true,75000,254,246),
       ('Arsene Lupin, Siêu trộm hào hoa',1907,2,9780884369028,'Câu chuyện của tên trộm nổi tiếng nhất thế giới - Arsene Lupin','Nhà xuất bản văn học',3,'https://upload.wikimedia.org/wikipedia/commons/9/9e/Arsene_Lupin_art_Pierre_La_Fit.png',127,true,true,70000,64,36),
       ('Harry Potter và hòn đá phù thủy',1997,2,9788869183157,'Bắt đầu hành trình của câu bé Harry Potter','Nhà xuất bản trẻ',4,'https://vi.wikipedia.org/wiki/Harry_Potter_v%C3%A0_H%C3%B2n_%C4%91%C3%A1_Ph%C3%B9_th%E1%BB%A7y',67,true,false,100000,54,46),
      ('Harry Potter và phòng chứa bí mật',1998,2,9788869183158,'Harry Potter trong năm thứ 2 học tại Hogwarts','Nhà xuất bản trẻ',4,'https://vi.wikipedia.org/wiki/Harry_Potter_v%C3%A0_Ph%C3%B2ng_ch%E1%BB%A9a_B%C3%AD_m%E1%BA%ADt',67,false,false,100000,54,46),
      ('Harry Potter và tên tù nhân ngục Azkaban',1999,2,9788869183159,'Hành trình của Harry Porter sau khi gặp Serius Black','Nhà xuất bản trẻ',4,'https://vi.wikipedia.org/wiki/Harry_Potter_v%C3%A0_t%C3%AAn_t%C3%B9_nh%C3%A2n_ng%E1%BB%A5c_Azkaban',67,false,false,100000,54,46),
      ('Harry Potter và chiếc cốc lửa',2000,2,9788869183160,'Hành trình của Harry Potter khi tham dự cuộc thi tam pháp thuật','Nhà xuất bản trẻ',4,'https://vi.wikipedia.org/wiki/Harry_Potter_v%C3%A0_Chi%E1%BA%BFc_c%E1%BB%91c_l%E1%BB%ADa',67,false,false,100000,54,46),
      ('Harry Potter và hội phượng hoàng',2003,2,9788869183161,'Harry Potter và cuộc gặp gỡ với hội phường hoàng','Nhà xuất bản trẻ',4,'https://vi.wikipedia.org/wiki/Harry_Potter_v%C3%A0_H%E1%BB%99i_Ph%C6%B0%E1%BB%A3ng_Ho%C3%A0ng',67,false,false,100000,54,46),
      ('Harry Potter và hoàng tử lai',2005,2,9788869183162,'Harry Potter và kỉ nguyên mới mở ra sau khi chúa tể hắc ám tái xuất giang hồ','Nhà xuất bản trẻ',4,'https://vi.wikipedia.org/wiki/Harry_Potter_v%C3%A0_Ho%C3%A0ng_t%E1%BB%AD_lai',67,false,false,100000,54,46),
      ('Harry Potter và bảo bối tử thần',2007,2,9788869183163,'Harry Potter và cuộc chiến với chúa tể hắc ám - Voldermort','Nhà xuất bản trẻ',4,'https://vi.wikipedia.org/wiki/Harry_Potter_v%C3%A0_B%E1%BA%A3o_b%E1%BB%91i_T%E1%BB%AD_th%E1%BA%A7n',67,false,false,100000,54,46),
       ('Rừng Na Uy',1987,3,9783832156091,'Câu chuyện tình cảm, tâm lý bán chạy nhất','Nhã Nam',5,'https://upload.wikimedia.org/wikipedia/vi/6/62/R%E1%BB%ABng_Na_Uy.jpg',52,true,true,85000,542,68),
       ('Xứ sở diệu kỳ tàn bạo và chốn tận cùng thế giới',1985,3,780679743460,'1 Tác phẩm bán chạy của Haruki Murakami','Nhã Nam',6,'https://salt.tikicdn.com/ts/product/a6/53/0c/09f018e2c7f733adfe22eac259a9f2de.jpg',32,false,false,50000,100,100),
       ('Lắng nghe gió hát',1979,3,9784061879317,'1 câu chuyện xoay quanh tình yêu và mất mát','Kodasha',4,'https://upload.wikimedia.org/wikipedia/vi/8/83/Lang-nghe-gio-hat.jpg',12,false,false,75000,12,28),
       ('Ánh trăng',2010,4,987192837465,'Câu chuyện tình cảm tâm lý nhẹ nhàng tuổi học trò','Sakurabooks',5,'https://truyenbanquyen.com/wiki/lib/exe/fetch.php?media=ln:ln_anhtrang.jpg',87,true,true,98000,98,2),
       ('Game of thrones - Trò chơi vương quyền',1996,5,987625482908,'Đã được chuyển thể thành phim truyền hình rất ăn khách','Bantam Spectra',5,'https://upload.wikimedia.org/wikipedia/en/9/93/AGameOfThrones.jpg',329,true,true,55000,55,45),
       ('Twilight',2005,5,98712945765,'Phần đầu của seri truyện Chạng vạng - Twilight','Little, Brown and Company',6,'https://upload.wikimedia.org/wikipedia/en/1/1d/Twilightbook.jpg',87,true,true,90000,98,102),
       ('New Moon',2006,5,0316160199,'Phần 2 của seri truyện Chạng vạng','Little, Brown and Company',6,'https://upload.wikimedia.org/wikipedia/en/8/89/Newmooncover.jpg',56,true,true,78000,70,30),
      ('Eclipse',2007,5,0316160200,'Phần 3 của seri truyện Chạng vạng','Little, Brown and Company',6,'https://upload.wikimedia.org/wikipedia/en/2/20/Eclipsecover.jpg',52,true,true,78000,56,34),
      ('Breaking Dawn',2008,5,0316160222,'Phần cuối của seri truyện Chạng vạng','Little, Brown and Company',6,'https://upload.wikimedia.org/wikipedia/en/3/31/Breaking_Dawn_cover.jpg',50,true,true,78000,34,56);

# 21 record theloai sach
    insert into sach_theloai
values (1,2),
       (2,2),
       (3,2),
       (4,1),
       (5,1),
       (6,9),
       (7,9),
       (8,9),
       (9,9),
       (10,9),
       (11,9),
       (12,9),
       (13,2),
       (14,2),
       (15,2),
       (16,4),
       (17,9),
       (18,2),
       (19,2),
       (20,2),
       (21,2);

# 21 record tacgia sach
    insert into sach_tacgia
values (1,1),
       (2,1),
       (3,1),
       (4,2),
       (5,6),
       (6,3),
       (7,3),
       (8,3),
       (9,3),
       (10,3),
       (11,3),
       (12,3),
       (13,1),
       (14,1),
       (15,1),
       (16,9),
       (17,8),
       (18,1),
       (19,1),
       (20,1),
       (21,1);

# 6 record account, true la admin, false la khach
    insert into users(name, acc, pass, role)
values ('admin','admin','admin',true),
       ('customer','customer1','123456',false),
       ('hieu','hieu','admin',true),
       ('dat','dat','admin',true),
       ('thiet','thiet','admin',true),
       ('tung','tung','admin',true);

# 2 record gio hang
    insert into giohang(cartCode, orderDate, id_khach)
values ('1','2022-05-04 16:21:00',2),
       ('2','2022-05-04 09:21:54',2);

# 2 record chi tiet gio hang
insert into chitietgiohang(id_giohang, id_sach, soLuongSach)
values (1,1,20),
       (1,2,17);

# xoa thong tin khi bi loi