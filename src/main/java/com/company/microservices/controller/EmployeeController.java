package com.company.microservices.controller;

import com.company.constants.RestConstants;
import com.company.microservices.service.EmployeeService;
import com.company.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestConstants.API_URI)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(RestConstants.GET_ALL_EMPLOYEES)
    public ResponseEntity getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(RestConstants.GET_EMPLOYEE_BY_EMPNO)
    public ResponseEntity getEmployeeById(@PathVariable("empNo") int empNo){
        return employeeService.getEmployeeById(empNo);
    }

    @PostMapping(RestConstants.SAVE_EMPLOYEE)
    ResponseEntity saveEmployee(@RequestBody EmployeeVO employeeVO){
        return employeeService.saveEmployee(employeeVO);
    }
}
