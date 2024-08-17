package org.trackifapi.controller.Location;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trackifapi.services.GenerateToken.GenerateTokenServices;
import org.trackifapi.services.GeoLocation.GeocodingService;

@RestController
public class GeocodingController {

    private final GeocodingService geocodingService;
    private final GenerateTokenServices generateTokenServices;

    public GeocodingController(GeocodingService geocodingService, GenerateTokenServices generateTokenServices) {
        this.geocodingService = geocodingService;
        this.generateTokenServices = generateTokenServices;
    }

    @GetMapping("/get-address")
    public String getAddress(@RequestParam double lat, @RequestParam double lng) {
        return geocodingService.getAddress(lat, lng);
    }
}
