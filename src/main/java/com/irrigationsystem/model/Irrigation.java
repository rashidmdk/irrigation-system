package com.irrigationsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "irrigation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Irrigation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;
    @Column(name = "minutes_per_acre")
    private long minutesPerAcre;
    @Column(name = "water_per_acre")
    private long waterPerAcre;
}
