create database ManagePatient
create table Doctors
(
Doc_id varchar(10) primary key not null,
FullName varchar(20),
BirthDay date,
gender bit not null,
address varchar(40)

)

create table Patients
(
Pa_id varchar(10) primary key not null,
FullName varchar(20),
BirthDay date,
gender bit not null,
address varchar(40),
outPatient bit not null,
HealthInsurance bit not null,
Doc_id varchar(10) foreign key references Doctors(Doc_id)
)

alter table Patients
alter column Doc_id varchar(10) null



create table Rooms
(
Room_id varchar(10) primary key not null,
type varchar(15),
available int,
pricePerDay real
)

alter table Rooms
add constraint CHK_available check (available >= 0)

create table InPatient
(
Pa_id varchar(10) foreign key references Patients(Pa_id) not null unique,
Room_id varchar(10) foreign key references Rooms(Room_id)
)



create table Medicine
(
Med_id varchar(10) primary key not null,
Med_name varchar(20),
NSX date,
available int,
price real,
HealthInsuranceCoverage real
)

alter table Medicine
add check (available >= 0)

create table prescription
(
Pa_id varchar(10) foreign key references Patients(Pa_id) not null,
Med_id varchar(10) foreign key references Medicine(Med_id) not null,
Time date
)

create table bills
(
Pa_id varchar(10) foreign key references Patients(Pa_id) not null unique,
Room_Charge real,
Med_Charge real,
startDate date,
endDate date
)

create table Nurses
(
Nu_id varchar(10) primary key not null,
FullName varchar(20),
BirthDay date,
gender bit not null,
address varchar(40)
)


create table Shifts
(
Nu_id varchar(10) foreign key references Nurses(Nu_id) not null,
Room_id varchar(10) foreign key references Rooms(Room_id) not null,
Date date not null ,
Shift varchar(1) not null,
constraint check_shift_char check (Shift = 'M' or Shift = 'A' or Shift = 'E' or Shift = 'N')
)




--- trigger updating available bed in rooms when a inpatient is added
GO
create trigger insert_inpatient
on InPatient
for insert
as
begin
	declare @available int = (select available from Rooms, inserted where Rooms.Room_id = inserted.Room_id)
	if (@available = 0)
	begin
		Print 'Phong khong con giuong chong'
		rollback transaction
	end
	else
	begin
		update Patients
		set outPatient = 0
		where Pa_id in (select Pa_id from inserted)
		update Rooms	
		set available = @available - 1
		where Room_id in (select Room_id from inserted)
	end
END; 


--- trigger updating available bed in rooms when a inpatient is deleted
GO
create trigger delete_inpatient
on InPatient
for delete
as
begin
	update Patients
	set outPatient = 1
	where Pa_id in (select Pa_id from deleted)
	declare @available int = (select available from Rooms, deleted where Rooms.Room_id = deleted.Room_id)
	update Rooms	
	set available = @available + 1
	where Room_id in (select Room_id from deleted)
	
END;

----- trigger updating available medicine when a prescription is registered
GO
create trigger insert_presciption
on prescription
for insert
as
begin
	declare @available int = (select available from Medicine, inserted where Medicine.Med_id = inserted.Med_id)
	if (@available = 0)
	begin
		Print 'Thuoc khong con'
		rollback transaction
	end
	else
	begin
		update Medicine	
		set available = @available - 1
		where Med_id in (select Med_id from inserted)
		declare @HealthInsurance bit = (select HealthInsurance from inserted,patients where inserted.Pa_id = patients.Pa_id)
		if (@HealthInsurance = 1)
		begin
			declare @MedChargeWithHI real = (select price - (price*HealthInsuranceCoverage) from inserted,Medicine where inserted.Med_id = Medicine.Med_id)
			update bills
			set Med_Charge = Med_Charge + @MedChargeWithHI
			where bills.Pa_id in (select Pa_id from inserted)
		end
		else
		begin
			declare @MedChargeWithoutHI real = (select price from inserted,Medicine where inserted.Med_id = Medicine.Med_id)
			update bills
			set Med_Charge = Med_Charge + @MedChargeWithoutHI
			where bills.Pa_id in (select Pa_id from inserted)
		end
	end
END; 



GO --- trigger create bill when a new patient added
create trigger insert_patient
on Patients
after insert
as
begin
	insert into bills(Pa_id,Room_Charge,Med_Charge,startDate) values ((select top 1 Pa_id from inserted),0,0,GETDATE())
END;



Go
create trigger nurse_cant_have_two_shifts_insert
on Shifts
instead of insert
as
begin
	if(CAST(GETDATE() as date) > (select Date from inserted ))
	begin
		print 'shift for the past cannot be created'
		rollback transaction
	end
	else if ( (select Nu_id from inserted) in (select Shifts.Nu_id from Shifts,inserted where Shifts.Date = CAST(inserted.Date as date)) )
	begin
		print 'This nurse shift have already created'
		rollback transaction
	end
	else
	begin
		declare @Nu_id varchar(10) = (select Nu_id from inserted)
		declare @Room_id varchar(10) = (select Room_id from inserted)
		declare @Date date = (select Date from inserted)
		declare @Shift varchar(1) = (select Shift from inserted)
		insert into Shifts values (@Nu_id,@Room_id,@Date,@Shift)
	end
