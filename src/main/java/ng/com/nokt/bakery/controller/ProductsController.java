package ng.com.nokt.bakery.controller;

import ng.com.nokt.bakery.entity.Product;
import ng.com.nokt.bakery.entity.ProductImage;
import ng.com.nokt.bakery.repository.ProductRepository;
import ng.com.nokt.bakery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductsController {

    final private ProductService productService;


    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @RequestBody List<ProductImage> images){
        product.setImages(images);
        return ResponseEntity.ok().body(productService.createProduct(product));
    }


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }
}
