package com.midas.banking.repository;

import com.midas.banking.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer > {
}
