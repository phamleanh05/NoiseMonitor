package com.java.NoiseMonitor.service;

import com.java.NoiseMonitor.models.Location;
import com.java.NoiseMonitor.repository.LocationRepository;
import com.java.NoiseMonitor.repository.SoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Optional<Location> findById(@PathVariable Integer id) {
        return locationRepository.findByLocationId(id);
    }


    public void deleteById(@PathVariable Integer id) {locationRepository.deleteById(id);}

    public boolean existsById(@PathVariable Integer id) {
        return locationRepository.existsById(id);
    }

    public Location save(@RequestBody Location newLocation) { return locationRepository.save(newLocation);}
}
