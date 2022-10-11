declare
	cursor c_zip is select * from employees;
	r_zip c_zip%rowtype;
begin
	open c_zip;

	loop fetch c_zip into r_zip;
		exit when c_zip%notfound;
		dbms_output.put_line(r_zip.first_name||' '||r_zip.employee_id||' '||r_zip.salary);
	end loop;
end;
/