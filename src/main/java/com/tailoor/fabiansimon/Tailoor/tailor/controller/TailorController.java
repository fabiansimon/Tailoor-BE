package com.tailoor.fabiansimon.Tailoor.tailor.controller;

import com.tailoor.fabiansimon.Tailoor.tailor.model.Tailor;
import com.tailoor.fabiansimon.Tailoor.tailor.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Tailor>> getAllTailors() {
        return ResponseEntity.ok(tailorService.getAllTailors());
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
