package com.e_Commerce.service.Implementation;

import com.e_Commerce.configuration.JwtAuthenticationFilter;
import com.e_Commerce.entity.*;
import com.e_Commerce.repository.OrderDetailRepository;
import com.e_Commerce.repository.ProductRepository;
import com.e_Commerce.repository.UserRepository;
import com.e_Commerce.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private static final String orderPlaced="Placed";

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void placeOrder(OrderInput orderInput){
        List<OrderProductQuantity> productQuantityList= orderInput.getOrderProductQuantityList();

        for(OrderProductQuantity productQuantity:productQuantityList){
            Product product= productRepository.findById(productQuantity.getId()).get();
            String userName=JwtAuthenticationFilter.Current_User;
            User user=userRepository.findByUsername(userName);
            OrderDetail orderDetail=new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    orderPlaced,
                    product.getProductDiscountedPrice()*productQuantity.getQuantity(),
                    product,
                    user
            );
            this.orderDetailRepository.save(orderDetail);
        }
    }
}
