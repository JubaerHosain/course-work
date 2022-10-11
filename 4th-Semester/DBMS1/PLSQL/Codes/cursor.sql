declare
	vre employees%rowtype;
begin
	select * into vre from employees 
	where employee_id = 100;
	dbms_output.put_line(vre.first_name || ' ' || vre.last_name);

	exception when no_data_found then
	dbms_output.put_line('no data found');
end;
/