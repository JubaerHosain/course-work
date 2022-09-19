-- based on Schema.png
-- run createTable.sql First



--[The from Clause]
-- Def: Corresponds to the Cartesian product operation of the relational algebra.
-- Find the Cartesian product (borrower X loan)
select * from borrower, loan;
-- Find the name, loan number and loan amount of all customers having a loan at the Perryridge branch.
select customer_name, borrower.loan_number, amount from borrower, loan where borrower.loan_number = loan.loan_number and branch_name = 'Perryridge';



--[The Rename Operation]
-- Def: SQL allows renaming relations and attributes using the as clause: old-name as new-name
-- Find the name, loan number and loan amount of all customers, rename the column name loan_number as loan_id.
select customer_name, borrower.loan_number as loan_id, amount from borrower, loan where borrower.loan_number = loan.loan_number;



--[Tuple Variables]
-- Def: Tuple variables are defined in the from clause via the use of the as(optional) clause.
-- Some database such as Oracle require as to be omitted.
-- Find the customer names and their loan numbers and amount for all customers having a loan at some branch.
select customer_name, B.loan_number, amount from borrower B, loan L where B.loan_number = L.loan_number;
-- Find the names of all branches that have greater assets than some branch located in Brooklyn.
select B1.branch_name from branch B1, branch B2 where B1.assets > B2.assets and B2.branch_city = 'Brooklyn';



--[String Operations]
-- Def: SQL includes a string-matching operator for comparisons on character strings.  
-- The operator “like” uses patterns that are described using two special characters:
-- 1. percent (%).  The % character matches any substring.
-- 2. underscore (_).  The _ character matches any character.
-- Find the names of all customers whose street includes the substring “Main”.
select customer_name from customer where customer_street like '%Main%'; 





