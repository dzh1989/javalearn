package com.dzh.javabase.collectionOperator;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dongzihui on 16/6/24.
 */
public class SetTest {
    public static void main(String[] args){
//        Set s = new HashSet();
//        Set<String> s = new HashSet<String>();
        Set<String> s = new TreeSet<String>();  //排序的set,不存储重复元素
        s.add("1");
        s.add("2");
        s.add("2");
        for (String item : s){
            System.out.println(item);
        }
    }
}
