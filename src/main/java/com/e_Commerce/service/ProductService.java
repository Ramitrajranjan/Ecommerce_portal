package com.e_Commerce.service;

import com.e_Commerce.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product addProduct(Product product);
    public List<Product> getAllProducts(int pageNumber,String searchKey);

    public Product getProductById(Long id);

    public void deleteProductDetails(Long id);

    public List<Product> getProductDetails(boolean isSingleProductCheckout,Long id);
}
