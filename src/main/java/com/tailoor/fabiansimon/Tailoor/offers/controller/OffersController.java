package com.tailoor.fabiansimon.Tailoor.offers.controller;

import com.tailoor.fabiansimon.Tailoor.offers.model.Offer;
import com.tailoor.fabiansimon.Tailoor.offers.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OffersController {

    @Autowired
    private OffersService offersService;

    @PostMapping("/{tailorId}/add-offer")
    public ResponseEntity<?> addOfferToTailor(@PathVariable Long tailorId, @RequestBody Offer offer) {
        try {
            Offer addedOffer = offersService.addOfferToTailor(tailorId, offer);
            return ResponseEntity.ok(addedOffer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while adding the admin.");
        }
    }

}
