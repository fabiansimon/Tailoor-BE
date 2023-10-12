package com.tailoor.fabiansimon.Tailoor.user.repository;

import com.tailoor.fabiansimon.Tailoor.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
