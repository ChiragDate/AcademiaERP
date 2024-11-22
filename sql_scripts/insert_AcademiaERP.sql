INSERT INTO Departments (name, capacity)
VALUES
    ('Computer Science', 120),
    ('Information Technology', 100),
    ('Electronics and Communication Engineering', 80),
    ('Digital Society', 50);

INSERT INTO Employees (first_name, last_name, email, title, department)
VALUES
    ('Alice', 'Johnson', 'alice.johnson@example.com', 'Professor', 1),
    ('Bob', 'Smith', 'bob.smith@example.com', 'Lecturer', 2),
    ('Charlie', 'Brown', 'charlie.brown@example.com', 'Associate Professor', 3),
    ('Diana', 'Taylor', 'diana.taylor@example.com', 'Professor', 4);


INSERT INTO Employee_salary (employee_id, payment_date, amount, description)
VALUES
    (1, '2024-11-01', 75000.00, 'Monthly salary for October'),
    (2, '2024-11-01', 65000.00, 'Monthly salary for October'),
    (3, '2024-11-01', 70000.00, 'Monthly salary for October'),
    (4, '2024-11-01', 80000.00, 'Monthly salary for October');
