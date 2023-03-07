SET SERVEROUTPUT ON;

VARIABLE b_salary NUMBER;

BEGIN 
    SELECT salary
    INTO :b_salary
    FROM employees
    WHERE employee_id=200;
END;
/

PRINT b_salary;

-- uses bind var
SELECT employee_id, first_name
FROM employees
WHERE salary=:b_salary;