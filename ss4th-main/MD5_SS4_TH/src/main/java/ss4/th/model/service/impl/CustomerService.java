package ss4.th.model.service.impl;

import org.springframework.stereotype.Service;
import ss4.th.model.entity.Customer;
import ss4.th.model.repository.ICustomerRepository;
import ss4.th.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

}

