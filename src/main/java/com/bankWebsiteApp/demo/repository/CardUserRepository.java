package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.models.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardUserRepository extends JpaRepository <CardUser,Long> {
    CardUser findByAccountUserBank(UserBank accountUserBank);

    Optional<CardUser> findById(Long id);

    CardUser findByNumberCard(String numberCard);
}

