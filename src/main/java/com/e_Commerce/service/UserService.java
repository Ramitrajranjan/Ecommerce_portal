package com.e_Commerce.service;


import com.e_Commerce.entity.User;
import com.e_Commerce.entity.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User User, Set<UserRole> userRoles) throws Exception;

    public User getUser(Long id);

    public void deleteUser(Long userId);
}
