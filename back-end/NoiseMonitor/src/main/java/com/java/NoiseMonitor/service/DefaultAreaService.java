package com.java.NoiseMonitor.service;

import com.java.NoiseMonitor.models.DefaultArea;
import com.java.NoiseMonitor.repository.DefaultAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultAreaService {

    @Autowired
    private DefaultAreaRepository defaultAreaRepository;

    public DefaultAreaService(DefaultAreaRepository defaultAreaRepository) {
        this.defaultAreaRepository = defaultAreaRepository;
    }
    public List<DefaultArea> getAll() {
        return defaultAreaRepository.findAll();
    }

    public Optional<DefaultArea> findArea(@PathVariable Integer id){
        return defaultAreaRepository.findById(id);
    }

    public void deleteArea(@PathVariable Integer id) {
        defaultAreaRepository.deleteById(id);
    }

    public boolean existsArea(@PathVariable Integer id){
        return defaultAreaRepository.existsById(id);
    }
    public DefaultArea saveArea(@RequestBody DefaultArea newArea) {
        return defaultAreaRepository.save(newArea);
    }
}
