package com.example.jdbc_ws.controller;
import com.example.jdbc_ws.dao.BuildingDAO;
import com.example.jdbc_ws.model.Building;
import com.example.jdbc_ws.service.BuildingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public record BuildingController(BuildingService buildingService) {
    @GetMapping("/buildings")
    public List<Building> findAll() {
        return buildingService.findAll();
    }
    @GetMapping("/buildings/{countrycode}")
    public List<Building> findByCountryCode(@PathVariable("countrycode") String countryCode) {
        return buildingService.findByCountryCode(countryCode);
    }

    @PutMapping("/buildings")
    public void changeCountry(@RequestParam("buildingname") String buildingName,
                              @RequestParam("newCountryCode") String newCountryCode) {
        buildingService.changeCountry(buildingName, newCountryCode);
    }
}
