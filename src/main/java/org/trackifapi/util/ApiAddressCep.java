package org.trackifapi.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiAddressCep {

    public String getAddressByCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = getAddressCep(cep);
        return restTemplate.getForObject(url, String.class);
    }

    private String getAddressCep(String cep) {
        return "https://viacep.com.br/ws/" + cep + "/json/";
    }
}
