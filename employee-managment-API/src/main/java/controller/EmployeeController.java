package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;
import model.SalaryBand;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
   
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

  
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setSalaryBand(calculateSalaryBand(employee.getSalary()));
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    
    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeMap.values();
    }

    
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeMap.get(id);
    }

 
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id,
                                 @RequestBody Employee updated) {

        Employee existing = employeeMap.get(id);
        if (existing == null) {
            return "Employee not found";
        }


        if (!existing.getDepartment().equals(updated.getDepartment())) {
            return "Department change is not allowed";
        }

    
        if (!existing.getDesignation().equals(updated.getDesignation())) {
            if (updated.getSalary() <= existing.getSalary()) {
                return "Salary must be increased for designation change";
            }
        }

        existing.setName(updated.getName());
        existing.setDesignation(updated.getDesignation());
        existing.setSalary(updated.getSalary());
        existing.setSalaryBand(calculateSalaryBand(updated.getSalary()));
        existing.setContact(updated.getContact());

        return "Employee updated successfully";
    }

   
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeMap.remove(id);
        return "Employee deleted successfully";
    }

   
    private SalaryBand calculateSalaryBand(double salary) {
        if (salary < 30000) {
            return SalaryBand.LOW;
        } else if (salary <= 70000) {
            return SalaryBand.MEDIUM;
        } else {
            return SalaryBand.HIGH;
        }
    }
}
