-- 1) Write down the SQL subquery considering below schema of Apple store
-- database
-- Customer (Customer_id, first_name, Last_name)
-- Payment (customer_id, Product_id, Payment_id, amount, Payment_date)
-- Product (Product_id, Product_name, Product_type, Color)
-- i.Give the name of customers who have made the payment in the middle of
-- 1st Aug 2023 and 10th Aug 2023.
-- ii.Give the list of product name whose color is red and type is iPhone.
-- iii.Give all the product names and product types which were bought by
-- Shyam Patel
-- iv.Give the first name of customers whose total payment is greater than
-- 2lack rupees.
SELECT first_name,
	last_name
FROM Customer
WHERE Customer_id IN (
		SELECT customer_id
		FROM Payment
		WHERE Payment_date BETWEEN '2023-08-01' AND '2023-08-10'
	);
SELECT Product_name
FROM Product
WHERE Color = 'Red'
	AND Product_type = 'iPhone';
SELECT P.Product_name,
	P.Product_type
FROM Product AS P
	INNER JOIN Payment AS PY ON P.Product_id = PY.Product_id
	INNER JOIN Customer AS C ON PY.customer_id = C.Customer_id
WHERE C.first_name = 'Shyam'
	AND C.last_name = 'Patel';
SELECT first_name
FROM Customer
WHERE Customer_id IN (
		SELECT customer_id
		FROM Payment
		GROUP BY customer_id
		HAVING SUM(amount) > 200000
	);
-- 2) Write a SQL query considering below schema of database
-- Manager (Mid, Eid, Mname)
-- Department (Did,Mid, Dname, location)
-- Employee (Eid, Ename, mobile, salary, joining_date, Mid)
-- i.Give the name and salary of employees whose salary are greater than each
-- and every employees working under manager id 14.
-- ii.Give the name of employees who have not assigned any department.
-- iii.Give the employees’ name whose location is Kota.
-- iv.Give the name of manager along with count of employees assigned to
-- him/her in descending order.
SELECT E.Ename,
	E.salary
FROM Employee AS E
WHERE E.salary > ALL (
		SELECT E2.salary
		FROM Employee AS E2
		WHERE E2.Mid = 14
	);
SELECT E.Ename
FROM Employee AS E
WHERE E.Eid NOT IN (
		SELECT DISTINCT D.Eid
		FROM Department AS D
	);
SELECT E.Ename
FROM Employee AS E
	INNER JOIN Department AS D ON E.Eid = D.Mid
WHERE D.location = 'Kota';
SELECT M.Mname,
	COUNT(E.Eid) AS EmployeeCount
FROM Manager AS M
	LEFT JOIN Employee AS E ON M.Mid = E.Mid
GROUP BY M.Mid,
	M.Mname
ORDER BY EmployeeCount DESC;
-- 3) Write SQL query considering below schema of database
-- Film(film_id, title, legth, rental_rate)
-- Actor(film_id, actor_id, first_name, last_name)
-- Category(film_id, rating, language, release_year)
-- i.Give the name of actors whose actor id is 23
-- ii.Give the title of films whose id is between 25 and 40
-- iii.Give the name of actor whose last name contains Kapoor
-- iv.Give the title of film which was released in 2022
-- v.Give the name of actors played who have role in film title ‘Chhello divas’
-- vi.Give the rating and count of film in each rating.
-- vii.Give the titles of film in which Ranveer played the role as an actor
-- viii.Give the total count of film for each language available in database
SELECT first_name,
	last_name
FROM Actor
WHERE actor_id = 23;
SELECT title
FROM Film
WHERE film_id BETWEEN 25 AND 40;
SELECT first_name,
	last_name
FROM Actor
WHERE last_name LIKE '%Kapoor%';
SELECT title
FROM Film
WHERE YEAR(release_year) = 2022;
SELECT A.first_name,
	A.last_name
FROM Actor AS A
	INNER JOIN Film AS F ON A.film_id = F.film_id
WHERE F.title = 'Chhello divas';
SELECT rating,
	COUNT(*) AS FilmCount
FROM Category
GROUP BY rating;
SELECT F.title
FROM Film AS F
	INNER JOIN Actor AS A ON F.film_id = A.film_id
WHERE A.first_name = 'Ranveer';
SELECT language,
	COUNT(*) AS FilmCount
