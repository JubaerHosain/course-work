SET SERVEROUTPUT ON;

DECLARE
	fname VARCHAR2(30) := 'Jubaer';
	lname VARCHAR2(30) := 'Hosain';
	full_name VARCHAR2(30) := 'Jubaer Hosain';
	
BEGIN
    -- var_name shold be a variable name
	DBMS_OUTPUT.PUT_LINE('Student name: ' || &var_name);

END; 
/ 