SET SERVEROUTPUT ON;

DECLARE 
    v_name1 VARCHAR2(30);
    v_name2 VARCHAR2(30);

BEGIN 
    -- both works
    -- v_name1 := q'[Father's day]';
    v_name2 := q'!Mothers's Day!';
    DBMS_OUTPUT.PUT_LINE('name: ' || v_name2);

END;
/