FROM Category
GROUP BY language;
-- 4) Consider following schema and write query statement for given statement
-- emp (eid,ename,city,dname,salary)
-- Project(eid,pid,pname,location)
-- (1) Display ename whose dname is computer.
-- (2) Display eid whose ename start from J.
-- (3) Display all details of emp whose salary is from 10000 to 20000.
-- (4) Display ename who is having maximum salary
-- (5) Display ename whose salary is higher than average salary of the
-- employee
-- (6) Display ename whose pid is 3 and location is mumbai
SELECT ename
FROM emp
WHERE dname = 'computer';
SELECT eid
FROM emp
WHERE ename LIKE 'J%';
SELECT *
FROM emp
WHERE salary BETWEEN 10000 AND 20000;
SELECT ename
FROM emp
WHERE salary = (
		SELECT MAX(salary)
		FROM emp
	);
SELECT ename
FROM emp
WHERE salary > (
		SELECT AVG(salary)
		FROM emp
	);
SELECT E.ename
FROM emp AS E
	INNER JOIN Project AS P ON E.eid = P.eid
WHERE P.pid = 3
	AND P.location = 'mumbai';
-- 5) 
-- (A) We have following relation
-- orders(order_id,customer_id,order_date,amount)
-- 1) Find out the number of orders for each customer by customer_id.
-- 2) Find out the total amount by order_id and order_date.
-- 3) Find out the number of orders for each customer by customer_id. Show
-- only customer_id with number of orders above 5.
SELECT customer_id,
	COUNT(order_id) AS num_orders
FROM orders
GROUP BY customer_id;
SELECT order_id,
	order_date,
	SUM(amount) AS total_amount
FROM orders
GROUP BY order_id,
	order_date;
SELECT customer_id,
	COUNT(order_id) AS num_orders
FROM orders
GROUP BY customer_id
HAVING COUNT(order_id) > 5;
-- Q-5) 
-- (B) Write a query for the following.
-- employee(id,name,salary,address)
-- department(d_id,d_name,id)
-- (1) Create a view department_details of department table.
-- (2) To join two existing tables using inner join.
-- (3) To drop a view.
CREATE VIEW department_details AS
SELECT d.d_id,
	d.d_name,
	e.id,
	e.name,
	e.salary,
	e.address
FROM department d
	INNER JOIN employee e ON d.id = e.id;
SELECT e.name AS employee_name,
	d.d_name AS department_name
FROM employee e
	INNER JOIN department d ON e.id = d.id;
DROP VIEW IF EXISTS department_details;
-- 6) A) Write pl pgSQL function to increment the employee’s salary by 10% if
-- his/her department is ‘HR’ for given(inputted) employee_id
-- Schema Employee(Employee_id, first_name, last_name, department, Salary)
-- B) Write pl pgSQL function to find the number of Sunday between given
-- dates.
CREATE OR REPLACE FUNCTION increase_salary_for_hr_employee(employee_id INT) RETURNS VOID AS $$ BEGIN -- Declare variables to store the employee's current salary and department
DECLARE current_salary NUMERIC;
DECLARE emp_department VARCHAR(255);
-- Get the current salary and department for the given employee_id
SELECT salary,
	department INTO current_salary,
	emp_department
FROM Employee
WHERE Employee_id = employee_id;
-- Check if the employee's department is 'HR'
IF emp_department = 'HR' THEN -- Increment the salary by 10%
UPDATE Employee
SET Salary = current_salary * 1.1
WHERE Employee_id = employee_id;
-- Commit the transaction
COMMIT;
-- Raise a notice to indicate that the salary has been updated
RAISE NOTICE 'Salary for employee % has been increased by 10%%',
employee_id;
ELSE -- Raise a notice if the employee is not in the 'HR' department
RAISE NOTICE 'Employee % is not in the HR department. Salary remains
unchanged.',
employee_id;
END IF;
END;
$$ LANGUAGE plpgsql;
-- (B)
CREATE OR REPLACE FUNCTION count_sundays_between_dates(start_date DATE, end_date DATE) RETURNS INTEGER AS $$
DECLARE total_sundays INTEGER := 0;
current_date DATE := start_date;
BEGIN WHILE current_date <= end_date LOOP -- Check if the current day is a Sunday (day of week = 0)
IF EXTRACT(
	DOW
	FROM current_date
) = 0 THEN total_sundays := total_sundays + 1;
END IF;
-- Move to the next day
current_date := current_date + 1;
END LOOP;
RETURN total_sundays;
END;
$$ LANGUAGE plpgsql;
-- 7) Write pl pgSQL block using Explicit cursor to insert the whole tuple from film
-- table to film_pay table if amount is greater than 5$
-- Schema
-- Film (film_id, title, length, amount,rating)
-- Film_pay(film_id, title, length, amount,rating)
DO $$
DECLARE film_record film % ROWTYPE;
BEGIN -- Declare an explicit cursor for the film table
DECLARE film_cursor CURSOR FOR
SELECT *
FROM film
WHERE amount > 5;
-- Open the cursor
OPEN film_cursor;
-- Fetch and insert records from the cursor
LOOP FETCH film_cursor INTO film_record;
EXIT
WHEN NOT FOUND;
-- Insert the fetched record into the film_pay table
INSERT INTO film_pay(film_id, title, length, amount, rating)
VALUES (
		film_record.film_id,
		film_record.title,
		film_record.length,
		film_record.amount,
		film_record.rating
	);
