package springboottask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import springboottask.model.dto.request.ProductRequest;
import springboottask.model.dto.response.ProductResponse;
import springboottask.service.IProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v3/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest ProductRequest)throws MethodArgumentNotValidException {
        return new ResponseEntity<>(productService.save(ProductRequest),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@RequestBody @Valid ProductRequest ProductRequest, @PathVariable Long id)throws MethodArgumentNotValidException{
        return new ResponseEntity<>(productService.update(ProductRequest,id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(productService.delete(id),HttpStatus.OK);
    }
}