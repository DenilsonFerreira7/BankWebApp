package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
