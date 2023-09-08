package springboottask.service.mapper;

import org.springframework.stereotype.Component;
import springboottask.model.domain.Product;
import springboottask.model.dto.request.ProductRequest;
import springboottask.model.dto.response.ProductResponse;
import springboottask.service.IGenericMapper;

@Component
public class ProductMapper implements IGenericMapper<Product, ProductRequest, ProductResponse> {

    @Override
    public Product toEntity(ProductRequest productRequest) {
        return Product.builder().productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .producer(productRequest.getProducer()).build();
    }

    @Override
    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder().id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .description(product.getDescription())
                .producer(product.getProducer()).build();
    }
}
