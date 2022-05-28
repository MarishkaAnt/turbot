package com.resliv.turbot.controller;

import com.resliv.turbot.model.City;
import com.resliv.turbot.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/all")
    public ResponseEntity<List<City>> get (){
        log.debug("getMapping started");
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<City> getByName (@RequestParam String name){
        log.debug("getMapping by name started");
        Optional<City> founded = cityService.findByName(name);
        if(founded.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(founded.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<City> save (@RequestBody City city){
        log.debug("postMapping started");
        City createdCity = cityService.create(city);
        return new ResponseEntity<>(createdCity, HttpStatus.OK);
    }

    @DeleteMapping("/close")
    public ResponseEntity<Void> close (@RequestBody City city){
        if(city == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            cityService.delete(city);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
