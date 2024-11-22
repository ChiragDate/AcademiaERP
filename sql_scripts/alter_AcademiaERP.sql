ALTER TABLE Employees
    ADD CONSTRAINT fk_department
        FOREIGN KEY (department) REFERENCES Departments(department_id);

ALTER TABLE Employee_salary
    ADD CONSTRAINT fk_employee_salary
        FOREIGN KEY (employee_id) REFERENCES Employees(employee_id);
