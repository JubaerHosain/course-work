DECLARE
    num NUMBER;
    factorial NUMBER;
    
FUNCTION get_factorial(n NUMBER) 
RETURN NUMBER IS fact NUMBER;
BEGIN 
    IF n = 0 THEN
        RETURN 1;
    ELSE
        fact := n * get_factorial(n-1);
    END IF;
    RETURN fact;
END;

BEGIN 
    num := &number;
    factorial := get_factorial(num);
    DBMS_OUTPUT.PUT_LINE('Factorial of ' || num || ' is ' || factorial);
END;
/