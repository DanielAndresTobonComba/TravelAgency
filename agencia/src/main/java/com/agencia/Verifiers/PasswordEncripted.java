package com.agencia.Verifiers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordEncripted {

    public static String encript(String passwordString) {

        String passwordEncripted = "";

        try {

        byte [] pwdByte = passwordString.getBytes(StandardCharsets.UTF_8);
        MessageDigest digest =  MessageDigest.getInstance("SHA-256");
        byte [] hash = digest.digest(pwdByte);
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < hash.length; i++) {
            final String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) 
              hexString.append('0');
            hexString.append(hex);
        }

        passwordEncripted =  hexString.toString();

        

        } catch (Exception e) {
            e.printStackTrace();
        }

        return passwordEncripted;

        


    }

}
