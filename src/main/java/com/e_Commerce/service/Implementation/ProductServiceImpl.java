package com.e_Commerce.service.Implementation;

import com.e_Commerce.entity.Product;
import com.e_Commerce.repository.ProductRepository;
import com.e_Commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts(int pageNumber,String searchKey) {
        PageRequest pageRequest= PageRequest.of(pageNumber,10);
        if(searchKey.equals("")) {
            return this.productRepository.findAll(pageRequest).getContent();
        }else {
           return productRepository.findByProductNameContainingIgnoreCaseOrProductDescriptionIgnoreCase(
                    searchKey,searchKey,pageRequest
            ).getContent();
        }
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProductDetails(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductDetails(boolean isSingleProductCheckout, Long id) {
        if(isSingleProductCheckout){

            List<Product> list=new ArrayList<>();
            Product product=productRepository.findById(id).get();
            list.add(product);
            return list;
        }else {

        }
        return new ArrayList<>();
    }
}
