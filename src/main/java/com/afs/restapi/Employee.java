package com.afs.restapi;

public class Employee {
  private Integer id;
  private String name;
  private Integer age;
  private String gender;
  private Integer salary;

  public Employee(int id, String name, int age, String gender, int salary) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.salary = salary;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }
}
