SET SERVEROUTPUT ON;

DROP TABLE temp;

CREATE TABLE temp (
    id NUMBER,
    first_name VARCHAR2(20),
    salary NUMBER,
    CONSTRAINT TEMP_PK PRIMARY KEY(id)
);

DECLARE
    CURSOR v_tab is SELECT * FROM employees;
    -- v_row employees%ROWTYPE;

BEGIN
    FOR v_row IN v_tab LOOP
        IF v_row.salary >= 10000 THEN
            INSERT INTO temp(id, first_name, salary)
            VALUES(v_row.employee_id, v_row.first_name, v_row.salary); 
        END IF;
    END LOOP;
    
END;
/

SELECT * FROM temp;
