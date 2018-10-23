describe user_role;
describe ld_team;
describe vertical_type;
describe confirmed_training;
describe in_progress_training;
describe training_status;
describe training_type;
describe training_request_form;
describe vendor;
describe developer_training_member;
describe ld_training_member;
describe internal_training;
describe dev_training;
describe vendor_training;


select * from user_role;
select * from ld_team;
select * from vertical_type;
select * from confirmed_training;
select * from in_progress_training;
select * from training_status;
select * from training_type;
select * from training_request_form;
select * from vendor;
select * from developer_training_member;
select * from ld_training_member;
select * from internal_training;
select * from dev_training;
select * from vendor_training;

drop table user_role cascade constraints;
drop table ld_team cascade constraints;
drop table vertical_type cascade constraints;
drop table confirmed_training cascade constraints;
drop table training_status cascade constraints;
drop table training_type cascade constraints;
drop table training_request_form cascade constraints;
drop table vendor cascade constraints;
drop table developer_training_member cascade constraints;
drop table ld_training_member cascade constraints;
drop table internal_training cascade constraints;
drop table dev_training cascade constraints;
drop table vendor_training cascade constraints;

/* Verify join between LD_Team and Vertical_Type*/
select * from vertical_type v 
join ld_team l on v.ver_id=l.LD_VER_REP; /*Works fine*/

select v.ver_name, l.ld_user_name, l.ld_user_phone, l.ld_user_email from 
vertical_type v join ld_team l on v.ver_id = l.ld_ver_rep
where v.ver_id=1; /*Works fine*/

/* Verify join between User_Role and LD_Team */
select * from ld_team l 
join user_role u on l.ur_id=u.ur_id; /*Works fine*/

select l.ld_user_name, l.ld_user_phone, l.ld_user_email, u.ur_name from
ld_team l join user_role u on l.ur_id=u.ur_id; /*Works fine*/

select l.ld_user_name, l.ld_user_phone, l.ld_user_email, u.ur_name from
ld_team l join user_role u on l.ur_id=u.ur_id 
where u.ur_id=12; /*Works fine for ur_id*/

select l.ld_user_name, l.ld_user_phone, l.ld_user_email, u.ur_name from
ld_team l join user_role u on l.ur_id=u.ur_id 
where u.ur_name='LD SPOC'; /*Works fine*/ 

select l.ld_user_name, l.ld_user_phone, l.ld_user_email, u.ur_name from
ld_team l join user_role u on l.ur_id=u.ur_id 
where u.ur_name='MANAGER'; /*Works fine*/

/* Verify triple join between User_Role, LD_Team, Vertical_Type */
select * from vertical_type v join
ld_team l on v.ver_id=l.ld_ver_rep
join user_role u on l.ur_id=u.ur_id; /*Works fine*/

select l.ld_user_name, l.ld_user_phone, l.ld_user_email, u.ur_name, v.ver_name from vertical_type v join
ld_team l on v.ver_id=l.ld_ver_rep
join user_role u on l.ur_id=u.ur_id
where u.ur_name='MANAGER'; /*Works fine*/

/* Verify join between Vertical_Type and Confirmed_Training */
select * from confirmed_training c
join vertical_type v on c.ver_id=v.ver_id;

describe confirmed_training;
/*Problem here - ver_id isn't included in combined_training as a foreign key */

/* Verify join between Vertical_Type and Training_Request_Form */
select * from training_request_form t join
vertical_type v on t.ver_id=v.ver_id; /* Works fine */

select t.trf_technology, t.trf_project_id, v.ver_name from 
training_request_form t join vertical_type v on t.ver_id=v.ver_id; /* Works fine */

select v.ver_name, count(*) from 
training_request_form t join vertical_type v on t.ver_id=v.ver_id
group by v.ver_name;  /*Works fine*/

select * from training_request_form;
update TRAINING_REQUEST_FORM set ver_id=1, tt_id=1, trf_technology='Java', trf_training_objectives='Focus on core java', trf_proposed_end_date='20-FEB-19', trf_approved_file_location=null, trf_training_source=1 where TRF_ID=15;
rollback;

