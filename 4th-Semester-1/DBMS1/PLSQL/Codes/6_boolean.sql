SET SERVEROUTPUT ON;

DECLARE 
    v_salary NUMBER := &salary;
    v_good BOOLEAN;

BEGIN 
    v_good := v_salary BETWEEN 70000 AND 1000000;

    IF v_good THEN 
        DBMS_OUTPUT.PUT_LINE('Good Salary');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Low Salary');
    END IF;

END;
/