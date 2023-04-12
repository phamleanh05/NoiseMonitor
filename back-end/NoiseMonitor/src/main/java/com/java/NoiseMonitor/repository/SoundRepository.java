package com.java.NoiseMonitor.repository;

import com.java.NoiseMonitor.models.Sound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SoundRepository extends JpaRepository<Sound, Integer> {
    @Query("SELECT s FROM Sound s WHERE s.id = ?1")
    Optional<Sound> findById(Integer id);
}
