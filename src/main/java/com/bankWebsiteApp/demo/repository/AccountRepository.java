package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository <AccountUser,Long> {
    AccountUser findByNumberAccount (String numberAccount);
    AccountUser findByAccountUserBankIdUser(Long accountUserBankId);

    Optional<AccountUser> findById(Long id);
}

