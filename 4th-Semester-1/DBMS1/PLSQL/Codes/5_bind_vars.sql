-- Also called host variables
-- Used in sql statements and plsql blocks
-- Values can be output using PRINT command

-- use colon(:) before using bind variables

SET SERVEROUTPUT ON;

-- this is not working
-- VARIABLE num NUMBER(10);

-- this is working
VARIABLE num NUMBER;

BEGIN 
    :num := 1000;
END;
/

PRINT num;
