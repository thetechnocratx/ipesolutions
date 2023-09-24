-- 1). Write a PL/SQL block to swap two numbers without using third variable.

	do $$
	declare
	x int:=10;
	y int:=20;
	begin
	x=x+y;
	y=x-y;
	x=x-y;
	Raise Notice 'x is % and y is % after swapping',x,y;
	end; 
	$$


-- 2).Consider following relations:
-- Employee(empno, emp_name, dept,salary, doj, branch)
-- Answer the following queries in SQL:
-- 1) Retrieve employee number and their salary
-- 2) Retrieve total salary of employee group by employee name and count similar names
-- 3) Retrieve total salary of employee group by employee name and salary which is greater than 
-- >120000
-- 4) Display name of employee in descending order
-- 5) Display details of employee whose name is AMIT and salary greater than 50000; 

	-- Ans (1)
     SELECT empno, salary FROM Employee;
     -- Ans (2)
	 SELECT emp_name, SUM(salary), COUNT(emp_name) FROM Employee GROUP BY emp_name;
    -- Ans (3)
	SELECT emp_name, SUM(salary) FROM Employee WHERE salary > 120000 GROUP BY emp_name;
    -- Ans (4)
	 SELECT emp_name FROM Employee ORDER BY emp_name DESC;
    -- Ans (5)
	SELECT * FROM Employee WHERE emp_name = 'AMIT' AND salary > 50000;
    

-- 3).Given the table EMPLOYEE (EmpNo, Name, Salary, Designation, DeptID) write a cursor to select 
-- the five highest paid employees from the table.
-- EMPLOYEE (EmpNo, Name, Salary, Designation, DeptID)




DO $$
DECLARE
 emp_id EMPLOYEE.EmpNo%TYPE;
 emp_name EMPLOYEE.Name%TYPE;
 emp_salary EMPLOYEE.Salary%TYPE;
 emp_designation EMPLOYEE.Designation%TYPE;
 emp_dept_id EMPLOYEE.DeptID%TYPE;
 CURSOR cursur_h IS
 SELECT EmpNo, Name, Salary, Designation, DeptID
 FROM EMPLOYEE
 ORDER BY Salary DESC
 LIMIT 5;
BEGIN
 OPEN cursur_h;
 RAISE NOTICE 'Top 5 Highest Paid Employees:';
 LOOP
 FETCH cursur_h INTO emp_id, emp_name, emp_salary, emp_designation, 
emp_dept_id;
 EXIT WHEN cursur_h%NOTFOUND;
 RAISE NOTICE 'EmpNo: %, Name: %, Salary: %, Designation: %, DeptID: %', emp_id, 
emp_name, emp_salary, emp_designation, emp_dept_id;
 END LOOP;
 CLOSE cursur_h;
END $$;





-- 4).Write PL/SQL block to print whether the given number is Armstrong number or not. If given number 
-- is Armstrong then insert that number into Armstrong table.

	do $$
	declare
	a int :=153; sum int :=0; d int; temp int;
	begin
	temp :=a;
	while temp <> 0 loop
	d := mod (temp,10);
	sum := sum + (d*d*d);
	temp:= (temp/10);
	end loop;
	if sum = a then
	insert into Armstrong_table(Armstrong_number) values (sum);
	raise notice 'armstrong number';
	raise notice 'number inserted in Armstrong table'
	else
	raise notice 'not armstrong number';
	end if;
	end;
	$$


-- 5).Write a PL/SQL cursor to display the names and branch of all students from the STUDENT relation.

	do $$
	declare
	c1_name std.name%type;
	c2_branch std.branch%type;
	s_cursor cursor for select name,branch from std;
	begin
	open s_cursor;
	loop
	fetch s_cursor into c1_name,c2_branch;
	exit when not found;
	raise notice 'name:%,branch: %',c1_name,c2_branch;
	end loop;
	close s_cursor;
	end;
	$$

