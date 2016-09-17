/**
 * Project Name : commons-util <br>
 * File Name : StringUtilsTest.java <br>
 * Package Name : com.lee.util <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.util;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * ClassName : StringUtilsTest <br>
 * Description : unit test of StringUtils, just test the method I wrote butnot Springframework <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com
 */
public class StringUtilsTest {

    @Test
    public void testGetStackString() {
        Exception ex = new Exception("layer 1", new Exception("layer 2"));
        String exStr = StringUtils.getStackString(ex);
        assertThat(exStr, containsString("layer 1"));
        assertThat(exStr, containsString("layer 2"));
        
        assertThat(StringUtils.getStackString(null), is("The caught is NULL!"));
    }
    
    @Test
    public void testLeftPad() {
        assertThat(StringUtils.leftPad("x", 6, 'y'), is("yyyyyx"));
        assertThat(StringUtils.leftPad("x", 1, 'y'), is("x"));
    }
}
