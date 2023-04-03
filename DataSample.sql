INSERT INTO Rooms (Room_id, type, available, pricePerDay)
VALUES
--10 PHONG VIP---
('R001', 'VIP', 4, 200),
('R002', 'VIP', 4, 200),
('R003', 'VIP', 4, 200),
('R004', 'VIP', 4, 200),
('R005', 'VIP', 4, 200),
('R006', 'VIP', 4, 200),
('R007', 'VIP', 4, 200),
('R008', 'VIP', 4, 200),
('R009', 'VIP', 4, 200),
('R010', 'VIP', 4, 200),
--10 PHONG STANDARD---
('R011', 'STANDARD', 8, 100),
('R012', 'STANDARD', 8, 100),
('R013', 'STANDARD', 8, 100),
('R014', 'STANDARD', 8, 100),
('R015', 'STANDARD', 8, 100),
('R016', 'STANDARD', 8, 100),
('R017', 'STANDARD', 8, 100),
('R018', 'STANDARD', 8, 100),
('R019', 'STANDARD', 8, 100),
('R020', 'STANDARD', 8, 100);
----------10 BAC SI----------
INSERT INTO Doctors 
VALUES
('D001', 'NGUYEN HOANG LONG', '1987-09-12', 1,'Thai Nguyen'),
('D002', 'PHUNG DUC MINH', '1970-09-24', 1, 'Hoa Binh'),
('D003', 'NGUYEN HOANG SON', '1981-05-13', 1, 'Ha Noi'),
('D004', 'DUONG ANH TU', '1989-12-09', 1, 'Ha Noi'),
('D005', 'PHAM VAN TU', '1982-09-23', 1, 'Ha Noi'),
('D006', 'NGUYEN HOANG SON', '1978-06-12', 1, 'Ha Noi'),
('D007', 'LE QUY TRONG', '1977-05-18', 1, 'Hung Yen'),
('D008', 'LE VIET MINH', '1969-08-15', 1,'Ha Noi'),
('D009', 'HOANG VAN MINH', '1975-05-19', 1, 'Thai Binh'),
('D010', 'DUONG MINH ANH', '1982-07-12', 1, 'Ha Noi');
-----------20 Y TA--------------
INSERT INTO Nurses
VALUES
('N001', 'VU THUY TRANG', '1993-05-13', 0,'Ha Noi'),
('N002', 'PHAN TU ANH', '1995-04-12', 0, 'Thai Binh'),
('N003', 'HOANG THI TUYET', '1994-05-19', 0, 'Ha Noi'),
('N004', 'CHU MINH ANH', '1997-05-12', 0, 'Nam Dinh'),
('N005', 'NGUYEN THI MAI', '1996-03-12', 0, 'Ha Noi'),
('N006', 'PHAN HOANG ANH', '1989-05-19', 0, 'Thai Binh'),
('N007', 'MAI THI LOAN', '1992-11-18', 0, 'Thai Nguyen'),
('N008', 'LE THI DUNG', '1995-08-11', 0, 'Ha Noi'),
('N009', 'HOANG NGOC THUY', '1994-02-12', 0, 'Ha Noi'),
('N010', 'PHAM THI THAO', '1995-09-23', 0, 'Ha Noi'),
('N011', 'LE THI DAO', '1996-05-29', 0,'Thai Binh'),
('N012', 'LE THI HONG', '1992-04-1', 0, 'Hai Duong'),
('N013', 'CHU XUAN THU', '1991-02-1', 0, 'Ha Noi'),
('N014', 'PHUNG DUE NHI', '1994-03-12', 0, 'Ha Noi'),
('N015', 'VU THUY LINH', '1998-08-16', 0, 'Tuyen Quang'),
('N016', 'NGUYEN THI THAO MY', '1989-06-24', 0, 'Hai Phong'),
('N017', 'HOANG THI MAI ANH', '1992-07-23', 0, 'Thai Nguyen'),
('N018', 'PHAM NGOC THAO MAI', '1993-05-12', 0, 'Ninh Binh'),
('N019', 'NGUYEN THI HONG HANH', '1991-07-14', 0, 'Thai Nguyen'),
('N020', 'CHU LAN ANH', '1992-09-30', 0, 'Ha Noi');
--------THUOC-------------
INSERT INTO Medicine
VALUES
('ME1', 'Paracetamol', '2022', 1000, 100, 0.3),
('ME2', 'Favipiravir', '2022', 1000, 100, 0.3),
('ME3', 'Molnupiravir', '2022', 1000, 100, 0.3),
('ME4', 'Dexamethason', '2022', 1000, 100, 0.3),
('ME5', 'Methylprednisolon', '2022', 1000, 100, 0.3),
('ME6', 'Rivaroxaban', '2022', 1000, 100, 0.3),
('ME7', 'Apixaban', '2022', 1000, 100, 0.3);
-------20 Y TA MOI Y TA 1 PHONG----------
execute addShift 'N001', 'R001', '2023-8-20',  'M'
execute addShift 'N002', 'R001', '2023-8-20',  'M'
execute addShift 'N003', 'R001', '2023-8-20',  'M'
execute addShift 'N004', 'R001', '2023-8-20',  'M'
execute addShift 'N005', 'R001', '2023-8-20',  'M'
execute addShift 'N006', 'R001', '2023-8-20',  'A'
execute addShift 'N007', 'R001', '2023-8-20',  'A'
execute addShift 'N008', 'R001', '2023-8-20',  'A'
execute addShift 'N009', 'R001', '2023-8-20',  'A'
execute addShift 'N010', 'R001', '2023-8-20',  'A'
execute addShift 'N011', 'R001', '2023-8-20',  'E'
execute addShift 'N012', 'R001', '2023-8-20',  'E'
execute addShift 'N013', 'R001', '2023-8-20',  'E'
execute addShift 'N014', 'R001', '2023-8-20',  'E'
execute addShift 'N015', 'R001', '2023-8-20',  'E'
execute addShift 'N016', 'R001', '2023-8-20',  'N'
execute addShift 'N017', 'R001', '2023-8-20',  'N'
execute addShift 'N018', 'R001', '2023-8-20',  'N'
execute addShift 'N019', 'R001', '2023-8-20',  'N'
execute addShift 'N020', 'R001', '2023-8-20',  'N'


