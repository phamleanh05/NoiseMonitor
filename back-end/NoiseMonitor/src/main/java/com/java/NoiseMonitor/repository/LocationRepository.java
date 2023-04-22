package com.java.NoiseMonitor.repository;

import com.java.NoiseMonitor.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("SELECT s FROM Location s WHERE s.locationId = ?1")
    Optional<Location> findByLocationId(Integer locationId);

    @Query("SELECT s FROM Location s WHERE s.locationId = ?1")
    Optional<Location> findById(Integer locationId);
}
