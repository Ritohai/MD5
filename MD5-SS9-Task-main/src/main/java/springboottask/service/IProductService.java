package springboottask.service;

import org.springframework.stereotype.Service;
import springboottask.model.dto.request.ProductRequest;
import springboottask.model.dto.response.ProductResponse;

import java.util.List;

@Service
public interface IProductService {
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
    ProductResponse save(ProductRequest productRequest) ;
    ProductResponse update(ProductRequest productRequest,Long id);
    ProductResponse delete(Long id);
}
