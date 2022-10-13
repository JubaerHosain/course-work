SET SERVEROUTPUT ON;

DECLARE
	v_area NUMBER;
    v_r NUMBER := &radius;
    PI NUMBER := 3.1416;
	
BEGIN
	SELECT PI * v_r * v_r 
    INTO v_area 
    FROM dual;

	DBMS_OUTPUT.PUT_LINE('Circle Area: ' || v_area);
    
END; 
/ 