package rpe.selecao.customer_and_employee_management.service;


import org.springframework.stereotype.Service;
import rpe.selecao.customer_and_employee_management.model.Employee;
import rpe.selecao.customer_and_employee_management.repository.EmpoloyerRepository;

import java.util.List;
import java.util.logging.Logger;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());
    private final EmpoloyerRepository repository;
    public EmployeeServiceImpl(EmpoloyerRepository repository){ this.repository = repository; }

    public List<Employee> getAll(){
        return repository.findAll();
    }
    public Employee getById(long id){
        return repository.findById(id).get();
    }
    public Employee create(Employee employee) throws Exception {
        try{
            return repository.save(employee);
        }catch (Exception e){
            log.info("[ErrorCreateEmployee] - " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    public Employee update(long id, Employee employee) throws Exception {
        try{
            if(repository.findById(id).isEmpty()) throw new Exception("No value present");
            employee.setId((int)id);
            return repository.save(employee);
        }catch (Exception e){
            log.info("[ErrorUpdateEmployee] - " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    public void delete(long id) throws Exception {
        try{
            if(repository.findById(id).isEmpty()) throw new Exception("No value present");
            repository.deleteById(id);
        }catch (Exception e){
            log.info("[ErrorDeleteEmployee] - " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
