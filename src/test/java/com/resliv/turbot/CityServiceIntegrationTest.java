package com.resliv.turbot;

import com.resliv.turbot.model.City;
import com.resliv.turbot.service.CityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CityServiceIntegrationTest {

    @Autowired
    CityService cityService;

    @Test
    void createNewCity_success(){
        //given
        String name = "someCity";
        String info = "someInfo";
        City city = City.builder()
                .name(name)
                .info(info)
                .build();
        //when
        City actual = cityService.create(city);
        //then
        Assertions.assertEquals(name, actual.getName());
        Assertions.assertEquals(info, actual.getInfo());
    }

}
