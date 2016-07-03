package com.dzh.javabase.collectionOperator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dongzihui on 16/6/25.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 5; i++) {
            map.put(i, i);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }


        //遍历map中的键
        for (Integer key : map.keySet()) {
            System.out.println("Key = " + key);
        }
        //遍历map中的值
        for (Integer value : map.values()) {
            System.out.println("Value = " + value);
        }


        //iterator使用泛型
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {

            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        //iterator不适用泛型
        Iterator entries1 = map.entrySet().iterator();
        while (entries1.hasNext()) {
            Map.Entry entry = (Map.Entry) entries1.next();
            Integer key = (Integer)entry.getKey();
            Integer value = (Integer)entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);
        }

        //通过键找值遍历（效率低）
//        作为方法一的替代，这个代码看上去更加干净；但实际上它相当慢且无效率。
//        因为从键取值是耗时的操作（与方法一相比，在不同的Map实现中该方法慢了20%~200%）
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }



        Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("1", 1);
        treeMap.put("3", 3);
        treeMap.put("2", 2);

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Map<String, Integer> treeMap1 = new TreeMap<String, Integer>();
        treeMap1.put("3", 3);
        treeMap1.put("2", 2);
        treeMap1.put("1", 1);

        for (Map.Entry<String, Integer> entry : treeMap1.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        if (treeMap.equals(treeMap1)){
            System.out.println("equals!!!!");
        }

        System.out.println(treeMap.toString());



        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        map2.put(2,2);
        map2.put(1,7);
        map2.put(3, 5);
        Map<Integer, Integer> map2Tree = new TreeMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> entry: map2.entrySet()){
            map2Tree.put(entry.getKey(), entry.getValue());

        }
//        for(Map.Entry<Integer, Integer> entry: map2Tree.entrySet()){
////            map2Tree.put(entry.getKey(), entry.getValue());
//            System.out.println(entry.getKey(), entry.getValue());
//        }


    }
}
