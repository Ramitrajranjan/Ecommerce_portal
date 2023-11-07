package com.e_Commerce.service.Implementation;

import com.e_Commerce.entity.Role;
import com.e_Commerce.repository.RoleRepository;
import com.e_Commerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