END LOOP;
-- Close the cursor
CLOSE film_cursor;
-- Commit the transaction
COMMIT;
END $$;
-- 8) Write pl pg sql using trigger for insertion of first_name, last_name, amount
-- and payment_id into customer_backup table when deletion happens from
-- payment table considering below schema
-- Customer_backup (first_name, last_name, amount, payment_id)
-- Payment (Payment_id, Customer_id, amount)
-- Customer (Customer_id, first_name, last_name)
CREATE OR REPLACE FUNCTION payment_delete_trigger() RETURNS TRIGGER AS $$ BEGIN -- Insert the deleted data into the customer_backup table
INSERT INTO customer_backup (first_name, last_name, amount, payment_id)
SELECT C.first_name,
	C.last_name,
	OLD.amount,
	OLD.payment_id
FROM Customer AS C
	INNER JOIN Payment AS P ON C.Customer_id = P.Customer_id
WHERE P.payment_id = OLD.payment_id;
RETURN OLD;
END;
$$ LANGUAGE plpgsql;
-- Create a trigger that fires before DELETE on the Payment table
CREATE TRIGGER payment_delete_trigger BEFORE DELETE ON Payment FOR EACH ROW EXECUTE FUNCTION payment_delete_trigger();
-- 9) We are running an art gallery. We have a database with four tables paintings,
-- artists, collectors, and sales as:
-- Paintings (p_id, name, a_id, listed_price)
-- Artists (a_id, first_name, last_name)
-- Customer (c_id, first_name, last_name)
-- Sales (s_id, date, p_id, a_id, c_id, sales_price).
-- Write subqueries to retrieve the following data.
-- 1) Find the paintings that were sold in first thirteen days of month
-- August,2023.
-- 2) Display painting name and its listed price with its sales_price which is
-- sold out at a price
-- higher than the listed price to any customer.
-- 3) Retrieve details of paintings that were sold at a price is equal the listed
-- price to all customer.
-- 4) Display the name of customer who has bought at least one painting.
-- 5) Finds the total sales value for each artist.
SELECT name
FROM Paintings
WHERE p_id IN (
		SELECT p_id
		FROM Sales
		WHERE date >= '2023-08-01'
			AND date <= '2023-08-13'
	);
SELECT P.name,
	P.listed_price,
	S.sales_price
FROM Paintings AS P
	INNER JOIN Sales AS S ON P.p_id = S.p_id
WHERE S.sales_price > P.listed_price;
SELECT name,
	listed_price,
	sales_price
FROM Paintings
WHERE p_id NOT IN (
		SELECT p_id
		FROM Sales
		WHERE sales_price <> listed_price
	);
SELECT DISTINCT C.first_name,
	C.last_name
FROM Customer AS C
	INNER JOIN Sales AS S ON C.c_id = S.c_id;
SELECT A.first_name,
	A.last_name,
	SUM(S.sales_price) AS total_sales
FROM Artists AS A
	LEFT JOIN Paintings AS P ON A.a_id = P.a_id
	LEFT JOIN Sales AS S ON P.p_id = S.p_id
GROUP BY A.first_name,
	A.last_name;
-- 10) (A) Using the following schema, write SQL statement to fetch the correct
-- data.
-- Insurance_Company (c_id, c_name, city, state, policy_no, policy_name,
-- premium, id, a_id)
-- Agent (a_id, a_name, address, a_city, a_state, c_name, salary, incentive)
-- Customer (id, name, age cust_address, cust_city, cust_state, a_id,
-- policy_no)
-- 1) Display the details of customer who have taken policy from ‘Ahmedabad
-- Insurance Company’.
-- 2) Display agent name who have not sold even a single policy.
-- 3) Display the name of Insurance company who has maximum number of
-- customers.
SELECT C.id,
	C.name,
	C.age,
	C.cust_address,
	C.cust_city,
	C.cust_state
