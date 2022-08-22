CREATE OR REPLACE FUNCTION totalEemployee RETURN NUMBER IS 
    total NUMBER := 0;
BEGIN
    SELECT count(*) INTO total FROM employees;
    RETURN total;
END;
/ 

BEGIN 
    DBMS_OUTPUT.PUT_LINE('Total number of Employee ' || totalEemployee());
END;
/