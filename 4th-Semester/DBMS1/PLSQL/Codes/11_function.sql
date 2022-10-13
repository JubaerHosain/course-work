SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION total_employee
RETURN NUMBER IS total NUMBER := 0;
BEGIN 
    SELECT count(*) 
    INTO total 
    FROM employees;
    RETURN total;
END;
/  -- must / here

BEGIN
	DBMS_OUTPUT.PUT_LINE('Total number of employee: '||total_employee());
END;
/