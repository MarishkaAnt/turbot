package com.resliv.turbot.service;

import com.resliv.turbot.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    List<City> findAll();
    Optional<City> findById(Long id);
    Optional<City> findByName(String name);
    City create(City city);
    void delete(City city);
}
