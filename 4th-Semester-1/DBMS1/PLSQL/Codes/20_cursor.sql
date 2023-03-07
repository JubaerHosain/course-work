SET SERVEROUTPUT ON;

DECLARE 
    v_row employees%ROWTYPE;

BEGIN
    SELECT * INTO v_row FROM employees WHERE employee_id=200;
    DBMS_OUTPUT.PUT_LINE('First name: '||v_row.first_name);

EXCEPTION 
    WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('No data found for employee id: 200');

END;
/


    