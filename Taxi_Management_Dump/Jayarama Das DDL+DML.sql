create database taxi_mgmt;

use taxi_mgmt;

create table customer
(
	cust_id int primary key,
    cust_name varchar(20) not null,
    cust_address varchar(40) not null,
    cust_email varchar(20),
    cust_phone numeric(10)
);

create table booking
(
	booking_id int primary key,
    pickup_loc varchar(50) not null,
    drop_loc varchar(50) not null,
    journey_time time not null,
    user_rating int not null
);

create table driving
(
	dr_id int primary key,
    dr_name varchar(30) not null,
    dr_phone numeric(10) not null,
    dr_rating int not null,
    dr_license_num numeric(15) not null
);

create table taxi
(
	vehicle_reg_num numeric(4) primary key,
    model varchar(20) not null,
    color varchar(20),
    owner_details varchar(20) not null,
    insurance_details varchar(20) not null
);

create table owning
(
	vehicle_reg_num numeric(4),
    dr_id int,
	primary key(vehicle_reg_num,dr_id),
	foreign key(vehicle_reg_num) references taxi(vehicle_reg_num),
    foreign key(dr_id) references driving(dr_id)
);

create table assigned
(
    dr_id int,
    booking_id int,
	primary key(dr_id,booking_id),
    foreign key(dr_id) references driving(dr_id),
	foreign key(booking_id) references booking(booking_id)    
);

create table all_bookings
(
	cust_id int,
    booking_id int,
    primary key(cust_id,booking_id),
    foreign key(cust_id) references customer(cust_id),
    foreign key(booking_id) references booking(booking_id)
);

insert into customer values(1,"customer1", "add1", "c1@c.com",123);
insert into customer values(2,"customer2", "add2", "c2@c.com",124);
insert into customer values(3,"customer3", "add3", "c3@c.com",125);
insert into customer values(4,"customer4", "add4", "c4@c.com",126);

insert into driving values(1,"driver1",131,5,10001);
insert into driving values(2,"driver2",132,4,10002);
insert into driving values(3,"driver3",133,3,10003);
insert into driving values(4,"driver4",134,5,10004);

insert into booking values(1,"pick1","drop1","1:30",3);
insert into booking values(2,"pick2","drop2","2:30",4);

insert into taxi values(1,"model1","color1","owner1","No.276fqwe1822");
insert into taxi values(2,"model2","color2","owner2","No.15r76t2fw61");

insert into all_bookings values(1,1);
insert into all_bookings values(2,1);
insert into all_bookings values(3,2);

insert into owning values(1,3);
insert into owning values(2,1);

insert into assigned values(3,1);
insert into assigned values(1,2);

select * from customer;
select dr_name,model,insurance_details 
from taxi,driving,owning 
where taxi.vehicle_reg_num=owning.vehicle_reg_num and driving.dr_id=owning.dr_id;

select * from driving order by dr_rating;
