/**
 * Project Name : commons-util <br>
 * File Name : BeanUtilsTest.java <br>
 * Package Name : com.lee.util <br>
 * Create Time : 2016-09-26 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.util;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * ClassName : BeanUtilsTest <br>
 * Description : unit test for beanUtils <br>
 * Create Time : 2016-09-26 <br>
 * Create by : jimmyblylee@126.com
 */
public class BeanUtilsTest {

    @Test
    public void testCopyProperty() {
        FooPojo source = new FooPojo();
        source.setA("aaa");
        source.b = 5;
        source.setC(123L);
        source.setD(true);
        source.setE(null);
        
        FooPojo target = new FooPojo();
        BeanUtils.copyProperties(source, target);
        assertThat(target.getA(), is("aaa"));
        assertThat(target.b, nullValue());
        assertThat(target.getC(), is(123L));
        assertThat(target.isD(), is(true));
        assertThat(target.getE(), nullValue());
        
        target = new FooPojo();
        
        BeanUtils.copyProperties(source, target, "c", "a");
        assertThat(target.getA(), nullValue());
        assertThat(target.b, nullValue());
        assertThat(target.getC(), is(0L));
        assertThat(target.isD(), is(true));
        assertThat(target.getE(), nullValue());
        
    }
}
