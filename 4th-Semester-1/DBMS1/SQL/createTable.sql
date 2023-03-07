drop table depositor;
drop table borrower;
drop table loan;
drop table account;
drop table customer;
drop table branch;

--Creating Tables

--Branch Table
create table branch (
	branch_name varchar(30) not null,
	branch_city varchar(15) not null,
	assets number(30) not null,
	constraint branch_pk primary key(branch_name)
);

--Customer Table
create table customer(
	customer_name varchar(30) not null,
	customer_street varchar(15) not null,
	customer_city varchar(15) not null,
	constraint customer_pk primary key(customer_name)
);

--Account Table
create table account(
	account_number varchar(30) not null,
	branch_name varchar(30) not null,
	balance number(30) not null,
	constraint account_pk primary key(account_number),
	constraint account_fk foreign key(branch_name) references branch(branch_name)
);

--Loan Table
create table loan(
	loan_number varchar(30) not null,
	branch_name varchar(30) not null,
	amount number(30) not null,
	constraint loan_pk primary key(loan_number),
	constraint loan_fk foreign key(branch_name) references branch(branch_name)
);


--Depositor Table
create table depositor(
	customer_name varchar(30) not null,
	account_number varchar(30) not null,
	constraint depositor_pk primary key(customer_name, account_number),
	constraint depositor_cname_fk foreign key(customer_name) references customer(customer_name),
	constraint depositor_anumber_fk foreign key(account_number) references account(account_number)
);
--insert into depositor(customer_name, account_number) values ('Jubaer', 1);

--Borrower Table
create table borrower(
	customer_name varchar(30) not null,
	loan_number varchar(30) not null,
	constraint borrower_pk primary key(customer_name),
	constraint borrower_cname_fk foreign key(customer_name) references customer(customer_name),
	constraint borrower_lnumber_fk foreign key(loan_number) references loan(loan_number)
);
--insert into borrower(customer_name, loan_number) values ('Jubaer', 1);



--Inserting Data to Tables

-- data insert into branch table
insert into branch (branch_name, branch_city, assets) values ('Brighton', 'Brooklyn', 7100000);
insert into branch (branch_name, branch_city, assets) values ('Downtown', 'Brooklyn', 9000000);
insert into branch (branch_name, branch_city, assets) values ('Mianus', 'Horseneck', 400000);
insert into branch (branch_name, branch_city, assets) values ('North Town', 'Rye', 3700000);
insert into branch (branch_name, branch_city, assets) values ('Perryridge', 'Horseneck', 1700000);
insert into branch (branch_name, branch_city, assets) values ('Pownal', 'Bennington', 300000);
insert into branch (branch_name, branch_city, assets) values ('Redwood', 'Palo Alto', 2100000);
insert into branch (branch_name, branch_city, assets) values ('Round Hill', 'Horseneck', 8000000);


-- date insert into customer table
insert into customer (customer_name, customer_street, customer_city) values('Adams', 'Spring', 'Pittsfield');
insert into customer (customer_name, customer_street, customer_city) values('Brooks', 'Senator', 'Brooklyn');
insert into customer (customer_name, customer_street, customer_city) values('Curry', 'North', 'Rye');
insert into customer (customer_name, customer_street, customer_city) values('Glenn', 'Sand Hill', 'Woodside');
insert into customer (customer_name, customer_street, customer_city) values('Green', 'Walnut', 'Stamford');
insert into customer (customer_name, customer_street, customer_city) values('Hayes', 'Main', 'Harrison');
insert into customer (customer_name, customer_street, customer_city) values('Johnson', 'Alma', 'Palo Alto');
insert into customer (customer_name, customer_street, customer_city) values('Jones', 'Main', 'Harrison');
insert into customer (customer_name, customer_street, customer_city) values('Lindsay', 'Park', 'Pittsfield');
insert into customer (customer_name, customer_street, customer_city) values('Smith', 'North', 'Rye');
insert into customer (customer_name, customer_street, customer_city) values('Turner', 'Putnam', 'Stamford');
insert into customer (customer_name, customer_street, customer_city) values('Williams', 'Nassau', 'Princeton');

-- data insert into account table
insert into account (account_number, branch_name, balance) values('A-101','Downtown',500);
insert into account (account_number, branch_name, balance) values('A-102','Perryridge',400);
insert into account (account_number, branch_name, balance) values('A-201','Brighton',900);
insert into account (account_number, branch_name, balance) values('A-215','Mianus',700);
insert into account (account_number, branch_name, balance) values('A-217','Brighton',750);
insert into account (account_number, branch_name, balance) values('A-222','Redwood',700);
insert into account (account_number, branch_name, balance) values('A-305','Round Hill',350);

-- data insert into loan table
insert into loan (loan_number, branch_name, amount) values ('L-11', 'Round Hill', 900);
insert into loan (loan_number, branch_name, amount) values ('L-14', 'Downtown', 1500);
insert into loan (loan_number, branch_name, amount) values ('L-15', 'Perryridge', 1500);
insert into loan (loan_number, branch_name, amount) values ('L-16', 'Perryridge', 1300);
insert into loan (loan_number, branch_name, amount) values ('L-17', 'Downtown', 1000);
insert into loan (loan_number, branch_name, amount) values ('L-23', 'Redwood', 2000);
insert into loan (loan_number, branch_name, amount) values ('L-93', 'Mianus', 500);

-- data insert into borrower table
insert into borrower (customer_name, loan_number) values ('Adams', 'L-16');
insert into borrower (customer_name, loan_number) values ('Curry', 'L-93');
insert into borrower (customer_name, loan_number) values ('Hayes', 'L-15');
insert into borrower (customer_name, loan_number) values ('Jones', 'L-17');
insert into borrower (customer_name, loan_number) values ('Smith', 'L-11');
insert into borrower (customer_name, loan_number) values ('Williams', 'L-17');


-- data insert into depositor table
insert into depositor (customer_name, account_number) values('Hayes', 'A-102');
insert into depositor (customer_name, account_number) values('Johnson', 'A-101');
insert into depositor (customer_name, account_number) values('Johnson', 'A-201');
insert into depositor (customer_name, account_number) values('Jones', 'A-217');
insert into depositor (customer_name, account_number) values('Lindsay', 'A-222');
insert into depositor (customer_name, account_number) values('Smith', 'A-215');
insert into depositor (customer_name, account_number) values('Turner', 'A-305');