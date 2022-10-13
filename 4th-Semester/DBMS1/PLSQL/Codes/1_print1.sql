SET SERVEROUTPUT ON;

DECLARE
	fname VARCHAR2(30) := 'Jubaer';
	lname VARCHAR2(30) := 'Hosain';
	full_name VARCHAR2(30) := 'Jubaer Hosain';
	
BEGIN
    -- input would be a value, notice single quote
	DBMS_OUTPUT.PUT_LINE('Student name: ' || '&value');

END; 
/ 