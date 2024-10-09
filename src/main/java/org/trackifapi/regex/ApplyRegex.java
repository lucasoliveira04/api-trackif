package org.trackifapi.regex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackifapi.modal.dto.UserDto;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApplyRegex {
    private final HashMapRegex hashMapRegex;

    @Autowired
    public ApplyRegex(HashMapRegex hashMapRegex) {
        this.hashMapRegex = hashMapRegex;
    }

    public void applyRegex(UserDto user) {
        if (user != null) {
            Map<String, String> fieldsToCheck = new HashMap<>();
            fieldsToCheck.put("Name", user.getName());
            fieldsToCheck.put("Email", user.getEmail());
            fieldsToCheck.put("Phone", user.getPhone());
            fieldsToCheck.put("RG", user.getRg());
            fieldsToCheck.put("CPF", user.getCpf());

            for (Map.Entry<String, String> entry : fieldsToCheck.entrySet()) {
                String fieldName = entry.getKey();
                String fieldValue = entry.getValue();
                if (fieldValue != null && !fieldValue.matches(hashMapRegex.getRegex("REGEX_" + fieldName.toUpperCase()))) {
                    throw new IllegalArgumentException("Invalid " + fieldName + " field");
                }
            }

            int age = user.getAge();
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Invalid age field");
            }
        }
    }
}

