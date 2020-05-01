package com.company.repository;

import com.company.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Company getCompanyByCompanyId(int companyId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Company c SET c.location = :location WHERE c.id = :companyId")
    int updateLocation(@Param("companyId") int companyId, @Param("location") String location);
}
