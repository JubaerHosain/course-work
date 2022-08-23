declare
	ann_sal number;
	tax number;
	id number := &eid;
	vre employees%rowtype;
begin
	select * into vre from employees 
	where employee_id = id;

	ann_sal := vre.salary * 12;
	ann_sal := ann_sal + ann_sal *  NVL(vre.commission_pct, 0);
	tax := 0.1 * ann_sal;
	
	dbms_output.put_line(tax);

	exception when no_data_found then
	dbms_output.put_line('no data found');
end;
/