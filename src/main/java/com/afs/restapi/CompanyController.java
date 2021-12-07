package com.afs.restapi;

import org.springframework.web.bind.annotation.*;

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

  @GetMapping(params = {"page", "pageSize"})
  public List<Company> getCompaniesByPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
    return companyDatabase.findByPageNumber(page, pageSize);
  }

}
