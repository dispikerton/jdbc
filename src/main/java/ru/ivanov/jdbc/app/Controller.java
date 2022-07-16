package ru.ivanov.jdbc.app;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private final CustomerDao dao;

  public Controller(CustomerDao dao) {
    this.dao = dao;
  }

  @PostMapping
  public Long createCustomer(@RequestBody Customer customer) {
    return dao.createCustomer(customer);
  }

  @GetMapping
  public Customer getCustomerById(@RequestParam long id) {
    return dao.getCustomerById(id);
  }

  @PutMapping
  public void editCustomer(@RequestBody Customer customer) {
    dao.editCustomer(customer);
  }

  @DeleteMapping
  public void deleteCustomer(@RequestParam long id) {
    dao.deleteCustomer(id);
  }
}