FROM Customer AS C
	INNER JOIN Insurance_Company AS IC ON C.policy_no = IC.policy_no
WHERE IC.c_name = 'Ahmedabad Insurance Company';
SELECT a_name
FROM Agent
WHERE a_id NOT IN (
		SELECT DISTINCT a_id
		FROM Customer
	);
SELECT c_name
FROM (
		SELECT IC.c_name,
			COUNT(C.id) AS customer_count
		FROM Insurance_Company AS IC
			INNER JOIN Customer AS C ON IC.policy_no = C.policy_no
		GROUP BY IC.c_name
		ORDER BY customer_count DESC
		LIMIT 1
	) AS MaxCustomerCount;
-- (B)Consider the following student relation:
-- Student (name, rollno, marks, percentage, address, dob)
-- 1)Create a view of ‘Student_info’ from relation Student with fields name,
-- rollno, percentage.
-- 2) Rename the view created, as ‘Student_Academics’
-- CREATE VIEW Student_info AS
-- SELECT name, rollno, percentage
-- FROM Student;
-- ALTER VIEW Student_info RENAME TO Student_Academics;
-- 11) Consider following schema and write SQL statements for given queries
-- without using subqueries.
-- Faculty (f_id, f_name, address, city, state, age, salary, d_id)
-- Department (dep_id, d_name, course, location, sub_code, subject)
-- Student (enrl_no, s_name, s_address, s_city, s_state, s_age, course, f_id,
-- hobby)
-- 1)Display name of faculty and student who are not living in the same city.
-- 2)Find out how much amount is spent on faculties as their salary who are
-- working in ‘IT Engineering Department’.
-- 3)Display department name, course, subject code and subject of person who
-- have enrolled as a student.
-- 4)Display id and name of faculty who are working in ‘Computer Engineering’
-- department and have a salary more than Rs. 60000.
SELECT F.f_name AS faculty_name,
	S.s_name AS student_name
FROM Faculty AS F
	JOIN Student AS S ON F.f_id = S.f_id
WHERE F.city <> S.s_city;
SELECT SUM(F.salary) AS total_salary_spent
FROM Faculty AS F
	JOIN Department AS D ON F.d_id = D.dep_id
WHERE D.d_name = 'IT Engineering Department';
SELECT D.d_name,
	S.course,
	D.sub_code,
	D.subject
FROM Student AS S
	JOIN Department AS D ON S.course = D.course;
SELECT F.f_id,
	F.f_name
FROM Faculty AS F
	JOIN Department AS D ON F.d_id = D.dep_id
WHERE D.d_name = 'Computer Engineering'
	AND F.salary > 60000;
-- 12) Prepare a PL/pgSQL block that simulates an ATM transaction system.
-- • If the withdrawal amount is less than or equal to 0, the block should
-- display an "Invalid withdrawal amount" message.
-- • If the withdrawal amount is greater than the account balance, the
-- block should display an "Insufficient funds" message.
-- • If the withdrawal amount is up to Rs. 20000, the block should perform
-- a withdrawal and deduct the amount from the account balance.
-- • If the withdrawal amount is up to Rs. 40000, the block should perform
-- a withdrawal, deduct the amount, and apply a transaction fee 5%.
-- • For withdrawal amounts greater than Rs. 40000, the block should
-- perform a withdrawal, deduct the amount, and apply a higher transaction fee
-- 18%.
-- The block should also display the current account balance after each
-- scenario.
-- 
DO $$
DECLARE account_balance NUMERIC := 100000;
-- Initialize the account balance with
an example value.withdrawal_amount NUMERIC := 0;
-- Initialize the withdrawal amount with 0.
BEGIN -- Input the withdrawal amount (you can replace this with user input).
withdrawal_amount := 30000;
-- Change the withdrawal amount as needed.
-- Check for invalid withdrawal amount.
IF withdrawal_amount <= 0 THEN RAISE NOTICE 'Invalid withdrawal amount';
RETURN;
END IF;
-- Check for insufficient funds.
IF withdrawal_amount > account_balance THEN RAISE NOTICE 'Insufficient funds';
RETURN;
END IF;
-- Perform withdrawal and deduct the amount.
account_balance := account_balance - withdrawal_amount;
-- Display the current account balance after withdrawal.
RAISE NOTICE 'Current account balance after withdrawal: Rs. %',
account_balance;
-- Apply transaction fee based on withdrawal amount.
IF withdrawal_amount <= 20000 THEN -- No transaction fee.
ELSIF withdrawal_amount <= 40000 THEN -- Apply a 5% transaction fee.
account_balance := account_balance - (withdrawal_amount * 0.05);
ELSE -- Apply a higher 18% transaction fee.
account_balance := account_balance - (withdrawal_amount * 0.18);
END IF;
-- Display the current account balance after applying the transaction fee.
RAISE NOTICE 'Current account balance after applying transaction fee: Rs.
%',
account_balance;
END;
$$ LANGUAGE plpgsql;
-- 13) Calculate the total price (numeric) of all products with a price greater than
-- Rs. 500 using a cursor from following schema: Products (p_id int, p_name
-- varchar (100), price numeric). Display all product name and price with total
-- price of products.
DO $$
DECLARE total_price NUMERIC := 0;
product_price NUMERIC;
product_name VARCHAR(100);
-- Declare a cursor to fetch products with price > Rs. 500
product_cursor CURSOR for
SELECT p_name,
	price
