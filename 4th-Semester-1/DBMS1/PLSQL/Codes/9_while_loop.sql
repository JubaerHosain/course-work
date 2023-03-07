SET SERVEROUTPUT ON;

DECLARE 
    v_i NUMBER := 0;
    v_n NUMBER := 10;

BEGIN 
    WHILE v_i < v_n LOOP
        DBMS_OUTPUT.PUT_LINE('Num: ' || v_i);
        v_i := v_i + 1;
    END LOOP;

END;
/