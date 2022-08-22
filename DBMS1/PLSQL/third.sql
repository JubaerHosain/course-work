SET SERVEROUTPUT ON;

DECLARE
    v_employee_id NUMBER := &v_employee_id;
	v_first_name VARCHAR2(20);
	v_last_name VARCHAR2(25);
BEGIN
	SELECT first_name, last_name
	INTO v_first_name, v_last_name
	FROM employees
	WHERE EMPLOYEE_ID = v_employee_id;
	DBMS_OUTPUT.PUT_LINE('Student name: '||v_first_name||' '||v_last_name);
EXCEPTION
	WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE
	    ('There is no student with student id 123');
END;
/