declare 
	v number := 0;
begin
	loop
	v := v + 1;
	dbms_output.put_line('num: ' || v);
	exit when v >= 10;
	end loop;
end;
/