END;



Go
create trigger nurse_cant_have_two_shifts_update
on Shifts
instead of update
as
begin
	if (UPDATE(Room_id) or UPDATE(Shift))
	begin
		if(CAST(GETDATE() as date) > (select Date from inserted ))
		begin
			print 'you cant change the past'
			rollback transaction
		end
		declare @date date = (select Date from inserted)
		declare @Room_id varchar(10) = (select Room_id from inserted)
		declare @Shift varchar(1) = (select Shift from inserted)
		update Shifts
		set Room_id = @Room_id, Shift = @Shift
		where Date = @date	
	end
	else
	begin
		if(CAST(GETDATE() as date) > (select Date from inserted ))
		begin
			print 'you cant change the past'
			rollback transaction
		end
		else if ( (select Nu_id from inserted) in (select Shifts.Nu_id from Shifts,inserted where Shifts.Date = CAST(inserted.Date as date)) )
		begin
			print 'A nurse cant have 2 shift'
			rollback transaction
		end
	end
END;

go
create procedure addDoctor @Doc_id varchar(10), @FullName varchar(20), @BirthDay date, @gender bit, @address varchar(40)
as
	begin
		insert into Doctors(Doc_id,FullName,BirthDay,gender,address) values(@Doc_id, @FullName, @BirthDay,@gender,@address);
	end

go
create procedure removeDoctor @Doc_id varchar(10)
as
	begin
		delete from Doctors where Doc_id = @Doc_id;
	end


go
create procedure addPatient @Pa_id varchar(10), @FullName varchar(20), @BirthDay date, @gender bit, @address varchar(40), @outpatient bit = 1, @HealthInsurance bit = 0, @Doc_id varchar(10)
as
	begin
		insert into Patients(Pa_id,FullName,BirthDay,gender,address,outPatient,HealthInsurance,Doc_id) values(@Pa_id,@FullName,@BirthDay, @gender,@address, @outpatient, @HealthInsurance,@Doc_id);
	end

go
create procedure removePatient @Pa_id varchar(10)
as
	begin
		delete from Patients where Pa_id = @Pa_id;
	end


go
create procedure addNurse @Nu_id varchar(10), @FullName varchar(20), @BirthDay date, @gender bit, @address varchar(40)
as
	begin
		insert into Nurses(Nu_id,FullName,BirthDay,gender,address) values(@Nu_id, @FullName, @BirthDay,@gender,@address);
	end

go
create procedure removeNurse @Nu_id varchar(10)
as
	begin
		delete from Nurses where Nu_id = @Nu_id;
	end



go
create procedure addRoom @Room_id varchar(10), @type varchar(15), @available int, @pricePerDay real
as
	begin
		insert into Rooms(Room_id,type,available,pricePerDay) values(@Room_id,@type,@available,@pricePerDay);
	end

go
create procedure removeRoom @Room_id varchar(10)
as
	begin
		delete from Rooms where Room_id = @Room_id;
	end



go
create procedure addInpatient @Pa_id varchar(10), @Room_id varchar(10)
as
	begin
		insert into InPatient(Pa_id,Room_id) values(@Pa_id,@Room_id)
	end

go
create procedure updateInpatient @Pa_id varchar(10), @Room_id varchar(10)
as
	begin
		update InPatient set Room_id = @Room_id where Pa_id = @Pa_id;
	end

go
create procedure addMedicine @Med_id varchar(10), @Med_name varchar(20), @NSX date, @available int = 0, @price real, @HealthInsuranceCoverage real
as 
	begin
		insert into Medicine(Med_id,Med_name,NSX,available,price,HealthInsuranceCoverage) values(@Med_id,@Med_name,@NSX,@available,@price,@HealthInsuranceCoverage);
	end

go
create procedure addMedicineAvail @Med_id varchar(10) ,@available int
as 
	begin
		update Medicine set available = available + @available where Med_id = @Med_id;
	end

go
create procedure removeMedicine @Med_id varchar(10)
as
	begin
		delete from Medicine where Med_id = @Med_id;
	end


go
create procedure addPrescription @Pa_id varchar(10), @Med_id varchar(10), @time date 
as
	begin
		if(@time < CAST(GETDATE() as date))
		begin
			print 'ko the tao don thuoc cho qua khu'
		end
		else
		begin
			insert into prescription(Pa_id,Med_id,Time) values(@Pa_id,@Med_id,@time);
		end
	end

go
create procedure addShift @Nu_id varchar(10), @Room_id varchar(10), @date date, @Shift varchar(1)
as
	begin
		insert into Shifts(Nu_id,Room_id,Date,Shift) values (@Nu_id,@Room_id,@date,@Shift);
	end

go
create procedure updateShift @Nu_id varchar(10), @Room_id varchar(10), @date date, @Shift varchar(1), @Nu_id_change varchar(10) = @Nu_id
as 
	begin
		update Shifts set Nu_id = @Nu_id_change, Room_id = @Room_id where Date = @date and Nu_id = @Nu_id;
	end


go
create procedure createBill @Pa_id varchar(10)
as
	begin
		update bills set endDate = GETDATE() where Pa_id = @Pa_id;
		select * from bills where Pa_id = @Pa_id;
	end












