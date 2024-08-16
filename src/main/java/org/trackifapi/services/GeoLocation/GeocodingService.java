package org.trackifapi.services.GeoLocation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GeocodingService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String getAddress(double lat, double lng) {
        try {
            String url = String.format("https://nominatim.openstreetmap.org/reverse?lat=%s&lon=%s&format=json", lat, lng);

            String response = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(response);
            JsonNode addressNode = root.path("address");

            return formatAddress(addressNode);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter endereço", e);
        }
    }

    private String formatAddress(JsonNode addressNode) {
        return String.format(
                "%s, %s, %s - %s, %s",
                cleanAddress(addressNode.path("road").asText()),
                cleanAddress(addressNode.path("neighbourhood").asText()),
                cleanAddress(addressNode.path("city").asText()),
                cleanAddress(addressNode.path("state").asText()),
                cleanAddress(addressNode.path("postcode").asText())
        );
    }

    private String cleanAddress(String address) {
        return (address == null || "undefined".equals(address)) ? "" : address.trim();
    }
}
