package com.tailoor.fabiansimon.Tailoor.controller;

import com.tailoor.fabiansimon.Tailoor.model.Tailor;
import com.tailoor.fabiansimon.Tailoor.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TailorController {

    @Autowired
    private TailorService tailorService;

    @GetMapping("/tailors")
    public ResponseEntity<Page<Tailor>> getAllTailors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Tailor> tailors = tailorService.getAllTailors(pageable);
        return ResponseEntity.ok(tailors);
    }
    @GetMapping("/filter-tailors")
    public ResponseEntity<List<Tailor>> searchTailors(@RequestParam String term) {
        List<Tailor> tailors = tailorService.searchForTailor(term.toLowerCase());
        return ResponseEntity.ok(tailors);
    }

    @PostMapping("/{tailorId}/add-as-admin/{userId}")
    public ResponseEntity<?> addAdminToTailor(@PathVariable Long tailorId, @PathVariable Long userId) {
        try {
            Tailor updatedTailor = tailorService.addAdminToTailor(tailorId, userId);
            return ResponseEntity.ok(updatedTailor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while adding the admin.");
        }
    }

    @PostMapping("/add-tailor")
    public ResponseEntity<Tailor> createTailor(@RequestBody Tailor tailor) {
        try {
            return new ResponseEntity<>(tailorService.saveTailor(tailor), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
