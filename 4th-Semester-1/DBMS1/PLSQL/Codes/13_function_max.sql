DECLARE
    a NUMBER;
    b NUMBER;
    c NUMBER;


-- FUNCTION find_max(x IN NUMBER, y IN NUMBER) 
FUNCTION find_max(x NUMBER, y NUMBER) 
RETURN NUMBER IS z NUMBER;
BEGIN
    IF x > y THEN
        z := x;
    ELSE
        z := y;
    END IF;
    RETURN z;
END;


BEGIN
    a := 20;
    b := 45;
    c := find_max(a, b);
    DBMS_OUTPUT.PUT_LINE('Max number is: ' || c);
END;
/