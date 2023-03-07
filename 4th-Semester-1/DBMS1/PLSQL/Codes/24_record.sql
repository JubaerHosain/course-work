SET SERVEROUTPUT ON;

DECLARE
    -- T_REC is a type
    TYPE T_REC IS RECORD (
        salary          NUMBER,
        minsal          NUMBER DEFAULT 1000,
        hire_date       employees.hire_date%TYPE,
        vrow            employees%ROWTYPE
    );

    -- variable my_rec of type T_REC
    my_rec T_REC;

BEGIN
    my_rec.salary := my_rec.minsal + 500;
    my_rec.hire_date := SYSDATE;

    SELECT * 
    INTO my_rec.vrow 
    FROM employees
    WHERE employee_id = 100;

    DBMS_OUTPUT.PUT_LINE(my_rec.vrow.first_name);
    DBMS_OUTPUT.PUT_LINE(my_rec.vrow.employee_id);
    DBMS_OUTPUT.PUT_LINE(my_rec.minsal);
    DBMS_OUTPUT.PUT_LINE(my_rec.salary);
    DBMS_OUTPUT.PUT_LINE(my_rec.hire_date);
    
END;
/
