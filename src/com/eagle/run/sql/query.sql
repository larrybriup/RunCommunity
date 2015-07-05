select * from  graderecord;
select * from  MEMBERINFO;
select * from  POINTACTION;
select * from  POINTRECORD;
select * from  MESSAGERECORD;
select * from  memberspace;
select * from  memberspace where id=256;
delete from MEMBERINFO;
delete from MEMBERSPACE;
delete from POINTRECORD;
update POINTACTION set ActionName='REPLYTENSTICK' where id=11;

begin
  delete from miao_test;
  for i in 1..10 loop
   insert into miao_test values('choda');
 end loop;
end;
/
select * from miao_test;
