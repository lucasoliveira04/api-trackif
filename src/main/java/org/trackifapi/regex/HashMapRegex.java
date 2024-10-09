package org.trackifapi.regex;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class HashMapRegex {
    private final Map<String, String> regexMap = new HashMap<>();

    public HashMapRegex(){
        regexMap.put("REGEX_NAME", "^[a-zA-Z]+$"); // Somente letras
        regexMap.put("REGEX_EMAIL", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // Sem espaços e caracteres especiais extras
        regexMap.put("REGEX_PHONE", "^\\d{11}$"); // Apenas números (11 dígitos)
        regexMap.put("REGEX_RG", "^\\d{9}$"); // Apenas números (9 dígitos)
        regexMap.put("REGEX_CPF", "^\\d{11}$"); // Apenas números (11 dígitos)
        regexMap.put("REGEX_AGE", "^(\\d{1,2})$"); // Apenas números, até 2 dígitos para idade
    }

    public String getRegex(String fieldName){
        return regexMap.get(fieldName);
    }

}