------
execute addPatient 'Pa001', 'Bui Nhat Minh', '2002-2-12',  1, 'Ha Noi', 1, 1, 'D001'
execute addPatient 'Pa002', 'Nguyen Nhat Minh', '2004-12-2',  1, 'Ha Noi', 1, 1, 'D001'
execute addPatient 'Pa003', 'Nguyen Cao Son', '1975-6-03',  1, 'Ha Noi', 0, 1, 'D002'
execute addPatient 'Pa004', 'Nguyen Thanh Binh', '1980-2-4',  1, 'Ha Noi', 0, 1, 'D002'
execute addPatient 'Pa005', 'Cao Quoc Dung', '1980-2-5',  1, 'Ha Noi', 1, 1, 'D003'
execute addPatient'Pa006', 'Mai Ngoc Giang', '1980-2-6',  1, 'Ha Noi', 1, 1, 'D003'
execute addPatient'Pa007', 'Hoang Van Manh', '1980-2-7',  1, 'Ha Noi', 0, 1, 'D004'
execute addPatient'Pa008', 'Luu Tran Tien', '1980-2-8',  1, 'Ha Noi', 1, 1, 'D004'
execute addPatient'Pa009', 'Luu Thanh Thao', '1980-2-9',  1, 'Ha Noi', 1, 1, 'D005'
execute addPatient'Pa010', 'Duong Tien Dat', '1980-2-10',  1, 'Ha Noi', 0, 1, 'D005'
execute addPatient'Pa011', 'Nguyen Truong Giang', '1980-2-11',  1, 'Ha Noi', 1, 1, 'D006'
execute addPatient'Pa012', 'Nguyen Duc Minh', '1980-2-12',  1, 'Ha Noi', 0, 1, 'D006'
execute addPatient'Pa013', 'Nguyen Huu thang', '1980-2-13',  1, 'Ha Noi', 1, 1, 'D007'
execute addPatient'Pa014', 'Pham Cong Lap', '1980-2-14',  1, 'Ha Noi', 1, 1, 'D007'
execute addPatient'Pa015', 'Nguyen Dang Duong', '1980-2-15',  1, 'Ha Noi', 1, 1, 'D008'
execute addPatient'Pa016', 'Duong Van Tu', '1980-2-16',  1, 'Ha Noi', 0, 1, 'D008'
execute addPatient'Pa017', 'Dang Thuy Linh', '1980-2-17',  0, 'Ha Noi', 0, 1, 'D009'
execute addPatient'Pa018', 'Nguyen Thao Nguyen', '1980-2-18', 0, 'Ha Noi', 0, 1, 'D009'
execute addPatient'Pa019', 'Le Thao Nguyen', '1978-2-19',  0, 'Ha Noi', 0, 1, 'D010'
execute addPatient'Pa020', 'Dang Doan Cam Ly', '2002-2-20',  0, 'Ha Noi', 0, 1, 'D010'

