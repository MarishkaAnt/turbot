package com.resliv.turbot.service.impl;

import com.resliv.turbot.model.City;
import com.resliv.turbot.repository.CityRepository;
import com.resliv.turbot.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public Optional<City> findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public City create(City city) {
        Optional<City> foundedByName = cityRepository.findByName(city.getName());
        if(foundedByName.isEmpty()) {
            log.debug("start create new city with name: {}", city.getName());
            return  cityRepository.save(city);
        }else{
            log.debug("The city with name: {}, is already created", city.getName());
            City updated = foundedByName.get();
            updated.setInfo(city.getInfo());
            return cityRepository.save(updated);
        }
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }
}
