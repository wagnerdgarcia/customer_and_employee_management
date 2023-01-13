package rpe.selecao.customer_and_employee_management.service;

import rpe.selecao.customer_and_employee_management.model.Customer;
import rpe.selecao.customer_and_employee_management.model.Employee;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();
    public Customer getById(long id);
    public Customer update(long id, Customer customer) throws Exception;
    public Customer create(Customer customer) throws Exception;
    public void delete(long id) throws Exception;
}
