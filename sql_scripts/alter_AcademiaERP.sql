ALTER TABLE employee_salary(
    ADD CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employees(employee_id);
);