FROM Products
WHERE price > 500;
BEGIN -- Open the cursor
OPEN product_cursor;
-- Loop through the cursor and calculate the total price
LOOP FETCH product_cursor INTO product_name,
product_price;
EXIT
WHEN NOT FOUND;
-- Display product name and price
RAISE NOTICE 'Product: %, Price: Rs. %',
product_name,
product_price;
-- Add the product price to the total
total_price := total_price + product_price;
END LOOP;
-- Close the cursor
CLOSE product_cursor;
-- Display the total price of products with price > Rs. 500
RAISE NOTICE 'Total Price of Products with Price > Rs. 500: Rs. %',
total_price;
END;
$$ LANGUAGE plpgsql;
-- 14) Create PL/pgSQL procedure for the increment of employees where in salary
-- less than 35000 will get hike of 15% in their previous salary and other will get
-- 10% hike in their previous salary. Using following schema, Employees (id,
-- name, department, salary) call the procedure by id and print employee’s
-- name with their updated salary.
CREATE OR REPLACE PROCEDURE increment_employee_salary(employee_id INT) LANGUAGE plpgsql AS $$
DECLARE current_salary NUMERIC;
new_salary NUMERIC;
employee_name VARCHAR(255);
BEGIN -- Get the current salary and name of the employee
SELECT salary,
	name INTO current_salary,
	employee_name
FROM Employees
WHERE id = employee_id;
-- Check if the current salary is less than 35000
IF current_salary < 35000 THEN -- Apply a 15% hike
new_salary := current_salary * 1.15;
ELSE -- Apply a 10% hike
new_salary := current_salary * 1.10;
END IF;
-- Update the employee's salary in the Employees table
UPDATE Employees
SET salary = new_salary
WHERE id = employee_id;
-- Print the employee's name and updated salary
RAISE NOTICE 'Employee %: Updated Salary: Rs. %',
employee_name,
new_salary;
END;
$$;
-- Example usage: Call the procedure for an employee with ID 1
CALL increment_employee_salary(1);
-- 15) You are designing a PostgreSQL database for a library management
-- system. Each book in the library has multiple copies, and you want to
-- implement a feature that allows users to check the availability of a specific
-- book by its ISBN (International Standard Book Number).Write Pl/pgsql
-- block using stored function. If book is available then it must return 1 else
-- return 0.
-- Consider relation :
-- Books( books_isbn,book_name) 
-- Now what you will write to check availability of book having is bn no-9780451524935
CREATE OR REPLACE FUNCTION check_book_availability(isbn VARCHAR(13)) RETURNS INTEGER AS $$
DECLARE available_count INTEGER;
BEGIN -- Count the number of available copies of the book with the given ISBN
SELECT COUNT(*) INTO available_count
FROM Books
WHERE books_isbn = isbn;
-- If there are available copies, return 1; otherwise, return 0
IF available_count > 0 THEN RETURN 1;
ELSE RETURN 0;
END IF;
END;
$$ LANGUAGE plpgsql;
SELECT check_book_availability('9780451524935');
-- 16) You are responsible for maintaining a PostgreSQL database for a shipping
-- company.Write a Pl/pgsql Stored Procedure to insert data in
-- status_logs.Let name of Procedure be ‘update_shipment_status’
-- Consider relation:
-- status_logs(shipment_id, new_status, update_time)
-- Insert below data with the help of Procedure you created
-- shipment_id=123,new_status=delivered,update_time=2023-09-15 10:30:00.
CREATE OR REPLACE PROCEDURE update_shipment_status(
		shipment_id INT,
		new_status VARCHAR(255),
		update_time TIMESTAMP
	) LANGUAGE plpgsql AS $$ BEGIN -- Insert data into the status_logs table
