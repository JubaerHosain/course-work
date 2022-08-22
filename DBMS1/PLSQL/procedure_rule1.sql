create or replace procedure greeting as
begin
    dbms_output.put_line('Hello World');
end;
/

execute greeting;

drop procedure greeting;