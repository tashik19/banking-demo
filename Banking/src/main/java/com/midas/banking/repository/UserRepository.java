package com.midas.banking.repository;

import com.midas.banking.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserDetails, String> {
    @Query(value="SELECT u FROM UserDetails u where u.userId= :userId and u.password = :password")
    UserDetails findUserByIdAndPassword(@Param("userId") String userId, @Param("password") String password);

    @Query(value="SELECT u FROM UserDetails u where u.userId= :userId")
    UserDetails findUserById(@Param("userId") String userId);

}
