package com.git.gitpractice.controller;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
public class HS512Generator {
    public static void main(String[] args) {
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");
            SecretKey secretKey = keyGenerator.generateKey();

            String encodedKey = Base64.getEncoder().encodeToString((secretKey.getEncoded()));
            log.info("key:"+encodedKey);
        }catch (NoSuchAlgorithmException e){
            log.error(e.getMessage());
        }
    }
}
//5Z44EXWZRZAVTG5SCC78CU99ESEQDP8Z
//HX4ADZN0ZOHGK6MBP2XFRIGDDBD8L35E
//X7LYAW2GKTZRK6E62PKA6SWE45JMXRY8
//R6WNP729SRRUY8FHM5967LHEHGP996SH