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
        regexMap.put("REGEX_NAME", "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
        regexMap.put("REGEX_EMAIL", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        regexMap.put("REGEX_PHONE", "^\\(\\d{2}\\)\\d{5}-\\d{4}$");
        regexMap.put("REGEX_RG", "^\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1}$");
        regexMap.put("REGEX_CPF", "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
        regexMap.put("REGEX_AGE", "^(0?[1-9]|[1-9][0-9])$");
    }

    public String getRegex(String fieldName){
        return regexMap.get(fieldName);
    }

}