-- 6).Consider following relations:
-- Supplier(sid,sname,status,city)
-- Parts(pid,pname,color,weight,city)
-- Sp(sid,pid,quantity)
-- Answer the following queries:
-- 1) Display the name of supplier who lives in ‘Ahmedabad’
-- 2) Display the parts name which is not supplied yet
-- 3) Find all supplier whose status is either 20 or 30
-- 4) Count how many times each supplier has supplied part ‘P2’
-- 5) Delete a part from parts whose weight is more than 10kg

	-- (1).
    SELECT sname FROM Supplier WHERE city = 'Ahmedabad';
	-- (2).
    SELECT pname FROM Parts WHERE pid NOT IN (SELECT pid FROM Sp);
	-- (3).
    SELECT sname FROM Supplier WHERE status IN (20, 30);
	-- (4).
    SELECT sid, COUNT(*) FROM Sp WHERE pid = 'P2' GROUP BY sid;
	-- (5).
    DELETE FROM Parts WHERE weight > 10;


-- 7). Consider following relations:
-- employee(eid, name, address, dept, salary)
-- Answer the following queries:
-- 1) Display the name and salary of employee who is taking maximum salary.
-- 2) Display the name of employee who works in department having count of employee is less 
-- than 2.
-- 3) Display highest salary department wise and name of employee who is taking that salary.
-- 4) Display second highest salary from employee table
-- 5) Display the details of employee whose name starts with ‘A’ .

	-- (1).
    SELECT name, salary FROM employee WHERE salary = (SELECT MAX(salary) FROM employee);
	-- (2).
    SELECT name FROM employee WHERE dept IN (SELECT dept FROM employee GROUP BY dept HAVING COUNT(*) < 2);
	-- (3).
    SELECT dept, MAX(salary) AS highest_salary, FIRST_VALUE(name) OVER (PARTITION BY dept ORDER BY salary DESC) AS employee_with_highest_salary FROM employee GROUP BY dept;
	-- (4).
    SELECT MAX(salary) FROM employee WHERE salary < (SELECT MAX(salary) FROM employee);
	-- (5).
    SELECT * FROM employee WHERE name LIKE 'A%';

-- 8).Write PL/SQL program to convert each digit of a given number into its corresponding word format.

CREATE OR REPLACE FUNCTION number_to_words(num INT)
RETURNS TEXT AS
$$
DECLARE
    word TEXT := '';
    digit_map TEXT[] := ARRAY['Zero', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine'];
BEGIN
    IF num IS NULL THEN
        RETURN 'Invalid input';
    END IF;
    
    IF num = 0 THEN
        RETURN 'Zero';
    END IF;

    WHILE num > 0 LOOP
        word := digit_map[num % 10] || ' ' || word;
        num := num / 10;
    END LOOP;

    RETURN TRIM(word);
END;
$$ LANGUAGE plpgsql;




-- 9). Write PL/SQL program to find the sum of digits of a number.

	do $$
	declare
	a int :=123;
	sum int := 0;
	digit int;
	begin
	while a <> 0 loop
	digit = mod (a,10);
	sum = sum + digit;
	a := (a/10);
	end loop;
	raise notice 'ans:%',sum;
	end; $$


-- 10).Consider the following Tables and Write PL/SQL program to Transfer All the
-- Students having marks greater than 70 from ‘Student’ table into another table named ‘star_batch’ using 
-- Explicit Cursor.
-- Student(id,name,mobile,marks,dob)
-- Star_batch(id,name,mobile,marks,dob)

	DO $$
	DECLARE 
	    cur CURSOR FOR SELECT * FROM Student WHERE marks > 70; 
	    star cur%ROWTYPE; 
	BEGIN 
	    OPEN cur; 
	    LOOP
	        FETCH cur INTO star; 
	        EXIT WHEN NOT FOUND; 
	        INSERT INTO Star_batch VALUES star; 
	    END LOOP; 
	    CLOSE cur;  
	END;
	$$


