package com.example.sunghuncom.hw2_0411_homeworklist2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @brief this method will be used to encrypt password
 */
public class MD5 {
    private static MessageDigest md;
    public static String cryptWithMD5(String pass) {
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
