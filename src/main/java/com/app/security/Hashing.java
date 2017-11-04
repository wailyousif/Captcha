package com.app.security;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;

/**
 * Created by wailm.yousif on 10/21/17.
 */
public class Hashing
{
    final static Logger logger = Logger.getLogger(Hashing.class);

    private String generateNonce()
    {
        Random rand = new Random();
        int min = 1001;
        int max = 9999;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return String.valueOf(randomNum);
    }

    public String getSHA512(String stringToHash)
    {
        String sha512 = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            //md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(stringToHash.getBytes("UTF-8"));
            sha512 = Base64.getEncoder().encodeToString(bytes);
        }
        catch (Exception ex)
        {
            logger.error("Handled Exception", ex);
        }
        return sha512;
    }

    public boolean validateSignature(String signature)
    {
        return true;
    }
}
