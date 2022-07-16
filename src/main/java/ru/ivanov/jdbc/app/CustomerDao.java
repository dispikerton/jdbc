package ru.ivanov.jdbc.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
  private final NamedParameterJdbcTemplate template;

  public CustomerDao(NamedParameterJdbcTemplate template) {
    this.template = template;
  }

  public Long createCustomer(Customer customer) {
    String sql = "INSERT INTO customer (fio, phone, address) VALUES (:fio, :phone, :address) RETURNING ID";
    Map<String, Object> map = new HashMap<>();
    map.put("fio", customer.getFio());
    map.put("phone", customer.getPhone());
    map.put("address", customer.getAddress());
    return template.queryForObject(sql, map, Long.class);
  }
}
