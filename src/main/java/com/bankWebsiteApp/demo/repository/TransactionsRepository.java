package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository <Transactions,Long> {
}
