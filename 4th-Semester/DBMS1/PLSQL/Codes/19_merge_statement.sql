DROP TABLE copy_emp;

CREATE TABLE copy_emp AS
SELECT * FROM employees;

SELECT * FROM copy_emp;

DELETE FROM copy_emp
WHERE department_id=50;

UPDATE copy_emp 
SET first_name='Jubaer'
WHERE employee_id=200;

UPDATE copy_emp 
SET  employee_id=500
WHERE employee_id=201;

COMMIT;


-- PL/SQL FOR MERGE
BEGIN
    MERGE INTO copy_emp c
    USING employees e
    ON (c.employee_id=e.employee_id)

    WHEN MATCHED THEN
    UPDATE SET  
    c.first_name = e.first_name,
    c.last_name = e.last_name,
    c.email = e.email,
    c.phone_number = e.phone_number,
    c.hire_date = e.hire_date,
    c.job_id = e.job_id,
    c.salary = e.salary,
    c.commission_pct = e.commission_pct,
    c.manager_id = e.manager_id,
    c.department_id = e.department_id

    WHEN NOT MATCHED THEN
    INSERT VALUES
    (e.employee_id, e.first_name, e.last_name, 
    e.email, e.phone_number, e.hire_date, 
    e.job_id, e.salary, e.commission_pct, 
    e.manager_id, e.department_id);

END;
/

SELECT first_name FROM copy_emp where employee_id=200;
SELECT first_name FROM copy_emp where employee_id=201;
SELECT first_name FROM copy_emp where employee_id=500;


