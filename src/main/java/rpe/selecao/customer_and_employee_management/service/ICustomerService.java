package rpe.selecao.customer_and_employee_management.service;

import org.springframework.stereotype.Service;
import rpe.selecao.customer_and_employee_management.model.Customer;
import rpe.selecao.customer_and_employee_management.repository.CustomerRepository;
import rpe.selecao.customer_and_employee_management.repository.EmpoloyerRepository;

import java.util.List;
import java.util.logging.Logger;
@Service
public class ICustomerService {
    private final Logger log = Logger.getLogger(ICustomerService.class.getName());
    private final CustomerRepository repository;
    public ICustomerService (CustomerRepository repository) { this.repository = repository; }
    public List<Customer> getAll(){
        return repository.findAll();
    }
    public Customer getById(long id) {
        return repository.findById(id).get();
    }
    public Customer create(Customer customer){
        try{
            return repository.save(customer);
        }catch (Exception e){
            log.info("[ErrorCreateCustomer]: " + e.getMessage());
            return null;
        }
    }
    public Customer update(long id, Customer customer){
        try{
            customer.setId((int)id);
            return repository.save(customer);
        }catch (Exception e){
            log.info("[ErrorUpdateCustomer]: " + e.getMessage());
            return null;
        }
    }
    public void delete(long id){
        try{
            repository.deleteById(id);
        }catch (Exception e){
            log.info("[ErrorDeleteCustomer]: " + e.getMessage());
        }
    }
}
