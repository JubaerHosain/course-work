declare
	v1 integer := 0;
	v2 integer;
begin
	while v1 < 3 loop
	dbms_output.put_line('v1: ' || v1);
	v2 := 0;
		loop
		dbms_output.put_line('v2: ' || v2);
		v2 := v2 + 1;
		exit when v2 >= 2;
		end loop;
	v1 := v1 + 1;
	end loop;
end;
/