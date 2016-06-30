/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsfordesigners;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Nezhdanoff
 */
public class EncryptorMD5 {

    public static String getMD5(String st) {

        MessageDigest mDigest = null;
        byte[] digest = new byte[0];

        try {
            mDigest = MessageDigest.getInstance("MD5");
            mDigest.reset();
            mDigest.update(st.getBytes());
            digest = mDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Модуль алгоритма MD5 не найден");
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}

