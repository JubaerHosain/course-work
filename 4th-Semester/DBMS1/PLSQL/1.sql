declare
    t number;

procedure total(t out number) is
begin   
    SELECT count(*) INTO t FROM employees;
end;

begin 
    total(t);
    dbms_output.put_line('Max value: ' || t);
end;
/