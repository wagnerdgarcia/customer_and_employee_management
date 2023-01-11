package rpe.selecao.customer_and_employee_management.service;


import org.springframework.stereotype.Service;
import rpe.selecao.customer_and_employee_management.model.Employee;
import rpe.selecao.customer_and_employee_management.repository.EmpoloyerRepository;

import java.util.List;
import java.util.logging.Logger;


@Service
public class IEmployeeService implements EmployeeService{
    private final Logger log = Logger.getLogger(IEmployeeService.class.getName());
    private final EmpoloyerRepository repository;
    public IEmployeeService(EmpoloyerRepository repository){ this.repository = repository; }

    public List<Employee> getAll(){
        return repository.findAll();
    }
    public Employee getById(long id){
        return repository.findById(id).get();
    }
    public Employee create(Employee employee){
        try{
            return repository.save(employee);
        }catch (Exception e){
            log.info("[ErrorCreateEmployee] - " + e.getMessage());
            return null;
        }
    }
    public Employee update(long id, Employee employee){
        try{
            employee.setId((int)id);
            return repository.save(employee);
        }catch (Exception e){
            log.info("[ErrorUpdateEmployee] - " + e.getMessage());
            return null;
        }
    }
    public void delete(long id){
        try{
            repository.deleteById(id);
        }catch (Exception e){
            log.info("[ErrorDeleteEmployee] - " + e.getMessage());
        }
    }
}
