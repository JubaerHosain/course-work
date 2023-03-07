SET SERVEROUTPUT ON;

DECLARE 
    n_employee VARCHAR2(20);

BEGIN 
    --returns more than one value(it will not work in this code)
    --SELECT employee_id INTO n_employee FROM employees;

    --returns only one value
    SELECT count(employee_id) INTO n_employee FROM employees;
    DBMS_OUTPUT.PUT_LINE('Number of employee: ' || n_employee);

END;
/
