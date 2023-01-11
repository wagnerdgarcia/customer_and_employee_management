package rpe.selecao.customer_and_employee_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpe.selecao.customer_and_employee_management.model.Employee;
import rpe.selecao.customer_and_employee_management.service.IEmployeeService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final Logger log = Logger.getLogger(EmployeeController.class.getName());
    public EmployeeController(final IEmployeeService employeeService){
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllEmployee(){
        try{
            List<Employee> employees = employeeService.getAll();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdEmployee(@PathVariable("id") long id){
        try{
            Employee employee = employeeService.getById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        try{
            Employee newEmployee = employeeService.create(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        try{
            Employee newEmployee = employeeService.update(id, employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id){
        try{
            employeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