INSERT INTO status_logs(shipment_id, new_status, update_time)
VALUES (shipment_id, new_status, update_time);
-- Commit the transaction
COMMIT;
END;
$$;
CALL update_shipment_status(123, 'delivered', '2023-09-15 10:30:00');
-- 17)
-- (A) Write PL/pgSQL program that calculates the factorial of a number=5
-- using a loop.
DO $$
DECLARE num INT := 5;
-- Change this to the desired number
factorial INT := 1;
i INT;
BEGIN IF num < 0 THEN RAISE 'Factorial is not defined for negative numbers';
END IF;
FOR i IN 1..num LOOP factorial := factorial * i;
END LOOP;
RAISE NOTICE 'Factorial of % is %',
num,
factorial;
END;
$$ LANGUAGE plpgsql;
-- (B) Write PL/pgSQL program to calculate the sum of first 100 even numbers
DO $$
DECLARE count INT := 0;
sum_even INT := 0;
num INT := 2;
-- Start with the first even number
BEGIN WHILE count < 100 LOOP sum_even := sum_even + num;
num := num + 2;
-- Move to the next even number
count := count + 1;
END LOOP;
RAISE NOTICE 'Sum of the first 100 even numbers: %',
sum_even;
END;
$$ LANGUAGE plpgsql;
-- 18) Write a PL/SQL block using an explicit cursor that will transfer the record of
-- account no, customer name and balance from the “account” table to the
-- “branch_surat” table if the branch name is surat in the “account” table.
-- Furthermore, delete the record from the “account” table whichever record
-- transfers to the “branch_surat” table.
-- Use the following tables:
-- account (ano, customer_name, balance, branch_name)
-- branch_surat (ano, customer_name, balance)
DO $$
DECLARE -- Declare variables to hold account details
	v_ano account.ano % TYPE;
v_customer_name account.customer_name % TYPE;
v_balance account.balance % TYPE;
-- Declare a cursor
cur_account CURSOR FOR
SELECT ano,
	customer_name,
	balance
FROM account
WHERE branch_name = 'surat';
BEGIN -- Open the cursor
OPEN cur_account;
-- Start the loop
LOOP -- Fetch the next record
FETCH cur_account INTO v_ano,
v_customer_name,
v_balance;
-- Exit the loop if there are no more records
EXIT
WHEN NOT FOUND;
-- Insert the record into branch_surat table
INSERT INTO branch_surat (ano, customer_name, balance)
VALUES (v_ano, v_customer_name, v_balance);
-- Delete the record from the account table
DELETE FROM account
WHERE ano = v_ano;
END LOOP;
-- Close the cursor
CLOSE cur_account;
-- Commit the changes
COMMIT;
RAISE NOTICE 'Records transferred successfully.';
END $$;
-- 19) In PostgreSQL, create a PL/SQL block that defines a function named
-- calculate_salary_bonus which takes two parameters: employee_id and
-- bonus_percentage. This function should calculate the bonus amount for the
-- employee with the given employee_id based on their current salary and the
-- provided bonus percentage. Assume “employee” table with fields – eid,
-- ename and salary.
CREATE OR REPLACE FUNCTION calculate_salary_bonus(
		IN employee_id INT,
		IN bonus_percentage NUMERIC
	) RETURNS NUMERIC AS $$
DECLARE v_salary NUMERIC;
v_bonus_amount NUMERIC;
BEGIN -- Get the current salary of the employee with the provided employee_id
SELECT salary INTO v_salary
FROM employee
WHERE eid = employee_id;
-- Calculate the bonus amount based on the salary and bonus_percentage
v_bonus_amount := v_salary * (bonus_percentage / 100);
-- Return the bonus amount
RETURN v_bonus_amount;
END;
$$ LANGUAGE plpgsql;
-- 20) In PostgreSQL, create a PL/SQL block that defines a procedure named
-- update_employee_salary which takes two parameters: employee_id and
-- new_salary. This procedure should update the salary of the employee with
-- the given employee_id to the new salary value. Assume “employee” table
-- with fields – eid, ename and salary.
CREATE OR REPLACE PROCEDURE update_employee_salary(IN employee_id INT, IN new_salary DECIMAL) LANGUAGE plpgsql AS $$ BEGIN -- Update the salary of the employee with the provided employee_id
UPDATE employee
SET salary = new_salary
WHERE eid = employee_id;
END;
$$;
-- 21) Consider following schema and write SQL for given statements.
-- title (id,designation,DOJ)
-- bonus(id,bonus_date,amount)
-- 1)Retrieve the employees who haven't received any bonuses
-- 2)Retrieve the total bonus amount received by each employee:
-- 3)Retrieve the highest bonus amount received:
-- 4)List out id's whose bonus amount at most 4000 and designation is admin
--1
SELECT t.id,
	t.designation,
	t.DOJ
