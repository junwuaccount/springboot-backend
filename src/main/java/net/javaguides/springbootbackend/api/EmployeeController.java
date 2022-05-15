package net.javaguides.springbootbackend.api;

import net.javaguides.springbootbackend.exception.ResourceNoFoundException;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GIT COMMENT TIME
@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin(origins = {"${settings.cors_origin}"})
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //get employee by id endpoint
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNoFoundException("Employee with id not found:"  + id));
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNoFoundException("Employee with id not found:"  + id));
        updateEmployee.setFirstname(employeeDetails.getFirstname());
        updateEmployee.setLastname(employeeDetails.getLastname());
        updateEmployee.setEmailid(employeeDetails.getEmailid());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNoFoundException("Employee with id not found:"  + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
