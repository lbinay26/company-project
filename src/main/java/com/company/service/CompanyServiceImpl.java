package com.company.service;

import com.company.entities.Company;
import com.company.repository.CompanyRepository;
import com.company.util.CompanyUtil;
import com.company.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    /*
     *This method gets all the companies from db
     *@return: ResponseEntity
     */
    @Override
    public ResponseEntity getCompanies() {
        try {
            List<Company> companies = companyRepository.findAll();
            List<CompanyVO> companyVOS = CompanyUtil.mapCompanyToCompanyVOs(companies);
            return ResponseEntity.ok().body(companyVOS);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Company Not Found");
        }
    }

    /*
     *This method gets a Company by Id from db
     * @param: companyId @type:int
     *@return: ResponseEntity
     */
    @Override
    public ResponseEntity getCompanyByCompanyId(int companyId) {
        try {
            Company company = companyRepository.getCompanyByCompanyId(companyId);
            if(company != null){
                CompanyVO companyVO = CompanyUtil.mapCompanyToCompanyVO(company);
                return ResponseEntity.ok().body(companyVO);
            }else{
                return ResponseEntity.status(HttpStatus.OK).body("Company Not Found");
            }
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Company Not Found");

        }
    }

    /*
     *This method save a Company Object in db
     * @param: companyVO @type:CompanyVo
     *@return: ResponseEntity
     */
    @Override
    public ResponseEntity saveCompany(CompanyVO companyVO) {
        if(companyVO == null || companyVO.getCompanyName() == null || companyVO.getDescription() == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Company is mandatory");
        }
        Company company = CompanyUtil.mapCompanyVOToCompany(companyVO);
        Company company1 = companyRepository.save(company);

        return ResponseEntity.ok().body(company1);
    }

    /*
     *This method delete a Company Object in db
     * @param: companyId @type:int
     *@return: ResponseEntity
     */
    @Override
    public ResponseEntity deleteCompanyBycompanyId(int companyId) {

        companyRepository.deleteById(new Integer(companyId));
        return  ResponseEntity.ok().body("Successfully Deleted");
    }

    /*
     *This method update Location & Description  based on companyId in db
     * @param: companyId @type:int
     *@return: ResponseEntity
     */
    @Override
    public ResponseEntity updateCompanyLocationAndDescById(int companyId, CompanyVO companyVO) {
        Company company1 = companyRepository.getCompanyByCompanyId(new Integer(companyId));
        company1.setLocation(companyVO.getLocation());
        company1.setDescription(companyVO.getDescription());

        companyRepository.save(company1);
        return ResponseEntity.ok().body("Update successfully");
    }

    @Transactional
    @Override
    public ResponseEntity updateCompanyLocationByCompanyId(int companyId, String location) {
        companyRepository.updateLocation(companyId, location);
        return ResponseEntity.ok().body("location successfully updated");
    }
}
