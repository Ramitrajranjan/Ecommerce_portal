package com.e_Commerce.contollers;

import com.e_Commerce.entity.ImageModel;
import com.e_Commerce.entity.Product;
import com.e_Commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(value = {"/addNewProduct"},consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addProduct(@RequestPart("product") Product product,
                              @RequestPart("imageFile") MultipartFile[] file){
//        return productService.addProduct(product);
        try{
            Set<ImageModel> images = uploadImage(file);
            product.setProductImages(images);
            return productService.addProduct(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels =new HashSet<>();
        for(MultipartFile file:multipartFiles){
            ImageModel imageModel =new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }
    @GetMapping({"getProductById/{id}"})
    public Product getProductById(@PathVariable("id") Long id){
       return productService.getProductById(id);
    }


    @GetMapping({"/getAllProducts"})
    public List<Product> getAllProduct(@RequestParam(defaultValue = "0") int pageNumber,
                                       @RequestParam(defaultValue = "") String searchKey){
        return productService.getAllProducts(pageNumber,searchKey);
    }

    @DeleteMapping({"/deleteProduct/{id}"})
    public void deleteProductDetails(@PathVariable("id") Long id){
        productService.deleteProductDetails(id);
    }
    @GetMapping({"/getProductDetails/{isSingleProductCheckout}/{id}"})
    public List<Product> getProductDetails(@PathVariable(name="isSingleProductCheckout") boolean isSingleProductCheckout,
                                  @PathVariable(name = "id") Long id){
        return productService.getProductDetails(isSingleProductCheckout,id);
    }

}
