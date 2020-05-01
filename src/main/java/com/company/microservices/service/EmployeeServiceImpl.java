package com.company.microservices.service;

import com.company.constants.RestConstants;
import com.company.entities.Employee;
import com.company.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity getAllEmployee() {
        List<EmployeeVO> employeeVOS;
        ResponseEntity<List<EmployeeVO>> responseEntity = restTemplate.exchange(RestConstants.GET_ALL_EMPLOYEES_MS_URI,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EmployeeVO>>(){});

        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            employeeVOS = responseEntity.getBody();
        }else {
            return ResponseEntity.status(responseEntity.getStatusCode()).body("Employee not found");
        }
        return ResponseEntity.ok().body(employeeVOS);
    }

    @Override
    public ResponseEntity getEmployeeById(int empNo) {
        EmployeeVO employeeVO;
        ResponseEntity responseEntity = restTemplate.getForEntity(RestConstants.GET_EMPLOYEE_BY_EMPNO_MS_URI + empNo,
            ResponseEntity.class
        );
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return ResponseEntity.ok().body(responseEntity.getBody());
        }else {
            return ResponseEntity.status(responseEntity.getStatusCode()).body("Employee not found");
        }
        //return ResponseEntity.ok().body(employeeVO);

    }

    @Override
    public ResponseEntity saveEmployee(EmployeeVO employeeVO) {
        if(employeeVO == null || employeeVO.getFirstName() == null || employeeVO.getDesignation() == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee is mandatory");
        }
        ResponseEntity<Employee> responseEntity = restTemplate.postForEntity(RestConstants.SAVE_EMPLOYEE_MS_URI,
                employeeVO,
                Employee.class
        );
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return ResponseEntity.ok().body(responseEntity.getBody());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee not save successfully");
    }
}
