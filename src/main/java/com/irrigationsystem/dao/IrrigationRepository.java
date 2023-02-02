package com.irrigationsystem.dao;

import com.irrigationsystem.model.Irrigation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IrrigationRepository extends JpaRepository<Irrigation, Integer> {
}
