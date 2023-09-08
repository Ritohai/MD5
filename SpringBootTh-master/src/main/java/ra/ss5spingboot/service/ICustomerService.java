package ra.ss5spingboot.service;

import ra.ss5spingboot.exception.UserException;
import ra.ss5spingboot.model.dto.request.CustomerRequest;
import ra.ss5spingboot.model.dto.response.CustomerResponse;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponse> findAll();
    CustomerResponse findById(Long id);
    CustomerResponse save(CustomerRequest customerRequest) throws UserException;
    CustomerResponse update(CustomerRequest customerRequest,Long id);
    CustomerResponse delete(Long id);
}
