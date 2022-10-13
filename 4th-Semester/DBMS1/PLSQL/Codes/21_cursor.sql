SET SERVEROUTPUT ON;

DECLARE 
    eid NUMBER := &employee_id;
    tax NUMBER;
    ann_sal NUMBER;
    v_row employees%ROWTYPE;

BEGIN
    SELECT * INTO v_row FROM employees WHERE employee_id=eid;

    ann_sal := v_row.salary * 12;
    ann_sal := ann_sal + ann_sal * NVL(v_row.commission_pct, 0);
    tax := 0.1 * ann_sal;

    DBMS_OUTPUT.PUT_LINE('Annual salary: '||ann_sal);
    DBMS_OUTPUT.PUT_LINE('10% tax: '||tax);

EXCEPTION 
    WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('No data found for employee id: '||eid);

END;
/