-- Que 11

-- Consider the following schema & create table for that:
-- BOOK (Book_id, Title, Publisher_Name, Pub_Year)
-- BOOK_AUTHORS (Book_id, Author_Name)
-- PUBLISHER (Name, Address, Phone)
-- BOOK_COPIES(Book_id, Branch_id, No-of_Copies)
-- BOOK_LENDING (Book_id, Branch_id, Card_No, Date_Out, Due_Date)
-- LIBRARY_BRANCH (Branch_id, Branch_Name, Address)
-- Write SQL queries to
-- 1) Describe all the tables
-- 2) Insert the details in all the tables
-- 3) Retrieve details of all books in the library – id, title, name of publisher, authors
-- 4) Delete a book in BOOK table whose book_id is 50 .
-- 5) Get the particulars of borrowers who have borrowed more than 3 books, but
-- 6) from Jan 2017 to Jun2017.

--Table Creation 
CREATE TABLE BOOK (
 Book_id SERIAL PRIMARY KEY,
 Title VARCHAR(255) NOT NULL,
 Publisher_Name VARCHAR(255),
 Pub_Year INTEGER
);
CREATE TABLE BOOK_AUTHORS (
 Book_id INT,
 Author_Name VARCHAR(255) NOT NULL,
 FOREIGN KEY (Book_id) REFERENCES BOOK(Book_id)
);
CREATE TABLE PUBLISHER (
 Name VARCHAR(255) PRIMARY KEY,
 Address VARCHAR(255),
 Phone VARCHAR(20)
);
CREATE TABLE BOOK_COPIES (
 Book_id INT,
 Branch_id INT,
 No_of_Copies INTEGER,
 FOREIGN KEY (Book_id) REFERENCES BOOK(Book_id),
 FOREIGN KEY (Branch_id) REFERENCES LIBRARY_BRANCH(Branch_id)
);
CREATE TABLE BOOK_LENDING (
 Book_id INT,
 Branch_id INT,
 Card_No INT,
 Date_Out DATE,
 Due_Date DATE,
 FOREIGN KEY (Book_id) REFERENCES BOOK(Book_id),
 FOREIGN KEY (Branch_id) REFERENCES LIBRARY_BRANCH(Branch_id)
);
CREATE TABLE LIBRARY_BRANCH (
 Branch_id SERIAL PRIMARY KEY,
 Branch_Name VARCHAR(255) NOT NULL,
 Address VARCHAR(255));
-- 1 
DESCRIBE BOOK;
DESCRIBE BOOK_AUTHORS;
DESCRIBE PUBLISHER;
DESCRIBE BOOK_COPIES;
DESCRIBE BOOK_LENDING;
DESCRIBE LIBRARY_BRANCH;

2-- Insert data into the BOOK table
INSERT INTO BOOK (Book_id, Title, Publisher_Name, Pub_Year)
VALUES (1, 'Book Title 1', 'Publisher 1', 2022);

-- Insert data into the BOOK_AUTHORS table
INSERT INTO BOOK_AUTHORS (Book_id, Author_Name)
VALUES (1, 'Author Name 1');

-- Insert data into the PUBLISHER table
INSERT INTO PUBLISHER (Name, Address, Phone)
VALUES ('Publisher 1', 'Publisher Address 1', '123-456-7890');

-- Insert data into the BOOK_COPIES table
INSERT INTO BOOK_COPIES (Book_id, Branch_id, No_of_Copies)
VALUES (1, 101, 10);

-- Insert data into the BOOK_LENDING table
INSERT INTO BOOK_LENDING (Book_id, Branch_id, Card_No, Date_Out, Due_Date)
VALUES (1, 101, 1001, '2022-09-01', '2022-09-15');

-- Insert data into the LIBRARY_BRANCH table
INSERT INTO LIBRARY_BRANCH (Branch_id, Branch_Name, Address)
VALUES (101, 'Branch Name 1', 'Branch Address 1');

