package com.company.util;

import com.company.entities.Company;
import com.company.vo.CompanyVO;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyUtil {
    /*
     *This method converts List<Company> to List<CompanyVO>
     * @param: List<Company>
     *@return: List<CompanyVO>
     */
    public static List<CompanyVO> mapCompanyToCompanyVOs(List<Company> companies){

        return companies.stream().map(company -> {
            CompanyVO companyVO = new CompanyVO();
            companyVO.setCompanyId(company.getCompanyId());
            companyVO.setCompanyName(company.getCompanyName());
            companyVO.setLocation(company.getLocation());
            companyVO.setDescription(company.getDescription());
            companyVO.setEstablishedDate(company.getEstablishedDate());
            companyVO.setEmployees(company.getEmployees());
            return companyVO;
        }).collect(Collectors.toList());

    }

    /*
     *This method converts List<CompanyVO> to List<Company>
     * @param: List<CompanyVO>
     * @return: List<Company>
     */
    public static List<Company> mapCompanyVOsToCompany(List<CompanyVO> companyVOS){
        return companyVOS.stream().map(companyVO -> {
            Company company = new Company();
            company.setCompanyName(companyVO.getCompanyName());
            company.setDescription(companyVO.getDescription());
            company.setLocation(companyVO.getLocation());
            company.setEstablishedDate(companyVO.getEstablishedDate());
            company.setEmployees(companyVO.getEmployees());
            return company;
        }).collect(Collectors.toList());
    }

    /*
     *This method converts Company to CompanyVO Object
     * @param: Company
     *@return: CompanyVO
     */
    public static CompanyVO mapCompanyToCompanyVO(Company company){
        CompanyVO companyVO = new CompanyVO();

        companyVO.setCompanyId(company.getCompanyId());
        companyVO.setLocation(company.getLocation());
        companyVO.setDescription(company.getDescription());
        companyVO.setCompanyName(company.getCompanyName());
        companyVO.setEstablishedDate(company.getEstablishedDate());
        companyVO.setEmployees(company.getEmployees());
        return companyVO;
    }

    /*
     *This method converts CompanyVO to Company Object
     * @param: Company
     *@return: CompanyVO
     */
    public static Company mapCompanyVOToCompany(CompanyVO companyVO){
        Company company = new Company();

       company.setCompanyId(companyVO.getCompanyId());
       company.setDescription(companyVO.getDescription());
       company.setLocation(companyVO.getLocation());
       company.setCompanyName(companyVO.getCompanyName());
       company.setEstablishedDate(companyVO.getEstablishedDate());
       company.setEmployees(companyVO.getEmployees());

        return company;
    }
}
