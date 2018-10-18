package com.ifood.util;


import org.jasypt.util.password.StrongPasswordEncryptor;

public class EncryptionDecryption {
    private String seed = "FptIfood";

    public static String encrypt(String userPassword) throws Exception {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
        return encryptedPassword;
    }

    public static boolean checkLogin(String inputPassword,String encryptedPassword){
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return (passwordEncryptor.checkPassword(inputPassword, encryptedPassword));
    }
}