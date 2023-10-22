package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.CardUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardUserRepository extends JpaRepository <CardUser,Long> {
    CardUser findByAccountUserBankIdUser(Long accountUserBankId);

    Optional<CardUser> findById(Long id);
}

