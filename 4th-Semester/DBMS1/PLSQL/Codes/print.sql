DECLARE
	fname VARCHAR2(24) := 'Jubaer';
	lname VARCHAR2(30);
	
BEGIN
    -- name shold be variable 
	DBMS_OUTPUT.PUT_LINE('Student name: ' || &name);
END; 
/ 