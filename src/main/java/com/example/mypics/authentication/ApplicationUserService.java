package com.example.mypics.authentication;

import com.example.mypics.dao.ApplicationUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {
    private final ApplicationUserDAO dao;

    @Autowired
    public ApplicationUserService(@Qualifier("dummy") ApplicationUserDAO dao) {
        this.dao = dao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return dao.loadUserByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format("%s not found.%n", s)));
    }
}