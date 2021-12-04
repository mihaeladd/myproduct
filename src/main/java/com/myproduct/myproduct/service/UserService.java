package com.myproduct.myproduct.service;

import com.myproduct.myproduct.configuration.UserDetailsImpl;
import com.myproduct.myproduct.entity.UserEntity;
import com.myproduct.myproduct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository; //trebuie sa fie final?

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);

        user.orElseThrow(()-> new UsernameNotFoundException("Not found: "+ username));

        return user.map(UserDetailsImpl::new).get();
    }
}
