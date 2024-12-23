package com.socialnetwork.social_networking_backend.repository;

import com.socialnetwork.social_networking_backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUsername(String username);

    Optional<Account> findByUsername(String username);

}
