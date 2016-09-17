/**
 * Project Name : commons-util <br>
 * File Name : CollectionUtilsTest.java <br>
 * Package Name : com.lee.util <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com <br>
 * Copyright © 2006, 2016, Jimmybly Lee. All rights reserved.
 */
package com.lee.util;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * ClassName : CollectionUtilsTest <br>
 * Description : unit test of CollectionUtils, just test the method I wrote butnot Springframework <br>
 * Create Time : 2016-09-17 <br>
 * Create by : jimmyblylee@126.com
 */
public class CollectionUtilsTest {

    @Test
    public void testAddUniqueByComparatorSingleItem() {
        List<String> source = new LinkedList<String>();
        source.addAll(Arrays.asList("010", "020", "030", "040"));
        Comparator<String> comparartor = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(1) == o2.charAt(1) ? 0 : 1;
            }
        };
        CollectionUtils.addUniqueByComparator(source, "010", comparartor);
        assertThat(source.size(), is(4));
        CollectionUtils.addUniqueByComparator(source, "050", comparartor);
        assertThat(source, hasItem("050"));
    }

    @Test
    public void testAddUniqueByComparatorCollection() {
        List<String> source = new LinkedList<String>();
        source.addAll(Arrays.asList("010", "020", "030", "040"));
        Comparator<String> comparartor = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(1) == o2.charAt(1) ? 0 : 1;
            }
        };
        CollectionUtils.addUniqueByComparator(source, Arrays.asList("010", "020", "050"), comparartor);
        assertThat(source.size(), is(5));
        assertThat(source, hasItem("050"));
    }
}
