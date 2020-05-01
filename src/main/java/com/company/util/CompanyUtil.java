package com.company.util;

import com.company.entities.Company;
import com.company.vo.CompanyVO;

import java.util.ArrayList;
import java.util.List;

public class CompanyUtil {
    /*
     *This method converts List<Company> to List<CompanyVO> Object
     * @param: List<Company>
     *@return: List<CompanyVO>
     */
    public static List<CompanyVO> mapCompanyToCompanyVOs(List<Company> companies){
        List<CompanyVO> companyVOS = new ArrayList<>();

        for (Company company : companies){
            CompanyVO companyVO = new CompanyVO();
            companyVO.setCompanyId(company.getCompanyId());
            companyVO.setLocation(company.getLocation());
            companyVO.setDescription(company.getDescription());
            companyVO.setCompanyName(company.getCompanyName());
            companyVO.setEstablishedDate(company.getEstablishedDate());
            companyVO.setEmployees(company.getEmployees());
            companyVOS.add(companyVO);
        }
        return companyVOS;
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
