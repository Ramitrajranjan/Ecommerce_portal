package com.e_Commerce.service.Implementation;

import com.e_Commerce.repository.UserRepository;
import com.e_Commerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=this.userDao.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("No user found!!");
        }
        return user;
    }
}
