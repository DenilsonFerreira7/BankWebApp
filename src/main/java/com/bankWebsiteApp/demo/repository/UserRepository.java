package com.bankWebsiteApp.demo.repository;
import com.bankWebsiteApp.demo.models.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserBank,Long> {

    UserBank findByName(String name);
}
