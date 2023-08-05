package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <AccountUser,Long> {
    AccountUser findByNumberAccount (String numberAccount);
}