FROM title t
	LEFT JOIN bonus b ON t.id = b.id
WHERE b.id IS NULL;
--2
SELECT t.id,
	t.designation,
	SUM(b.amount) AS total_bonus_amount
FROM title t
	LEFT JOIN bonus b ON t.id = b.id
GROUP BY t.id,
	t.designation;
--3
SELECT MAX(amount) AS highest_bonus_amount
FROM bonus;
--4
SELECT t.id
FROM title t
	LEFT JOIN bonus b ON t.id = b.id
WHERE b.amount <= 4000
	AND t.designation = 'admin';
-- 22) Consider following schema and write SQL for given statements.
-- Student (RollNo, Name, DeptCode, City)
-- Department (DeptCode, DeptName)
-- Result (RollNo, Semester, SPI)
-- 1)Retrieve all students' names and their respective department names:
-- 2)Retrieve the average SPI (Semester Performance Index) for each student:
-- 3)Retrieve the students who have the highest SPI in a “desired_semester”
-- 4)Retrieve the students who belong to a “specific_city” and their department
-- names:
--1
SELECT s.Name,
	d.DeptName
FROM Student s
	INNER JOIN Department d ON s.DeptCode = d.DeptCode;
--2
SELECT RollNo,
	AVG(SPI) AS Average_SPI
FROM Result
GROUP BY RollNo;
--3
SELECT s.Name,
	d.DeptName,
	r.Semester,
	r.SPI
FROM Result r
	JOIN Student s ON r.RollNo = s.RollNo
	JOIN Department d ON s.DeptCode = d.DeptCode
WHERE r.Semester = 'desired_semester'
	AND r.SPI = (
		SELECT MAX(SPI)
		FROM Result
		WHERE Semester = 'desired_semester'
	);
--4
SELECT s.Name,
	d.DeptName
FROM Student s
	INNER JOIN Department d ON s.DeptCode = d.DeptCode
WHERE s.City = 'specific_city';
-- 23) we have following relations:
-- Supplier(S#,sname,status,city)
-- Parts(P#,pname,color,weight,city)
-- SP(S#,P#,quantity)
-- Answer the following queries.
-- (1) Find s# of supplier who supplies ‘GREEN’ part.
-- (2) Count number of supplier who supplies ‘red’ part.
-- (3) Sort the supplier table by sname?
-- (4) List suppliers who supply parts to more than one city.
--1
SELECT DISTINCT S #
FROM SP
WHERE P # IN (
SELECT P #
FROM Parts
WHERE color = 'GREEN'
);
--2
SELECT COUNT(
		DISTINCT S #)
		FROM SP
		WHERE P # IN (
		SELECT P #
		FROM Parts
		WHERE color = 'red'
	);
--3
SELECT *
FROM Supplier
ORDER BY sname;
--4
SELECT S #
FROM SP
GROUP BY S #
HAVING COUNT(DISTINCT city) > 1;
-- 24)
-- Find the sum of a user-inserted number's first and last digits using PLSQL
-- function.
-- Create or replace the PL/pgSQL function
CREATE OR REPLACE FUNCTION sum_of_digits(
		p_num INT -- Input parameter: the number for which to calculate the sum
	) RETURNS INT AS $$
DECLARE v INT;
-- Temporary variable to hold the absolute value of the input number
l INT;
-- Variable to store the last digit
f INT;
-- Variable to store the first digit
m INT := 1;
-- Multiplier to find the first digit
BEGIN -- Check if the input number is negative and take its absolute value
IF p_num < 0 THEN v := - p_num;
ELSE v := p_num;
END IF;
-- Extract the last digit
l := v % 10;
-- Find the multiplier to extract the first digit
WHILE v >= 10 LOOP v := v / 10;
-- Divide by 10 to move to the next digit
m := m * 10;
-- Multiply the multiplier by 10
END LOOP;
-- Extract the first digit
f := TRUNC(p_num / m);
-- Calculate and return the sum of the first and last digits
RETURN f + l;
END;
$$ LANGUAGE plpgsql;
-- 25) A stored function is created to perform the acct_no check operation.
-- f_ChkAcctNo () is the name of function which accepts a variable acct_no from
-- the user and returns value 0 if acct_no does not exist or 1 if acct_no exists.
-- Assume account table with fields: account_number, name, type and balance.
CREATE OR REPLACE FUNCTION f_ChkAcctNo(p_acct_no INT) RETURNS INT AS $$
DECLARE v_count INT;
BEGIN -- Check if the account number exists in the account table
SELECT COUNT(*) INTO v_count
FROM account
WHERE account_number = p_acct_no;
-- Return 1 if the account number exists, 0 if it doesn't
IF v_count > 0 THEN RETURN 1;
ELSE RETURN 0;
END IF;
END;
$$ LANGUAGE plpgsql;
-- 26) Write a Stored procedure to Insert Data in Departments (dept_id, dept_name,
-- balance) and transactions (transaction_id, from_dept_id, to_dept_id, amount,
-- transaction_date) table.
-- Create the Departments table if it doesn't exist
CREATE TABLE IF NOT EXISTS Departments (
	dept_id INT PRIMARY KEY,
	dept_name VARCHAR(255),
	balance DECIMAL(10, 2)
);
-- Create the Transactions table if it doesn't exist
CREATE TABLE IF NOT EXISTS Transactions (
	transaction_id INT PRIMARY KEY,
	from_dept_id INT,
	to_dept_id INT,
	amount DECIMAL(10, 2),
	transaction_date DATE
);
-- Create the stored procedure to insert data into both tables
CREATE OR REPLACE PROCEDURE InsertData(
		p_dept_id INT,
		p_dept_name VARCHAR(255),
		p_balance DECIMAL(10, 2),
		p_transaction_id INT,
		p_from_dept_id INT,
		p_to_dept_id INT,
		p_amount DECIMAL(10, 2),
		p_transaction_date DATE
	) AS $$ BEGIN -- Insert data into the Departments table
