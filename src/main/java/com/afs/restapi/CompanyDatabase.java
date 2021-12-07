package com.afs.restapi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CompanyDatabase {
  private List<Company> companies = new ArrayList<>();

  public CompanyDatabase() {
    companies.add(new Company(1, "comm",
      Arrays.asList(new Employee(1, "who", 20, "Female", 10000), new Employee(2, "wh", 20, "Female", 10000))
    ));
    companies.add(new Company(2, "comingCompany",
      Arrays.asList(new Employee(1, "who2", 20, "Female", 10000), new Employee(2, "jane", 20, "Female", 10000))
    ));
    companies.add(new Company(3, "cannotFindCompany",
      Arrays.asList(new Employee(1, "who3", 20, "Female", 1500), new Employee(2, "dearjane", 20, "Female", 10000))
    ));
  }

  public List<Company> findAll() {
    return companies;
  }

  public Company findById(Integer id) {
    return companies.stream()
      .filter(company -> company.getId().equals(id))
      .findFirst()
      .orElseThrow(NoCompanyFoundException::new);
  }

  public List<Employee> findEmployees(Integer id) {
    return findById(id).getEmployees();
  }
}