-- 3
 SELECT B.Book_id, B.Title, B.Publisher_Name, BA.Author_Name FROM BOOK B
INNER JOIN BOOK_AUTHORS BA ON B.Book_id = BA.Book_id;
-- 4 
DELETE FROM BOOK WHERE Book_id = 50;
-- 5-6 
SELECT BL.Card_No, COUNT(BL.Book_id) AS Books_Borrowed
FROM BOOK_LENDING BL
WHERE BL.Date_Out BETWEEN '2017-01-01' AND '2017-06-30'
GROUP BY BL.Card_No
HAVING COUNT(BL.Book_id) > 3;





-- 12).Consider the following schema & create table for that:
-- Physician(regno,name,phone_no,city)
-- Patient(pname, street,city)
-- Visit(pname,regno,visitdate,fee)
-- Answer the following queries:
-- 1) Get the name and regno of the physicians who lives in Mumbai
-- 2) Find the name and city of the patient who visited physician on 01-aug-2022
-- 3) Get the name of physician and total no of patients who visited that physician
-- 4) Get the name of physician who have not visited any patient

	create table Physician(regno int, name varchar(20), phone_no int ,city varchar(20));
	create table Patient(pname varchar(20), street varchar(20), city varchar(20));
	create table Visit(pname varchar(20), regno int, visitdate date, fee int);

	-- (1). 
    SELECT name, regno FROM Physician WHERE city = 'Mumbai';
	-- (2).
     select pname,city from Patient inner join Visit on Patient.pname=Visit.pname where visitdate='01-aug-2022';
	-- (3).
     select name, count(pname) from Physician inner join Visit on Physician.regno=Visit.regno;
	-- (4).
    SELECT name FROM Physician WHERE regno NOT IN (SELECT regno FROM Visit);



-- 13).Write queries for the following tables:
-- T1 ( Empno, Ename , Salary, Designation) 
-- T2 (Empno, Deptno.) 
-- (1) Display all the details of the employee whose salary is lesser than 10K.
-- (2) Display the Deptno in which Employee Seeta is working.
-- (3) Add a new column Deptname in table T2.
-- (4) Change the designation of Geeta from ‘Manager’ to ‘Senior Manager’(5) Find the total salary of all the employees. 
-- (6) Display Empno, Ename, Deptno and Deptname.

	-- (1).
    SELECT * FROM T1 WHERE Salary < 10000;
	-- (2).
    select Depyno. from T2 inner join T1 on T2.Empno=T1.Empno where Wname='Seeta';
	-- (3).
    ALTER TABLE T2 ADD Deptname VARCHAR(255);
	-- (4).
    UPDATE T1 SET Designation = 'Senior Manager' WHERE Ename = 'Geeta' AND Designation = 'Manager';
	-- (5).
    SELECT SUM(Salary) as Total_Salary FROM T1;
	-- (6).
    select Empno, Ename, Deptno, Deptname from T1 inner join T2 on T1.Empno=T2.Empno;



-- 14).Consider the relation Database.
-- Person(SSN, name, city)
-- Car(license_no, year, model, SSN)
-- Accident(drive_no, SSN, license_no, accidentyear, damage_amt)
-- 1) Find out total no of cars that has accident in 1988.
-- 2) Find the name of driver who did not have an accident in 'Delhi'
-- 3) Find the car, who don't have total damage of more than 1000rs.
-- 4) Find the cars sold in 2006 and whose owner are from vadodara.
-- 5) How many different models of car are used by Mr.abc.

	-- (1).
    SELECT COUNT(DISTINCT license_no) FROM Accident WHERE accidentyear = 1988;
	-- (2).
    select name from Person inner join Accident on Person.SSN=Accident.SSN where city <> 'Delhi';
	-- (3).
    select liscence_no from Accident where damage_amt <=1000;
	-- (4). 
    SELECT license_no FROM Car INNER JOIN Person ON Car.SSN = Person.SSN WHERE year = 2006 AND city = 'Vadodara';
	-- (5).
    SELECT COUNT(DISTINCT model) FROM Car INNER JOIN Person ON Car.SSN = Person.SSN WHERE name = 'Mr.abc';



