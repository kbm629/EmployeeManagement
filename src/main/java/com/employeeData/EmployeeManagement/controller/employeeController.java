/* Controller class which handle the request from users and
   become a bridge between service to user it known as a
   presentation layer.
 */

package com.employeeData.EmployeeManagement.controller;

import com.employeeData.EmployeeManagement.dto.employeeDTO;
import com.employeeData.EmployeeManagement.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController            // annotation used to handle REST Api Request when you
                           // don't have HTML type of data you can easily send JSon data

@RequestMapping("/employee")  // this is the main base URL for all request

public class employeeController {

    @Autowired                // Automatically initialise the object no need to do manually
    employeeService empService;

    @GetMapping("")        // GET Request mapping
    public List<employeeDTO> getAllEmployee()
    {
        return empService.getAllEmployee();     // Return all the employee details
    }

    @GetMapping("/{id}")
    public employeeDTO getEmployeeDetailsById(@PathVariable("id") Long empId)   //change the name of id using pathvariable
    {
        return empService.getEmployeeById(empId);
    }

    @PostMapping("")
    public employeeDTO CreateEmployeeDetails(@RequestBody employeeDTO empDTO)  // When you need to send any data with POST Request
    {
        return empService.createEmployee(empDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeDetails(@PathVariable("id") Long empId)
    {
        empService.deleteEmployee(empId);
        return "Successfully deleteded employee";
    }
}
