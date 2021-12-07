package com.afs.restapi;

import org.springframework.http.HttpStatus;
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

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public Company createCompany(@RequestBody Company company) {
    return companyDatabase.create(company);
  }

  @PutMapping("/{id}")
  public Company editCompany(@PathVariable Integer id, @RequestBody Company updatedCompany) {
    Company company = companyDatabase.findById(id);
    if (updatedCompany.getCompanyName() != null) {
      company.setCompanyName(updatedCompany.getCompanyName());
    }
    if (updatedCompany.getEmployees() != null) {
      company.setEmployees(updatedCompany.getEmployees());
    }
    return companyDatabase.edit(id, company);
  }
}
