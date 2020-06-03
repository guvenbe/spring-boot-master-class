package com.in28minutes.learning.jpa.jpain10steps.repositories;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
