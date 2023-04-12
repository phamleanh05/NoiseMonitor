package com.java.NoiseMonitor.repository;

import com.java.NoiseMonitor.models.DefaultArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DefaultAreaRepository extends JpaRepository<DefaultArea, Integer> {
    @Query ("SELECT s FROM DefaultArea s WHERE s.id = ?1")
    Optional<DefaultArea> findById(Integer id);
}
