package rpe.selecao.customer_and_employee_management.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpe.selecao.customer_and_employee_management.model.Customer;
import rpe.selecao.customer_and_employee_management.service.CustomerServiceImpl;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;
    private final Logger log = Logger.getLogger(CustomerController.class.getName());
    public CustomerController(final CustomerServiceImpl customerService){
        super();
        this.customerService = customerService;
    }

    @GetMapping("/")
    @Operation(
            description = "Endpoint to see all Customers",
            responses = {
                @ApiResponse(responseCode = "200", description = "Return a List of all Customers"),
                @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> getAllCustomer(){
        try{
            List<Customer> customers = customerService.getAll();
            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Endpoint for querying a Customers",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return The Customer"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> getByIdCustomer(@PathVariable("id") long id){
        try{
            Customer customer = customerService.getById(id);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @Operation(
            description = "Endpoint to add a Customers",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return The Customer"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        try{
            Customer newCustomer = customerService.create(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Operation(
            description = "Endpoint to update a Customers",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return The Customer"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
        try{
            Customer newCustomer = customerService.update(id, customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            description = "Endpoint to delete a Customers",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id){
        try{
            customerService.delete(id);
            return new ResponseEntity<>("Sucess Delete", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
