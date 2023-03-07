SET SERVEROUTPUT ON;

DECLARE 
    v_fname employees.first_name%TYPE;
    v_lname v_fname%TYPE;

BEGIN 
    SELECT first_name, last_name
    INTO v_fname, v_lname
    FROM employees 
    WHERE employee_id=200;
    DBMS_OUTPUT.PUT_LINE('Name: ' || v_fname || ' ' || v_lname);

END;
/
