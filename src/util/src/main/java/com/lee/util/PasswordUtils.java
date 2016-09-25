/**
 * Project Name : commons-util <br>
 * File Name : PasswordUtils.java <br>
 * Package Name : com.lee.util <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * ClassName : PasswordUtils <br>
 * Description : password utils <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com
 */
public abstract class PasswordUtils {

    /**
     * Description : encrypt string into md5 <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param source the password
     * @return the encrypted string by MD5
     */
    public static String encryptByMD5(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte b[] = md.digest();

            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return source;
    }

    /**
     * Description : generate password by given length, containing Upper Char, Lower Char and Number Char <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param length greater than 3
     * @return the generated password by given length
     * @throws RuntimeException while the lenght is less than 3
     */
    public static String generateSimplePwd(Integer length) {
        if (length < 3) { throw new RuntimeException("length should be greater than 3"); }
        StringBuilder source = new StringBuilder();
        source.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        source.append(source.toString().toLowerCase());
        source.append("0123456789");

        List<Character> resultList = new LinkedList<>();
        Random r = new Random();
        resultList.add(source.charAt(Math.abs(r.nextInt() % 26)));
        resultList.add(source.charAt(Math.abs(r.nextInt() % 26) + 26));
        resultList.add(source.charAt(Math.abs(r.nextInt() % 10) + 52));
        for (int i = 3; i < length; i++) {
            resultList.add(source.charAt(Math.abs(r.nextInt() % 62)));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int pos = Math.abs(r.nextInt() % (length - i));
            result.append(resultList.get(pos));
            resultList.remove(pos);
        }
        return result.toString();
    }

    /**
     * Description : generate password by given length, containing Upper Char, Lower Char, Number Char and Special Char
     * <br>
     * Create Time: 2016-09-17 <br>
     * Create by : jimmyblylee@126.com <br>
     *
     * @param length greater than 4
     * @return the generated password by given length
     * @throws RuntimeException while the lenght is less than 4
     */
    public static String generateComplexPwd(Integer length) {
        if (length < 4) { throw new RuntimeException("length should be greater than 4"); }
        StringBuilder source = new StringBuilder();
        source.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        source.append(source.toString().toLowerCase());
        source.append("0123456789");
        source.append("!@#%&");

        List<Character> resultList = new LinkedList<>();
        Random r = new Random();
        resultList.add(source.charAt(Math.abs(r.nextInt() % 26)));
        resultList.add(source.charAt(Math.abs(r.nextInt() % 26) + 26));
        resultList.add(source.charAt(Math.abs(r.nextInt() % 10) + 52));
        resultList.add(source.charAt(Math.abs(r.nextInt() % 5) + 62));
        for (int i = 4; i < length; i++) {
            resultList.add(source.charAt(Math.abs(r.nextInt() % 67)));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int pos = Math.abs(r.nextInt() % (length - i));
            result.append(resultList.get(pos));
            resultList.remove(pos);
        }
        return result.toString();
    }
}
