package com.afs.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
  private CompanyDatabase companyDatabase;

  public CompanyController(CompanyDatabase companyDatabase) {
    this.companyDatabase = companyDatabase;
  }

  @GetMapping
  public List<Company> getAllCompanies() {
    return companyDatabase.findAll();
  }

  @GetMapping("/{id}")
  public Company getCompanyById(@PathVariable Integer id) {
    return companyDatabase.findById(id);
  }

  @GetMapping("/{id}/employees")
  public List<Employee> getCompanyEmployeesList(@PathVariable Integer id) {
    return companyDatabase.findEmployees(id);
  }
}
