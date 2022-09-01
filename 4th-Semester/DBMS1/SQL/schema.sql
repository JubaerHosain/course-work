select * from loan;

-- Find the name, loan number and loan amount of all 
-- customers having a loan at the Perryridge branch.
select customer_name, borrower.loan_number, amount from 
borrower, loan where borrower.loan_number = loan.loan_number 
and loan.branch_name = 'Perryridge';

--Find the customer names and their loan numbers and 
--amount for all customers having a loan at some branch.
select customer_name, loan.loan_number, amount from borrower, 
loan where loan.loan_number = borrower.loan_number;

-- Find the names of all branches that have greater assets than
-- some branch located in Brooklyn.
select distinct t.branch_name from branch t, branch s where 
t.assets > s.assets and s.branch_city = 'Brooklyn';

--List in alphabetic order the names of all customers having a 
--loan in Perryridge branch
select customer_name from borrower, loan where borrower.loan_number = 
loan.loan_number and branch_name = 'Perryridge' order by customer_name;

-- Find all customers who have a loan, an account, or both:
select customer_name from depositor union (select customer_name from borrower);

-- Find all customers who have both a loan and an account.
select customer_name from depositor intersect select customer_name from borrower;

-- Find all customers who have an account but no loan.
select distinct customer_name from depositor where 
customer_name not in (select customer_name from borrower);

-- Find the average account balance at the Perryridge branch.
select avg(balance) from account where branch_name = 'Perryridge';

-- Find the number of tuples in the customer relation
select count(*) from customer;

-- Find the number of depositors in the bank.
select count(distinct customer_name) from depositor;