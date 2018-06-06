package com.nxd.ftt.mchelper.util.authme;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * HashUtil
 *
 * @author luhangqi
 * @date 2018/6/6
 */
public class HashUtil {

    /**
     * 获取加密字符串
     *
     * @param password
     * @param salt
     * @return
     */
    public static String computeSHA256Hash(String password, String salt) {
        return "$SHA$" + salt + "$" + sha256Hash(sha256Hash(password) + salt);
    }

    /**
     * SHA256 加密
     *
     * @param message
     * @return
     */
    private static String sha256Hash(String message) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(MessageDigestAlgorithm.SHA256.getKey());
            return hash(message, messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     *
     * @param message
     * @param messageDigest
     * @return
     */
    private static String hash(String message, MessageDigest messageDigest) {
        messageDigest.reset();
        messageDigest.update(message.getBytes());
        byte[] digest = messageDigest.digest();
        return String.format("%0" + (digest.length << 1) + "x", new BigInteger(1, digest));
    }

    /**
     * 获取salt
     *
     * @param password
     * @return
     */
    public static String getSalt(String password) {
        return password.substring(5, 21);
    }
}
