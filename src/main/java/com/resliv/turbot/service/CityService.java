package com.resliv.turbot.service;

import com.resliv.turbot.model.City;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Validated
public interface CityService {

    List<City> findAll();
    Optional<City> findById(@NotNull Long id);
    Optional<City> findByName(@NotNull String name);
    City create(@Valid City city);
    void delete(@Valid City city);
}
