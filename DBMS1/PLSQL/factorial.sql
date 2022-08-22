declare
    num number;
    factorial number;
    
function get_factorial(n in number) return number is f number;
begin 
    if n = 0 then
        f := 1;
    else
        f := n * get_factorial(n-1);
    end if;
    return f;
end;

begin 
    num := 10;
    factorial := get_factorial(num);
    dbms_output.put_line('Factorial of ' || num || ' is ' || factorial);
end;
/