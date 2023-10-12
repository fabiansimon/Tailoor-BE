package com.tailoor.fabiansimon.Tailoor.tailor.repository;

import com.tailoor.fabiansimon.Tailoor.tailor.model.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TailorRepository extends JpaRepository<Tailor, Long> {
    Tailor findByName(String name);
}
