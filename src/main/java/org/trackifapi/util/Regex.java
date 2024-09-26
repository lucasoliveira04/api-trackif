package org.trackifapi.util;

import org.springframework.stereotype.Service;

@Service
public class Regex {
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final String PHONE_REGEX = "\\d{10,11}";
    public static final String CPF_REGEX = "\\d{11}";
    public static final String RG_REGEX = "\\d{9}";
}
