package com.company.service;


import com.company.entities.Company;
import com.company.vo.CompanyVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    /*
     *This method gets all the companies from db
     *@return: ResponseEntity
     */
    ResponseEntity getCompanies();


    /*
     *This method gets a Company by Id from db
     * @param: companyId @type:int
     *@return: ResponseEntity
     */
    ResponseEntity getCompanyByCompanyId(int companyId);

    /*
     *This method save a Company Object in db
     * @param: companyVO @type:CompanyVo
     *@return: ResponseEntity
     */
    ResponseEntity saveCompany(CompanyVO companyVO);

    /*
     *This method delete a Company Object in db
     * @param: companyId @type:int
     *@return: ResponseEntity
     */
    ResponseEntity deleteCompanyBycompanyId(int companyId);

    /*
     *This method update Location & Description  based on companyId in db
     * @param: companyId @type:int
     *@return: ResponseEntity
     */
    ResponseEntity updateCompanyLocationAndDescById(int companyId, CompanyVO companyVO);

    ResponseEntity updateCompanyLocationByCompanyId(int companyId, String location);
}
