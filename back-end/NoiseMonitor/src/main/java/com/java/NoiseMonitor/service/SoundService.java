package com.java.NoiseMonitor.service;

import com.java.NoiseMonitor.models.Sound;
import com.java.NoiseMonitor.repository.SoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SoundService {

    @Autowired
    private SoundRepository soundRepository;

    public SoundService(SoundRepository soundRepository) {
        this.soundRepository = soundRepository;
    }
    public List<Sound> getAll() {
        return soundRepository.findAll();
    }

    public Optional<Sound> findById(@PathVariable Integer id){
        return soundRepository.findById(id);
    }

    public void deleteThreshold(@PathVariable Integer id) {
        soundRepository.deleteById(id);
    }

    public boolean existsThreshold(@PathVariable Integer id){
        return soundRepository.existsById(id);
    }
    public Sound saveSound(@RequestBody Sound newSound) {
        return soundRepository.save(newSound);
    }
}
