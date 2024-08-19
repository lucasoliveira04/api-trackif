package org.trackifapi.services.pattern.ExistingField;

import org.springframework.stereotype.Service;
import org.trackifapi.modal.repository.UserRepository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExistingFieldUser {

    private final UserRepository userRepository;

    public ExistingFieldUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean fieldExists(String fieldName, String fieldValue) {
        try{
            String methodName = "existsBy" + capitalize(fieldName);
            Method method = UserRepository.class.getMethod(methodName, String.class);
            return (boolean) method.invoke(userRepository, fieldValue);
        } catch (Exception e){
            throw new RuntimeException("Erro ao verificar se o campo existe: " + e.getMessage());
        }
    }

    private String capitalize(String str){
        if (str == null || str.isEmpty()){
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void toCheckColumnExists(String fieldValue){
        List<String> fieldsToCheck = List.of("cpf", "rg", "email");

        List<Boolean> toCheckField = new ArrayList<>();
        for (String field : fieldsToCheck){
            boolean exists = fieldExists(field, fieldValue);
            toCheckField.add(exists);
            if (exists){
                throw new RuntimeException(field.toUpperCase() + " já existe: " + fieldValue);
            }
        }
    }

}
