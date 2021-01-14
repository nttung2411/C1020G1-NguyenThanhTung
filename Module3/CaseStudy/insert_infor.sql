

insert into ViTri values(1,"Lễ Tân"),
						(2,"Phục vụ"),
						(3,"Chuyên viên"),
                        (4,"Giám sát"),
                        (5,"Quản lý"),
                        (6,"Giám Đốc");
				
insert into trinhdo values(1,"Đại Học "),
						  (2,"Cao Đẳng"),
						  (3,"Trung Cấp");
                          
insert into bophan values(1,"Sales"),
						 (2,"Phục vụ"),
						 (3,"Hành chính"),
                         (4,"Quản lý");
                         
insert into loaikhach values (1,"Diamond"),
							 (2,"Platinum"),
                             (3,"Gold"),
                             (4,"Silver"),
                             (5,"Member");
                             
insert into KieuThue values (10,"Tháng"),
							(20,"Tuần"),
							(30,"Ngày");                           
                            
insert into loaidichvu values (1,"Villa"),
							  (2,"House"),
                              (3,"Room");
                            
insert into dichvu values(1,"Rose",700,null,20,500,"Còn mới",30,1),
						 (2,"Coconut",500,null,10,100,"Mới sửa chữa",20,1),
						 (3,"Apple",300,4,15,300,"Còn mới",10,2),
						 (4,"Pineapal",150,null,10,50,"Xây dựng 2 năm",10,3),
						 (5,"Banana",300,null,30,1000,"Còn mới",20,1);
                             
insert into dichvudikem values (1,"Karaoke",50,"Buổi tối sau 7h"),
								(2,"Massage",100,"Cả ngày"),
                                (3,"Thuê xe tham quan",80,"Đến hết 19h");

insert into nhanvien values (1,"Nguyễn Văn A","2000-01-01",123456789,300,0213456789,"abc1@gmail.com","Đà Nẵng",3,1,1),
(2,"Lê Văn B","2001-02-01",12345678,350,0213456781,"abc3@gmail.com","Huế",2,1,2),
(3,"Hà Văn C","2002-03-01",123456782,360,0213456782,"abc4@gmail.com","Quảng Nam",2,2,2),
(4,"Lý Văn A","2003-04-01",123456783,400,0213456784,"abc7@gmail.com","Hà Nội",1,2,2),
(5,"Nguyễn Văn F","1990-01-02",123456784,1000,0213456783,"ab8c@gmail.com","Sài Gòn",6,1,4),
(6,"Quang Thanh A","1991-03-01",123456785,700,0213456787,"abc2@gmail.com","Đà Nẵng",5,1,4),
(7,"Nguyễn Thanh O","1993-01-01",123456786,200,0213456786,"abc5@gmail.com","Quảng Bình",1,2,2),
(8,"Hứa Văn C","1995-01-01",123456779,300,0213456766,"abc10@gmail.com","Huế",3,2,3),
(9,"Lê Thị N","1994-01-01",123456780,300,0213456755,"abc20@gmail.com","Quảng Nam",3,1,3),
(10,"Nguyễn Thị M","1999-01-01",123456712,300,0213456777,"abc32@gmail.com","Đà Nẵng",2,2,2);

insert into khachhang values (1,"Thanh Tùng","1995-11-24","201694828","0934965616","abc@gmail.com","Đà Nẵng",1),
(2,"Lê Tùng","1991-09-24","201694823","0934965612","abc1@gmail.com","Huế",2),
(3,"Lý Tùng","1992-02-24","201694822","0934965613","abc2@gmail.com","Đà Nẵng",3),
(4,"Lương Tùng","1990-12-24","201694821","0934965619","abc3@gmail.com","Quảng Nam",4),
(5,"Trần Tùng","1997-04-24","201694829","0934965636","abc4@gmail.com","Quảng Trị",1);

insert into hopdong values (1,"2021-01-01","2021-12-01",1000,7200,2,1,1),
						   (2,"2021-10-01","2021-12-01",100,900,3,2,3),
						   (3,"2021-09-01","2021-12-01",200,2000,1,3,2),
						   (4,"2021-08-01","2021-12-01",2000,5000,10,5,5);
	
insert into hopdongchitiet values (1,2,3,1),
								  (2,1,3,1),
								  (3,2,1,1),
								  (4,3,2,1);