package springboottask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboottask.model.domain.Product;
import springboottask.model.dto.request.ProductRequest;
import springboottask.model.dto.response.ProductResponse;
import springboottask.repository.IProductRepository;
import springboottask.service.IProductService;
import springboottask.service.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(c->productMapper.toResponse(c)).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            return productMapper.toResponse(productOptional.get());
        }
        return null;
    }

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        Product pro = productRepository.save(productMapper.toEntity(productRequest));
        return productMapper.toResponse(pro);
    }

    @Override
    public ProductResponse update(ProductRequest productRequest, Long id) {
        Product product = productMapper.toEntity(productRequest);
        product.setId(id);
        Product proEdit = productRepository.save(product);
        return productMapper.toResponse(proEdit);
    }

    @Override
    public ProductResponse delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        productRepository.delete(productOptional.get());
        if(productOptional.isPresent()) {
            return productMapper.toResponse(productOptional.get());
        }
        return null;
    }
}
