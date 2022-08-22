declare
    a number;

procedure squre(x in out number) is
begin   
    x := x * x;
end;

begin 
    a := 0.5;
    squre(a);
    dbms_output.put_line('Squre value: ' || a);
end;
/