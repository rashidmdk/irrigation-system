package com.irrigationsystem.dao;

import com.irrigationsystem.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandRepository extends JpaRepository<Plot, Integer> {
}
