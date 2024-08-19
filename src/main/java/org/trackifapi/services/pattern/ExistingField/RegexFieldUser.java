package org.trackifapi.services.pattern.ExistingField;

import org.springframework.stereotype.Service;

@Service
public class RegexFieldUser {
    private static final String CPF_REGEX = "\\d{11}";
    private static final String RG_REGEX = "\\d{9}";

    public boolean isValidCpf(String cpf) {
        if (cpf == null){
            return false;
        }

        return cpf.matches(CPF_REGEX);
    }

    public boolean isValidRg(String rg) {
        if (rg == null){
            return false;
        }

        return rg.matches(RG_REGEX);
    }
}
