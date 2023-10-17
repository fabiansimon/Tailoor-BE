package com.tailoor.fabiansimon.Tailoor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tailors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tailor {

    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    private Date createdAt;
    private String name;
    private String description;
    private List<String> profileImageUrls;
    @ElementCollection
    @CollectionTable(
            name = "tailor_admins",
            joinColumns = @JoinColumn(name = "tailor_id")
    )
    private List<Long> adminIds;
    @ElementCollection
    @CollectionTable(
            name = "tailor_offers",
            joinColumns = @JoinColumn(name = "tailor_id")
    )
    private List<Offer> offers;
}
