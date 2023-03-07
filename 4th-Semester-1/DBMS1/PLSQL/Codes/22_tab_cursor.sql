SET SERVEROUTPUT ON;

DECLARE
    CURSOR v_tab is SELECT * FROM employees;
    v_row employees%ROWTYPE;

BEGIN
    -- open cursor
    OPEN v_tab;

    LOOP 
        FETCH v_tab INTO v_row;
        EXIT WHEN v_tab%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_row.first_name||' '||v_row.salary);
    END LOOP;
    
    -- close cursor
    CLOSE v_tab;
END;
/
