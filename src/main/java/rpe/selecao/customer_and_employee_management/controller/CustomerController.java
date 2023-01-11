package rpe.selecao.customer_and_employee_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpe.selecao.customer_and_employee_management.model.Customer;
import rpe.selecao.customer_and_employee_management.service.ICustomerService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final ICustomerService customerService;
    private final Logger log = Logger.getLogger(CustomerController.class.getName());
    public CustomerController(final ICustomerService customerService){
        super();
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCustomer(){
        try{
            List<Customer> customers = customerService.getAll();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdCustomer(@PathVariable("id") long id){
        try{
            Customer customer = customerService.getById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        try{
            Customer newCustomer = customerService.create(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
        try{
            Customer newCustomer = customerService.update(id, customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id){
        try{
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
