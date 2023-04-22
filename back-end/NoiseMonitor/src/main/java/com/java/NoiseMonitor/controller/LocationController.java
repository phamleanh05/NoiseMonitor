package com.java.NoiseMonitor.controller;

import com.java.NoiseMonitor.models.Location;
import com.java.NoiseMonitor.models.ResponseObject;
import com.java.NoiseMonitor.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
@RequestMapping(path = "api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("")
    List<Location> getAllLocation() {
        return locationService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Integer id){
        Optional<Location> foundLocation = locationService.findById(id);
        return foundLocation.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Querry Service successfully", foundLocation)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false", "Cannot find Service with id =" + id,"")
                );

    }

    //insert data
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertLocation (@RequestBody Location newLocation){
        Optional<Location> foundLocation = locationService.findById(newLocation.getLocationId());
        return foundLocation.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Service Name already taken", "")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Insert Service successfully",locationService.save(newLocation))
                );
    }

    //Update data
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateLocation(@RequestBody Location newLocation, @PathVariable Integer id){
        Location updateLocation =  locationService.findById(id)
                .map(location -> {
                    location.setLocationId(newLocation.getLocationId());
                    location.setSoundId(newLocation.getSoundId());
                    location.setArea(newLocation.getArea());
                    location.setLat(newLocation.getLat());
                    location.setLng(newLocation.getLng());
                    return locationService.save(location);
                }).orElseGet(()->{
                    newLocation.setLocationId(id);
                    return locationService.save(newLocation);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update Service successfully",locationService.save(newLocation))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteLocation (@PathVariable Integer id){
        boolean exists = locationService.existsById(id);
        if(exists)
        {
            locationService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Delete Service successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed", "Cannot find Service to delete ", "")
        );
    }
}