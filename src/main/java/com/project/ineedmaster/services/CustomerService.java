package com.project.ineedmaster.services;

import com.project.ineedmaster.controllers.exceptions.task.CustomerNotFoundException;
import com.project.ineedmaster.models.Customer;
import com.project.ineedmaster.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public void create(Customer customer) {
        var customerEntity = customerRepository.findById(customer.getId());
        // TODO: add orElseThrow + CustomerException handler
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id)
                .map(Optional::of)
                .orElseThrow(() -> new CustomerNotFoundException(Long.toString(id)));
    }

    @Override
    public void update(Long id, Customer customer) {
        Customer customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(Long.toString(id)));
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setName(customer.getName());
        customerEntity.setAge(customer.getAge());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setRole(customer.getRole());

        customerRepository.save(customerEntity);
    }

    @Override
    public void delete(Long id) {
        Customer customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(Long.toString(id)));
        customerRepository.delete(customerEntity);
    }
}
