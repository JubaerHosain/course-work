SET SERVEROUTPUT ON;

DECLARE
    CURSOR v_tab is SELECT * FROM employees;
    -- v_row employees%ROWTYPE;

BEGIN
    -- when use for loop don't use this line (automatically opened in for loop)
    -- open cursor
    -- OPEN v_tab;

    -- without declaring v_tab is working in foor loop
    FOR v_row IN v_tab LOOP
        DBMS_OUTPUT.PUT_LINE(v_row.first_name||' '||v_row.salary);
    END LOOP;
    
    -- close cursor
    -- CLOSE v_tab;
END;
/
