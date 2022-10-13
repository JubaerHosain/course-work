SET SERVEROUTPUT ON;

DECLARE
    v_eid NUMBER := &eid;
	v_fname VARCHAR2(25);
	v_lname VARCHAR2(25);

BEGIN
	SELECT first_name, last_name
	INTO v_fname, v_lname
	FROM employees
	WHERE employee_id = v_eid;
	DBMS_OUTPUT.PUT_LINE('Student name: '||v_fname||' '||v_lname);

EXCEPTION
	WHEN NO_DATA_FOUND 
    THEN DBMS_OUTPUT.PUT_LINE('There is no student with student id: '||v_eid);

END;
/