INSERT INTO Departments (dept_id, dept_name, balance)
VALUES (p_dept_id, p_dept_name, p_balance);
-- Insert data into the Transactions table
INSERT INTO Transactions (
		transaction_id,
		from_dept_id,
		to_dept_id,
		amount,
		transaction_date
	)
VALUES (
		p_transaction_id,
		p_from_dept_id,
		p_to_dept_id,
		p_amount,
		p_transaction_date
	);
-- Commit the transaction
COMMIT;
END;
$$ LANGUAGE plpgsql;
-- 27) An expression below creates a procedure emp_infor that accept two parameters,
-- employeeno and job_title, then pass them to explicit cursor named emp_list to
-- retrieve the firstname, lastname, hiredate, job_id and salary, of all employees
-- earning a salary less that 11000 and have an “O” as the second letter in the
-- lastname. Create an anonymous block that will call the procedure to display the
-- details of employee as per entry of job_title and employeeno parameters. Use this
-- table Employee (employeeno, firstname, lastname, hiredate, job_id ,salary,
-- job_title).
-- Create the procedure emp_infor
CREATE OR REPLACE PROCEDURE emp_infor(
		p_employeeno INT,
		p_job_title VARCHAR
	) AS $$
DECLARE v_firstname TEXT;
v_lastname TEXT;
v_hiredate DATE;
v_job_id VARCHAR;
v_salary NUMERIC;
CURSOR emp_list(p_employeeno INT, p_job_title VARCHAR) IS
SELECT firstname,
	lastname,
	hiredate,
	job_id,
	salary
FROM Employee
WHERE salary < 11000
	AND SUBSTRING(
		lastname
		FROM 2 FOR 1
	) = 'O'
	AND (
		p_employeeno IS NULL
		OR employeeno = p_employeeno
	)
	AND (
		p_job_title IS NULL
		OR job_title = p_job_title
	);
BEGIN -- Open the cursor
OPEN emp_list(p_employeeno, p_job_title);
-- Loop through the cursor and display employee details
LOOP FETCH emp_list INTO v_firstname,
v_lastname,
v_hiredate,
v_job_id,
v_salary;
EXIT
WHEN NOT FOUND;
RAISE NOTICE 'Employee: % %',
v_firstname,
v_lastname;
RAISE NOTICE 'Hire Date: %',
TO_CHAR(v_hiredate, 'DD-MON-YYYY');
RAISE NOTICE 'Job ID: %',
v_job_id;
RAISE NOTICE 'Salary: %',
v_salary;
RAISE NOTICE '------------------------';
END LOOP;
-- Close the cursor
CLOSE emp_list;
END;
$$ LANGUAGE plpgsql;
-- Create an anonymous block to call the procedure
DO $$ BEGIN -- Call the emp_infor procedure with parameters
emp_infor(123, 'Manager');
-- Replace 123 and 'Manager' with desired employee number and job title
END;
$$;
