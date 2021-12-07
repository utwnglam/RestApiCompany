package com.afs.restapi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

  public List<Company> findByPageNumber(Integer page, Integer pageSize) {
    int pageToBeSkipped = page - 1;
    return companies.stream()
      .skip((long) pageToBeSkipped * pageSize)
      .limit((long) pageSize)
      .collect(Collectors.toList());
  }

  public Company create(Company company) {
    int nextId = companies.stream()
      .mapToInt(Company::getId)
      .max()
      .orElse(0) + 1;

    company.setId(nextId);
    companies.add(company);
    return company;
  }

  public Company edit(Integer id, Company updatedCompany) {
    Company company = findById(id);
    companies.remove(company);
    companies.add(updatedCompany);
    return updatedCompany;
  }
}
