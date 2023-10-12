package com.tailoor.fabiansimon.Tailoor.tailor.service;

import com.tailoor.fabiansimon.Tailoor.tailor.model.Tailor;
import com.tailoor.fabiansimon.Tailoor.tailor.repository.TailorRepository;
import com.tailoor.fabiansimon.Tailoor.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TailorService {

    @Autowired
    private TailorRepository tailorRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Tailor> getAllTailors() {
        return tailorRepository.findAll();
    }

    public Tailor saveTailor(Tailor tailor) {
        return tailorRepository.save(tailor);
    }

    @Transactional
    public Tailor addAdminToTailor(Long tailorId, Long userId) {
        Tailor tailor = tailorRepository.findById(tailorId)
                .orElseThrow(() -> new IllegalArgumentException("Tailor not found"));

        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("No user with that ID found");
        }

        if (tailor.getAdminIds() == null) {
            tailor.setAdminIds(new ArrayList<>());
        }

        if (!tailor.getAdminIds().contains(userId)) {
            tailor.getAdminIds().add(userId);
        }

        return tailorRepository.save(tailor);
    }
}
