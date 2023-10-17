package com.tailoor.fabiansimon.Tailoor.repository;

import com.tailoor.fabiansimon.Tailoor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