-- 15).Write a PL/SQL cursor to display the names and branch of all students from the STUDENT relation.

	do $$
	declare
	c1_name std.name%type;
	c2_branch std.branch%type;
	s_cursor cursor for select name,branch from std;
	begin
	open s_cursor;
	loop
	fetch s_cursor into c1_name,c2_branch;
	exit when not found;
	raise notice 'name:%,branch: %',c1_name,c2_branch;
	end loop;
	close s_cursor;
	end;
	$$


-- 16. Write a PL/SQL block to print the given number is prime or not


DO $$ 
DECLARE
    num_to_check INT := 17; -- Change this to the number you want to check
    is_prime BOOLEAN := TRUE;
    i INT := 2;
BEGIN
    IF num_to_check <= 1 THEN
        is_prime := FALSE;
    ELSE
        WHILE i <= sqrt(num_to_check) LOOP
            IF num_to_check % i = 0 THEN
                is_prime := FALSE;
                EXIT; -- Exit the loop early if a divisor is found
            END IF;
            i := i + 1;
        END LOOP;
    END IF;

    IF is_prime THEN
        RAISE NOTICE '% is a prime number.', num_to_check;
    ELSE
        RAISE NOTICE '% is not a prime number.', num_to_check;
    END IF;
END $$;


-- 17 Write a function that take employee no and return the salary with the help of following 
-- table: Emp(eno,ename,city,salary)
CREATE OR REPLACE FUNCTION get_employee_salary(eno INT)
RETURNS INTEGER AS
$$
DECLARE
    emp_salary INTEGER;
BEGIN
    SELECT salary INTO emp_salary
    FROM Emp
    WHERE eno = get_employee_salary.eno;
    
    RETURN emp_salary;
END;
$$
LANGUAGE plpgsql;





-- 18 Write a procedure to display multiplication table of user input. 


CREATE OR REPLACE PROCEDURE display_multiplication_table(IN num INT)
LANGUAGE plpgsql
AS $$
DECLARE
    i INT := 1;
BEGIN
    IF num IS NULL OR num <= 0 THEN
        RAISE EXCEPTION 'Input number must be a positive integer.';
    END IF;

    RAISE NOTICE 'Multiplication table for %:', num;
    
    WHILE i <= 10 LOOP
        RAISE NOTICE '% x % = %', num, i, num * i;
        i := i + 1;
    END LOOP;
END;
$$;

-- 19 Write a trigger to check the pincode is exactly six digits or not for the following table: 
-- Emp(eno,ename,city,pincode)

-- Create a trigger function to check the pincode
CREATE OR REPLACE FUNCTION check_pincode()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.pincode IS NOT NULL AND LENGTH(NEW.pincode::TEXT) <> 6 THEN
        RAISE EXCEPTION 'Pincode must contain exactly six digits.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create a trigger to call the trigger function before INSERT or UPDATE
CREATE TRIGGER pincode_check_trigger
BEFORE INSERT OR UPDATE ON Emp
FOR EACH ROW
EXECUTE FUNCTION check_pincode();



-- 20 Write a cursor to display the first ten records of the following table: 
-- Student(rollno,name,address,city


-- Declare a variable for student record
DECLARE
    student_record Student%ROWTYPE;
BEGIN
    -- Loop through the first ten records in the Student table
    FOR student_record IN (SELECT rollno, name, address, city FROM Student LIMIT 10)
    LOOP
        -- Display student information (you can perform any action here)
        RAISE NOTICE 'RollNo: %, Name: %, Address: %, City: %',
            student_record.rollno, student_record.name,
            student_record.address, student_record.city;
    END LOOP;
END;




