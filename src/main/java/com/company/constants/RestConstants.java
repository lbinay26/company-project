package com.company.constants;

public class RestConstants {
    public static final String API_URI = "/api";
    public static final String GET_ALL_COMPANIES = "/companies";
    public static final String GET_COMPANY_BY_ID = "/company/{companyId}";
    public static final String SAVE_COMPANY = "/save";
    public static final String DELETE_COMPANY_BY_ID = "/delete/{companyId}";
    public static final String UPDATE_COMPANY_BY_ID = "/update/{companyId}";
    public static final String UPDATE_COMPANY_BY_ID_AND_LOCATION = "/update/{companyId}/{location}";
    public static final String GET_ALL_EMPLOYEES = "/employees";
    public static final String GET_EMPLOYEE_BY_EMPNO = "/employee/{empNo}";
    public static final String SAVE_EMPLOYEE = "/employee/save";
    public static final String  GET_ALL_EMPLOYEES_MS_URI= "http://localhost:8082/api/employees";
    public static final String  GET_EMPLOYEE_BY_EMPNO_MS_URI= "http://localhost:8082/api/employee/";
    public static final String  SAVE_EMPLOYEE_MS_URI= "http://localhost:8082/api/employee/save";




}
