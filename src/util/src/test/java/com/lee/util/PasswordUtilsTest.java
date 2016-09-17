/**
 * Project Name : commons-util <br>
 * File Name : PasswordUtilsTest.java <br>
 * Package Name : com.lee.util <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.util;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * ClassName : PasswordUtilsTest <br>
 * Description : unit test for PasswordUtils <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com
 */
public class PasswordUtilsTest {

    @Test
    public void testEncryptByMD5() {
        String md5 = PasswordUtils.encryptByMD5("abc");
        assertThat(md5, notNullValue());
        assertThat(md5.length(), is(32));
    }
    
    @Test
    public void testGenerateSimplePwd() {
        for (int time = 0; time < 1000; time++) {
            String pwd = PasswordUtils.generateSimplePwd(8);
            assertThat(pwd.length(), is(8));
            assertThat(pwd, not(pwd.toLowerCase()));
            boolean oneNumberIsInString = false;
            for (int i = 0; i < 10; i++) {
                if (pwd.contains(i + "")) {
                    oneNumberIsInString = true;
                    break;
                }
            }
            assertTrue(oneNumberIsInString);
        }
    }
    
    @Test
    public void testGenerateComplexPwd() {
        for (int time = 0; time < 1000; time++) {
            String pwd = PasswordUtils.generateComplexPwd(8);
            assertThat(pwd.length(), is(8));
            assertThat(pwd, not(pwd.toLowerCase()));
            boolean oneNumberIsInString = false;
            for (int i = 0; i < 10; i++) {
                if (pwd.contains(i + "")) {
                    oneNumberIsInString = true;
                    break;
                }
            }
            assertTrue(oneNumberIsInString);
            boolean oneSpecialCharInString = false;
            for (int i = 0; i < 5; i++) {
                if (pwd.contains("!@#%&".substring(i, i + 1))) {
                    oneSpecialCharInString = true;
                    break;
                }
            }
            assertTrue(oneSpecialCharInString);
        }
    }
}
