DECLARE
	area NUMBER;
    r NUMBER := 5;
    PI NUMBER := 3.1416;
	
BEGIN
	SELECT PI * r * r INTO area from dual;
	--where employee_id = 100;
	DBMS_OUTPUT.PUT_LINE('Circle Area: ' || area);
END; 
/ 