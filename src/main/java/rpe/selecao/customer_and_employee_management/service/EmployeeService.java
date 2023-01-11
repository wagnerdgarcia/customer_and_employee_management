package rpe.selecao.customer_and_employee_management.service;

import rpe.selecao.customer_and_employee_management.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(long id);
    public Employee update(long id, Employee employee);
    public Employee create(Employee employee);
    public void delete(long id);
}
