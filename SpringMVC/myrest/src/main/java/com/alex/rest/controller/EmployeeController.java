package com.alex.rest.controller;

import java.security.PublicKey;
import java.util.Collection;

import com.alex.rest.bean.Employee;
import com.alex.rest.dao.EmployeeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeDao employeeDao;

  @GetMapping("/employee")
  public String getAllEmployee(Model model) {
    Collection<Employee> employeeList =  employeeDao.getAll();
    model.addAttribute("employeeList", employeeList);
    return "employee_list";
  }

  @DeleteMapping("/employee/{id}")
  public String deleteEmployee(Model model, @PathVariable("id")Integer id) {
    employeeDao.delete(id);
    return "redirect:/employee";
  }

  @PostMapping("/employee")
  public String addEmployee(Model model, Employee employee) {
    employeeDao.save(employee);
    return "redirect:/employee";
  }

  @GetMapping("/employee/{id}")
  public String getEmployeeById(Model model, @PathVariable("id")Integer id) {
    Employee employee = employeeDao.get(id);
    model.addAttribute("employee", employee);
    return "employee_update";
  }

  @PutMapping("/employee")
  public String updateEmployee(Model model, Employee employee) {
    employeeDao.save(employee);
    return "redirect:/employee";
  }
}
