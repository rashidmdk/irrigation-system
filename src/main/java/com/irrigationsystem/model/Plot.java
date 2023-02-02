package com.irrigationsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "plot")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "time_slot")
    private LocalTime timeSlot;
    @Column(name = "area_in_acre")
    private Integer areaInAcre;
    @OneToOne(cascade = CascadeType.ALL)
    private Irrigation irrigation;
}
