package org.trackifapi.regex;

public class RegexValidation {
    public static void validate(String value, String regex, String errorMensage){
        if (value == null || !value.matches(regex)){
            throw new IllegalArgumentException(errorMensage);
        }
    }
}
