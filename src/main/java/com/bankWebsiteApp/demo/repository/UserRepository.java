package com.bankWebsiteApp.demo.repository;
import com.bankWebsiteApp.demo.models.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserBank,Long> {
}
