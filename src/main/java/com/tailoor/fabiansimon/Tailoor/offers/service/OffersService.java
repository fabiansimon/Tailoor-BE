package com.tailoor.fabiansimon.Tailoor.offers.service;

import com.tailoor.fabiansimon.Tailoor.offers.model.Offer;
import com.tailoor.fabiansimon.Tailoor.offers.repository.OfferRepository;
import com.tailoor.fabiansimon.Tailoor.tailor.model.Tailor;
import com.tailoor.fabiansimon.Tailoor.tailor.repository.TailorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OffersService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private TailorRepository tailorRepository;

    @Transactional
    public Offer addOfferToTailor(Long tailorId, Offer offer) {
        Tailor tailor = tailorRepository.findById(tailorId)
                .orElseThrow(() -> new IllegalArgumentException("Tailor not found"));

        Offer savedOffer = offerRepository.save(offer);

        if (tailor.getOffers() == null) {
            tailor.setOffers(new ArrayList<>());
        }

        tailor.getOffers().add(savedOffer);

        tailorRepository.save(tailor);
        return savedOffer;
    }
}
