package rpe.selecao.customer_and_employee_management.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import rpe.selecao.customer_and_employee_management.model.Customer;
import rpe.selecao.customer_and_employee_management.repository.CustomerRepository;
import rpe.selecao.customer_and_employee_management.repository.EmpoloyerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
@Service
public class CustomerServiceImpl implements CustomerService{
    private final Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());
    private final CustomerRepository repository;
    public CustomerServiceImpl (CustomerRepository repository) { this.repository = repository; }
    public List<Customer> getAll(){
        return repository.findAll();
    }
    public Customer getById(long id) {
        return repository.findById(id).get();
    }
    public Customer create(Customer customer) throws Exception {
        try{
            return repository.save(customer);
        }catch (Exception e){
            log.info("[ErrorCreateCustomer]: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    public Customer update(long id, Customer customer) throws Exception {
        try{
            if(repository.findById(id).isEmpty()) throw new Exception("No value present");
            customer.setId((int)id);
            return repository.save(customer);
        }catch (Exception e){
            log.info("[ErrorUpdateCustomer]: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    public void delete(long id) throws Exception {
        try{
            if(repository.findById(id).isEmpty()) throw new Exception("No value present");
            repository.deleteById(id);
        }catch (Exception e){
            log.info("[ErrorDeleteCustomer]: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
