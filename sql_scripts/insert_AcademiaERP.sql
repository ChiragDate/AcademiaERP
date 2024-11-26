-- INSERT INTO Departments (name, capacity)
-- VALUES
--     ('Computer Science', 120),
--     ('Information Technology', 100),
--     ('Electronics and Communication Engineering', 80),
--     ('Digital Society', 50);

-- Dummy Data for Employees Table
INSERT INTO employees (employee_Id, first_name, last_name, email, password, department, title, photographPath) VALUES
(1, 'John', 'Doe', 'john.doe@example.com', 'password123', 'Admin', 'Admin', '/photos/john_doe.jpg'),
(2, 'Jane', 'Smith', 'jane.smith@example.com', 'password456', 'Information Technology', 'Hardware Engineer', '/photos/jane_smith.jpg'),
(3, 'Alice', 'Johnson', 'alice.johnson@example.com', 'password789', 3, 'Assistant Professor', '/photos/alice_johnson.jpg'),
(4, 'Bob', 'Williams', 'bob.williams@example.com', 'password101', 4, 'AI Researcher', '/photos/bob_williams.jpg'),
(5, 'Charlie', 'Brown', 'charlie.brown@example.com', 'password202', 'Computer Science', 'Backend Developer', '/photos/charlie_brown.jpg');

-- Mapping Departments to IDs:
-- 1 = CSE
-- 2 = ECE
-- 3 = Digital Society
-- 4 = DSAI

INSERT INTO employees_salary (id, employee_Id, payment_date, amount, description) VALUES
(1, 1, '2024-10-01', 75000.00, 'Monthly Salary'),
(2, 2, '2024-10-01', 65000.00, 'Monthly Salary'),
(3, 3, '2024-10-01', 85000.00, 'Monthly Salary'),
(4, 4, '2024-10-01', 90000.00, 'Monthly Salary'),
(5, 5, '2024-10-01', 70000.00, 'Monthly Salary'),
(6, 1, '2024-11-01', 75000.00, 'Monthly Salary'),
(7, 2, '2024-11-01', 65000.00, 'Monthly Salary'),
(8, 3, '2024-11-01', 85000.00, 'Monthly Salary'),
(9, 4, '2024-11-01', 90000.00, 'Monthly Salary'),
(10, 5, '2024-11-01', 70000.00, 'Monthly Salary');