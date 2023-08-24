package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {


    Optional<Balance> findById(Long id);
    Balance findByAccountUserBank(UserBank accountUserBank);

}
