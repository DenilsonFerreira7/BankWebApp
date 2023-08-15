package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository <Balance,Long> {
}
