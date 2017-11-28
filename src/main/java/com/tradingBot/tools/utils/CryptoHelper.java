package com.tradingBot.tools.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptoHelper {



    private String apiKey = "";
    private String apiKeySecret = "";
    private long nonce = System.currentTimeMillis();

    public static String hmacDigest(String msg, String keyString, String algo) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes(Constants.UTF), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes(Constants.ASCII));

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
            //Log.e(TAG, "Exception: " + e.getMessage());
        } catch (InvalidKeyException e) {
            //Log.e(TAG, "Exception: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            //Log.e(TAG, "Exception: " + e.getMessage());
        }
        return digest;
    }
}
