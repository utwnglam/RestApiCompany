package com.afs.restapi;

import org.springframework.web.bind.annotation.GetMapping;
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
  public List<Company> getAllEmployees() {
    return companyDatabase.findAll();
  }

}
