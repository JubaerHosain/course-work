declare 
	v number := 10;
begin
	while v > 0 loop
	dbms_output.put_line('num: ' || v);
	v := v - 1;
	end loop;
end;
/
