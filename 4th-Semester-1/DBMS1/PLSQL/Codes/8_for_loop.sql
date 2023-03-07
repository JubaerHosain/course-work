SET SERVEROUTPUT ON;

DECLARE 
    v_count NUMBER := 10;

BEGIN 
    -- v should not declare
    FOR v IN 1..v_count LOOP
        DBMS_OUTPUT.PUT_LINE('Num: ' || v);
    END LOOP;
    
    FOR v IN REVERSE 1..v_count LOOP
        DBMS_OUTPUT.PUT_LINE('Num: ' || v);
    END LOOP;

END;
/