drop table tt;

CREATE TABLE tt (
	id number,
	name varchar(50),
	salary number,
	CONSTRAINT branch_PK PRIMARY KEY(id)
);

declare
	cursor c_zip is select * from employees;
	r_zip c_zip%rowtype;
begin
	open c_zip;

	loop fetch c_zip into r_zip;
		exit when c_zip%notfound;
		if r_zip.salary > 5000 then
			dbms_output.put_line(r_zip.salary);
			insert into tt(id, name, salary) values (r_zip.employee_id, r_zip.first_name, r_zip.salary);
		end if;
	end loop;
end;
/