declare
    a number;
    b number;
    c number;

procedure max_value(x in number, y in number, z out number) is
begin   
    if x > y then
        z := x;
    else
        z := y;
    end if;
    dbms_output.put_line('Max value: ' || z);
end;

begin 
    a := 5;
    b := 6;
    max_value(a, b, c);
    dbms_output.put_line('Max value: ' || c);
end;
/