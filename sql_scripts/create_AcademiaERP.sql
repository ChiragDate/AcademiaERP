CREATE TABLE employees (
    employee_id BIGINT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(50),
    title VARCHAR(50)
);

CREATE TABLE employee_salary (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    payment_date DATE,
    amount DECIMAL(10, 2),
    description VARCHAR(255)
);
