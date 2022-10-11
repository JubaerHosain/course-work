DECLARE
	num1 NUMBER := 4;
    num2 NUMBER := 4;
    ans NUMBER := -1;
	
BEGIN
	IF num1 > num2 
        THEN  ans := num1;
    ELSIF num2 > num1
        THEN ans := num2;
    ELSE
        ans := 0;
    END IF;
    DBMS_OUTPUT.PUT_LINE(ans);
END; 
/ 