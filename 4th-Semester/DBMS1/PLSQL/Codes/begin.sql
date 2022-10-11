DECLARE
	fname VARCHAR2(30);
	lname VARCHAR2(30);
	
BEGIN
	SELECT first_name, last_name INTO fname, lname FROM employees
	where employee_id = 100;
	DBMS_OUTPUT.PUT_LINE('Student name: ' || fname || ' ' || lname);
END; 
/