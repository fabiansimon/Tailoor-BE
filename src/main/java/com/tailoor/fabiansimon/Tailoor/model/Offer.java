package com.tailoor.fabiansimon.Tailoor.model;

import com.tailoor.fabiansimon.Tailoor.common.ClothingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "offers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offer {
    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    private Date createdAt;
    private String title;
    private String description;
    private double discountInFiat;
    private double discountInPercentage;
    private int maxHourPromise;
    private Date expiresAt;
    @Enumerated(EnumType.STRING)
    private ClothingType clothingType;
}


