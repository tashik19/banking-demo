package com.midas.banking.service;

import com.midas.banking.entity.UserDetails;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDetails signup(UserDetails userDetails);
}
