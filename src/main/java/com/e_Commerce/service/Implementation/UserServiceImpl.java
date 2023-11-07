package com.e_Commerce.service.Implementation;

import com.e_Commerce.entity.User;
import com.e_Commerce.entity.UserRole;
import com.e_Commerce.repository.UserRepository;
import com.e_Commerce.service.UserService;
import com.e_Commerce.repository.RoleRepository;
import com.e_Commerce.helper.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //crating user=========================================================================================
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception
    {
        User local=this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is already there");
            throw new UserFoundException();
        }
        else
        {
            for(UserRole ur: userRoles)
            {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=this.userRepository.save(user);
        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(Long id)
    {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long userId)
    {
        this.userRepository.deleteById(userId);
    }
}
