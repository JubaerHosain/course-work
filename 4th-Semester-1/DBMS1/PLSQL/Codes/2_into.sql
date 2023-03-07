SET SERVEROUTPUT ON;

DECLARE 
    v_fname VARCHAR2(20);
    v_salary NUMBER(10);

BEGIN 
    SELECT first_name, salary INTO v_fname, v_salary FROM employees 
    WHERE employee_id=200;
    DBMS_OUTPUT.PUT_LINE('First name: ' || v_fname);
    DBMS_OUTPUT.PUT_LINE('Salary: ' || v_salary);

END;
/
