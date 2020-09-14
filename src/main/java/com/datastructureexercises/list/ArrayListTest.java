package com.datastructureexercises.list;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * @author Administrator
 */
public class ArrayListTest {
    Logger logger = Logger.getGlobal();
    @Test
    public void arrayListTest() {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("hahah");
        System.out.println(strings.get(0).getClass().getName());
    }

    @Test
    public void mapTest() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("apple", 12);
        map.put("pear", 13);
        map.put("banana", 15);
        Collection<Integer> values = map.values();
        System.out.println(values.toString());
        for (String key : map.keySet()) {
            Integer integer = map.get(key);
            System.out.println(integer);
        }
    }

    @Test
    public void map2Test() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("apple", 12);
        map.put("pear", 13);
        map.put("banana", 15);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    @Test
    public void threadTest() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        String oid = UUID.randomUUID().toString().replace("-", "");
        logger.info(oid);
        String message = "";
        logger.info(String.valueOf(StringUtils.isBlank(message)));
        BigDecimal bigDecimal = new BigDecimal(0);
        System.out.println(bigDecimal.toString());
        ArrayList<Object> objects = new ArrayList<>();
        objects.size();
        String[] aa = {};
        System.out.println(aa.length);
    }
    public static void main(String args[]) {
        String str = "02";
        String pattern1 = ".*[,-].*";
        String pattern2 = ".*/0*";
        boolean b = Pattern.matches(".*/0*", str) || Pattern.matches(".*[,-].*", str);
        System.out.println(b);
    }

}
