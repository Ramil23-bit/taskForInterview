package org.example.repository;

import org.example.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppJpaRepository extends JpaRepository<UserApp, Long> {
}
