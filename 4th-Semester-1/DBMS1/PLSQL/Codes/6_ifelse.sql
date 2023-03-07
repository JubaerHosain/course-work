SET SERVEROUTPUT ON;

DECLARE 
    v_num1 NUMBER;
    v_num2 NUMBER;
    v_ans  NUMBER;

BEGIN 
    v_num1 := 10;
    v_num2 := 20;

    IF v_num1 > v_num2 THEN 
        v_ans := v_num1;
    ELSE
        v_ans := v_num2;
    END IF;

    DBMS_OUTPUT.PUT_LINE('Max num: ' || v_ans);

END;
/