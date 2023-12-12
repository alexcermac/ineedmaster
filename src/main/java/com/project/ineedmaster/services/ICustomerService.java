package com.project.ineedmaster.services;

import com.project.ineedmaster.models.Customer;

import java.util.Optional;

public interface ICustomerService {
    void create(Customer customer);
    Optional<Customer> findById(Long id);
    void update(Long id, Customer customer);
    void delete(Long id);
}
