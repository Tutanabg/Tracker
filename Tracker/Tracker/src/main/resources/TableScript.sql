drop database if exists tracker_db;
create database tracker_db;
use  tracker_db;

create table tracker(
   tracker_id int auto_increment,
   text varchar(50),
   task_day varchar(20),
   reminder boolean,
   constraint ps_tracker_id_pk primary key (tracker_id)
);


insert into tracker (tracker_id, text, task_day, reminder) values (1, 'Doctors Appointment', 'May 5th at 2:30pm', true);
insert into tracker (tracker_id, text, task_day, reminder) values (2, 'Meeting at School', 'May 6th at 1:30pm', true);
insert into tracker (tracker_id, text, task_day, reminder) values (3, 'Food Shopping', 'May 7th at 12:30pm', false);

commit;
select * from tracker;