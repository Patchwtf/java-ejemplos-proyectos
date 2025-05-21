package org.example.util;

public class PasswordUtil {

    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    public static SecurityLevel assessPassword(String password){
        if(password.matches("[a-zA-Z]+|.{0,7}"))return SecurityLevel.WEAK;
        if(password.matches("(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$")) return SecurityLevel.MEDIUM;
        if(password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).{8,}$")) return SecurityLevel.STRONG;
        return SecurityLevel.WEAK;
    }
}