INSERT INTO InPatient
VALUES
('Pa001','R001')
INSERT INTO InPatient
VALUES
('Pa002','R005')
INSERT INTO InPatient
VALUES
('Pa005','R003')
INSERT INTO InPatient
VALUES
('Pa006','R010')
INSERT INTO InPatient
VALUES
('Pa008','R008')
INSERT INTO InPatient
VALUES
('Pa009','R002')
INSERT INTO InPatient
VALUES
('Pa011','R003')
INSERT INTO InPatient
VALUES
('Pa013','R005')
INSERT INTO InPatient
VALUES
('Pa014','R009')
INSERT INTO InPatient
VALUES
('Pa015','R002');

INSERT INTO prescription
VALUES
('Pa001', 'ME1', '2022-7-15')
INSERT INTO prescription
VALUES
('Pa001', 'ME3', '2022-7-22')
INSERT INTO prescription
VALUES
('Pa001', 'ME6', '2022-7-22')
INSERT INTO prescription
VALUES
('Pa001', 'ME7', '2022-7-22')
INSERT INTO prescription
VALUES
('Pa001', 'ME2', '2022-7-22')
INSERT INTO prescription
VALUES
('Pa001', 'ME4', '2022-7-22')
INSERT INTO prescription
VALUES
('Pa007', 'ME5', '2022-7-22')
INSERT INTO prescription
VALUES
('Pa008', 'ME6', '2022-7-22')
INSERT INTO prescription
VALUES
('Pa009', 'ME3', '2022-7-22')
INSERT INTO prescription
VALUES
('Pa010', 'ME5', '2022-7-22');
select * from Patients
select * from Shifts
select * from Doctors order by Doc_id asc
select * from Nurses
select * from InPatient
select * from Medicine
select * from prescription
select * from bills
select * from Rooms
execute addPrescription 'Pa001', 'ME2', '2022-6-22'

select * from InPatient where Pa_id = 'Pa001'

update Doctors set Doc_id = '', FullName = '', BirthDay ='', gender = 1, address='Ha Noi' where Doc_id = 'D002'
update Patients set Pa_id = 'P001', FullName = 'Son', BirthDay = '2002-9-4', gender = 1, address ='Ha Noi', outPatient = 1, HealthInsurance = 1, Doc_id='D002' where Pa_id = 'Pa001'
execute removePatient 'Pa018'
execute removeDoctor 'D001'
execute addDoctor 'D011', 'DUONG MINH ANH', '1982-07-12', 1, 'Ha N'

update Medicine set Med_name = 'sondsa', NSX = '2002-9-4', available = 1, price = 10, HealthInsuranceCoverage = 0.1 where Med_id = 'ME025'

execute addPatient'Pa025', 'Nguyen Thao Nguyen', '2-18-2002', 0, 'Ha Noi', 0, 1, 'D001'
update Rooms set type = '', available = 0, pricePerDay = 0 where Room_id = 'R019'

update InPatient set Room_id ='R002' where Pa_id ='Pa003'

execute createBill 'Pa025'
select * from bills where Pa_id = 'Pa025'

execute addPrescription 'Pa025' ,'ME6' ,'2022-11-17'


