package rpe.selecao.customer_and_employee_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rpe.selecao.customer_and_employee_management.model.Employee;
import rpe.selecao.customer_and_employee_management.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    private final Logger log = Logger.getLogger(EmployeeController.class.getName());
    public EmployeeController(final EmployeeServiceImpl employeeService){
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    @Operation(
            description = "Endpoint to see all Employees",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return a List of all Employees"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> getAllEmployee(){
        try{
            List<Employee> employees = employeeService.getAll();
            return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Endpoint for querying a Employee",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return The Employee"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> getByIdEmployee(@PathVariable("id") long id){
        try{
            Employee employee = employeeService.getById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @Operation(
            description = "Endpoint to add a Employee",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return The Employee"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        try{
            Employee newEmployee = employeeService.create(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Operation(
            description = "Endpoint to update a Employee",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Return The Employee"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        try{
            Employee newEmployee = employeeService.update(id, employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            description = "Endpoint to delete a Employee",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id){
        try{
            employeeService.delete(id);
            return new ResponseEntity<>("Sucess Delete", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
