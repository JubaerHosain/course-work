SET SERVEROUTPUT ON;

DECLARE 
    v_count NUMBER := 0;

BEGIN 
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_count + 1);
        v_count := v_count + 1;
        EXIT WHEN v_count >= 10;
    END LOOP;
    
END;
/