package com.tailoor.fabiansimon.Tailoor.repository;

import com.tailoor.fabiansimon.Tailoor.model.Tailor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TailorRepository extends JpaRepository<Tailor, Long> {

    @Query(value = "SELECT * FROM tailors WHERE LOWER(name) LIKE %:term%", nativeQuery = true)
    List<Tailor> findTailorByTerm(@Param("term") String searchTerm);
}
