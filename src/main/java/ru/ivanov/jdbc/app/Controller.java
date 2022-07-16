package ru.ivanov.jdbc.app;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
