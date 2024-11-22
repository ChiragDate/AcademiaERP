CREATE TABLE Departments (
                             department_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             name VARCHAR(255) NOT NULL,
                             capacity INT NOT NULL
);
CREATE TABLE Employees (
                           employee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           first_name VARCHAR(50),
                           last_name VARCHAR(50),
                           email VARCHAR(100) UNIQUE NOT NULL,
                           department BIGINT,
                           title VARCHAR(50)
);

CREATE TABLE Employee_salary (
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 employee_id BIGINT NOT NULL,
                                 payment_date DATE,
                                 amount DECIMAL(10, 2),
                                 description VARCHAR(255)
);
