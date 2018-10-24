create view VERTICAL_SPOCS as select v.VER_ID, v.VER_NAME, l.LD_USER_NAME, l.LD_USER_EMAIL, l.LD_USER_PHONE, u.UR_ID, u.UR_NAME 
from VERTICAL_TYPE v join LD_TEAM l on v.VER_ID=l.LD_VER_REP 
join USER_ROLE u on l.UR_ID=u.UR_ID 
where l.UR_ID=12;


