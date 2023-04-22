package com.java.NoiseMonitor.controller;

import com.java.NoiseMonitor.models.ResponseObject;
import com.java.NoiseMonitor.models.Sound;
import com.java.NoiseMonitor.service.SoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
@RequestMapping(path = "api/sound")
public class SoundController {
    @Autowired
    private SoundService soundService;

    @GetMapping("")
    List<Sound> getAllService(){
        return soundService.getAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject>findBySoundId(@PathVariable Integer id){
        Optional<Sound> foundSound = soundService.findByLocationId(id);
        return foundSound.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Querry Service successfully", foundSound)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false", "Cannot find Service with id =" + id,"")
                );

    }

    //insert data
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertSound(@RequestBody Sound newRate) {
        Optional<Sound> foundRate = soundService.findById(newRate.getSoundId());
        if (foundRate.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Insert Rating successfully", " ")
            );
        } else {
            soundService.saveSound(newRate);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Insert Rating successfully", "")
            );
        }
    }

    //Update data
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateSound(@RequestBody Sound newSound, @PathVariable Integer id){
        Sound updateSound =  soundService.findById(id)
                .map(sound -> {
                    sound.setSoundId(newSound.getSoundId());
                    sound.setDecibels(newSound.getDecibels());
                    sound.setLocationId(newSound.getLocationId());
                    sound.setTime(newSound.getTime());
                    return soundService.saveSound(sound);
                }).orElseGet(()->{
                    newSound.setSoundId(id);
                    return soundService.saveSound(newSound);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update Service successfully", soundService.saveSound(newSound))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteSound (@PathVariable Integer id){
        boolean exists = soundService.existsThreshold(id);
        if(exists)
        {
            soundService.deleteThreshold(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Delete Service successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed", "Cannot find Service to delete ", "")
        );
    }
}
