package com.java.NoiseMonitor.controller;

import com.java.NoiseMonitor.models.DefaultArea;
import com.java.NoiseMonitor.models.ResponseObject;
import com.java.NoiseMonitor.models.Sound;
import com.java.NoiseMonitor.service.DefaultAreaService;
import com.java.NoiseMonitor.service.SoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
@RequestMapping(path = "api/area")
public class DefaultAreaController {
    @Autowired
    private DefaultAreaService defaultAreaService;

    @GetMapping("")
    List<DefaultArea> getAllArea(){
        return defaultAreaService.getAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject>findByAreaId(@PathVariable Integer id){
        Optional<DefaultArea> foundSound = defaultAreaService.findArea(id);
        return foundSound.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Querry Area successfully", foundSound)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false", "Cannot find Area with id =" + id,"")
                );

    }

    //insert data
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertArea(@RequestBody DefaultArea newArea) {
        Optional<DefaultArea> foundRate = defaultAreaService.findArea(newArea.getId());
        if (foundRate.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Insert Area successfully", " ")
            );
        } else {
            defaultAreaService.saveArea(newArea);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Insert Area successfully", "")
            );
        }
    }

    //Update data
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateArea(@RequestBody DefaultArea newArea, @PathVariable Integer id){
        DefaultArea updateArea =  defaultAreaService.findArea(id)
                .map(area -> {
                    area.setId(newArea.getId());
                    area.setArea_name(newArea.getArea_name());
                    return defaultAreaService.saveArea(area);
                }).orElseGet(()->{
                    newArea.setId(id);
                    return defaultAreaService.saveArea(newArea);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update Area successfully", defaultAreaService.saveArea(newArea))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteArea (@PathVariable Integer id){
        boolean exists = defaultAreaService.existsArea(id);
        if(exists)
        {
            defaultAreaService.deleteArea(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Delete Area successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed", "Cannot find Area to delete ", "")
        );
    }
}
