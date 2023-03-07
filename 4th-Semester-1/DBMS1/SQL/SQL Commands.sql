// 11th batch midterm
SELECT country_id FROM countries;
SELECT constraint_name, constraint_type FROM user_constraints where table_name = 'REGIONS';
SELECT distinct department_name, manager_id FROM departments;
SELECT first_name||q'[''s last name is ]'|| last_name FROM employees;
@F:/ex1_5no_ques.txt;   
    In File -> 
  “SELECT  last_name, salary FROM employees;
  SELECT job_id, min_salary, max_salary FROM jobs;”
SELECT job_id,  max_salary - min_salary as "Salary Difference" FROM jobs;
SPOOL F:\Give_Emp_Raise.out append;
select last_name,manager_id,salary+(salary*.1) "New Salary" from employees;
SPOOL off;
SELECT last_name, salary + salary * nvl( commission_pct, 0 ) as "Total Salary" FROM employees;
