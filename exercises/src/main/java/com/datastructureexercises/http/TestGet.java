package com.datastructureexercises.http;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liutianlong
 */
public class TestGet {

    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new LinkedList<>();
        int i =0;
        while(true){
            i++;
            if(i%10000==0) {
                System.out.println("i="+i);
            }
            list.add(new Object());
        }
    }
}


