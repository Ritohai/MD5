package ra.ss5spingboot.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.ss5spingboot.exception.UserException;
import ra.ss5spingboot.model.domain.Customer;
import ra.ss5spingboot.model.dto.request.CustomerRequest;
import ra.ss5spingboot.model.dto.response.CustomerResponse;
import ra.ss5spingboot.repository.ICustomerRepository;
import ra.ss5spingboot.service.ICustomerService;
import ra.ss5spingboot.service.mapper.CustomerMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<CustomerResponse> findAll() {

        return customerRepository.findAll().stream()
                .map(c->customerMapper.toResponse(c)).collect(Collectors.toList());

    }

    @Override
    public CustomerResponse findById(Long id) {
       Optional<Customer> customerOptional = customerRepository.findById(id);
       if(customerOptional.isPresent()) {
           return customerMapper.toResponse(customerOptional.get());
       }
       return null;
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) throws UserException {
        if(customerRepository.existsByEmail(customerRequest.getEmail())){
                throw new UserException("Email is existed");
        }
        if(customerRepository.existsByPhoneNumber(customerRequest.getPhoneNumber())){
            throw new UserException("Phone is existed");
        }

        Customer cus = customerRepository.save(customerMapper.toEntity(customerRequest));
        return customerMapper.toResponse(cus);
    }

    @Override
    public CustomerResponse delete(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        customerRepository.delete(customerOptional.get());
        if(customerOptional.isPresent()) {
            return customerMapper.toResponse(customerOptional.get());
        }
        return null;
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest, Long id) {
        Customer customer = customerMapper.toEntity(customerRequest);
        customer.setId(id);
        Customer cusEdit = customerRepository.save(customer);
        return customerMapper.toResponse(cusEdit);
    }
}
