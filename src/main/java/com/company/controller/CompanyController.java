package com.company.controller;

import com.company.constants.RestConstants;
import com.company.service.CompanyService;
import com.company.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

     @GetMapping(RestConstants.GET_ALL_COMPANIES)
    public ResponseEntity getCompanies(){
         return companyService.getCompanies();
    }

    @GetMapping(RestConstants.GET_COMPANY_BY_ID)
    public ResponseEntity getCompanyByCompanyNo(@PathVariable("companyId") int companyId){
        return companyService.getCompanyByCompanyId(companyId);
    }

    @PostMapping(RestConstants.SAVE_COMPANY)
    public ResponseEntity saveCompany(@RequestBody CompanyVO companyVO){
         return companyService.saveCompany(companyVO);
    }

    @DeleteMapping(RestConstants.DELETE_COMPANY_BY_ID)
    public ResponseEntity deleteCompanyBycompanyId(@PathVariable("companyId") int companyId){
         return  companyService.deleteCompanyBycompanyId(companyId);

    }

    @PutMapping(RestConstants.UPDATE_COMPANY_BY_ID)
    public ResponseEntity updateCompanyLocationAndDescById(@PathVariable("companyId") int companyId, @RequestBody CompanyVO companyVO){
         return companyService.updateCompanyLocationAndDescById(companyId, companyVO);

    }

    @PutMapping(RestConstants.UPDATE_COMPANY_BY_ID_AND_LOCATION)
    public ResponseEntity updateCompanyLocationByCompanyNo(@PathVariable("companyId") int companyId, @PathVariable("location") String location){
        return companyService.updateCompanyLocationByCompanyId(companyId, location);

    }
}
