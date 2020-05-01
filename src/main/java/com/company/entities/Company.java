package com.company.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Company")
public class Company implements Serializable {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int companyId;
    @Column(name = "company_name")
    protected String companyName;
    protected String description;
    protected String location;
    @Column(name = "established_date")
    protected Date establishedDate;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "company_id")
    protected List<Employee> employees;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return companyId == company.companyId &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(description, company.description) &&
                Objects.equals(location, company.location) &&
                Objects.equals(establishedDate, company.establishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, description, location, establishedDate);
    }
}
