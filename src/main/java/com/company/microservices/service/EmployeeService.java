package com.company.microservices.service;

import com.company.vo.EmployeeVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeService {

    ResponseEntity getAllEmployee();

    ResponseEntity getEmployeeById(int empNo);

    ResponseEntity saveEmployee(EmployeeVO employeeVO);


    }
