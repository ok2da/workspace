drop table delete_file purge;
create table delete_file3(
	board_file varchar2(50),
	reg_date date default sysdate
);
==========================================
create or replace trigger save_delete_file3
after update or delete
on board3
for each row
begin
	if(:old.board_file is not null) then
	if(:old.board_file != :new.board_file or :new.board_file is null ) then
		insert into delete_file3
		(board_file)
		values(:old.board_file);
	end if;
	end if;
end;
/
===========================================

select * from delete_file3;

drop trigger save_delete_file3;

select trigger_name from user_triggers;

-- sts에서 실행하는 경우는 8번~ 20번라인(/미포함) 영역 설정 후 Execute selected Text As One Statement 선택
-- cmd에서 실행하는 경우는  / 포함