
begin
	for v in 1..10 loop
	dbms_output.put_line('num: ' || v);
	end loop;
 
	for v in reverse 1..10 loop
	dbms_output.put_line('num: ' || v);
	end loop;
end;
/
