package com.e_Commerce;

import com.e_Commerce.entity.Role;
import com.e_Commerce.entity.User;
import com.e_Commerce.entity.UserRole;
import com.e_Commerce.helper.UserFoundException;
import com.e_Commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableScheduling
public class ECommerceApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//                System.out.println("Starting code");
//        try {
//            User user = new User();
//            user.setFirstName("Ramit");
//            user.setLastName("Ranjan");
//            user.setUsername("ramitranjan");
//            user.setPassword(this.bCryptPasswordEncoder.encode("123456789"));
//            user.setEmail("ramit@gmail.com");
//            user.setProfile("default.jpg");
//            user.setPhone("8700922261");
//
//            Role role = new Role();
//            role.setId(44L);
//            role.setName("ADMIN");
//
//            Set<UserRole> userRoleSet = new HashSet<>();
//            UserRole userRole = new UserRole();
//            userRole.setRole(role);
//            userRole.setUser(user);
//            userRoleSet.add(userRole);
//            User user1 = this.userService.createUser(user, userRoleSet);
//            System.out.println(user1.getUsername());
//        } catch (UserFoundException e) {
//            e.printStackTrace();
//        }
    }

}
