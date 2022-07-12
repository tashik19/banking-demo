package com.midas.banking.service.impl;

import com.midas.banking.entity.UserDetails;
import com.midas.banking.repository.UserRepository;
import com.midas.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails signup(UserDetails userDetails) {
        UserDetails user = new UserDetails();
        user.setUserId(userDetails.getUserId());
        user.setPassword(userDetails.getPassword());
        user.setAccountNo(userDetails.getAccountNo());
        return userRepository.save(user);
    }

}
