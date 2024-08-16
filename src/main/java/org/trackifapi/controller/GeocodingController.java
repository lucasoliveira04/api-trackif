package org.trackifapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.services.GeoLocation.GeocodingService;

@RestController
public class GeocodingController {

    private final GeocodingService geocodingService;

    public GeocodingController(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }

    @GetMapping("/get-address")
    public String getAddress(@RequestParam double lat, @RequestParam double lng) {
        return geocodingService.getAddress(lat, lng);
    }
}
