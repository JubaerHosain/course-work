DECLARE
    a NUMBER;
    b NUMBER;
    c NUMBER;

PROCEDURE max_value(x IN number, y IN number, z OUT number) IS
BEGIN   
    IF x > y THEN
        z := x;
    ELSE
        z := y;
    END IF;
END;

BEGIN 
    a := 5;
    b := 6;
    max_value(a, b, c);
    DBMS_OUTPUT.PUT_LINE('Max value: ' || c);
END;
/

