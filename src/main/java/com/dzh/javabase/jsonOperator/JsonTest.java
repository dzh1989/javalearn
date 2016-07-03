package com.dzh.javabase.jsonOperator;

import org.json.JSONObject;
//import com.alibaba.fastjson.JSONObject;


import java.util.Iterator;

/**
 * Created by dongzihui on 16/6/26.
 */
public class JsonTest {
    public static void main(String[] args){
        String str = "{\"a\":\"b\", \"c\":\"d\", \"e\":{\"f\":\"g\"}}";
        JSONObject a = new JSONObject(str);
        System.out.println(a); // {"c":"d","a":"b"}
        System.out.println(a.get("c")); // d
        System.out.println(a.get("e")); // d
        Iterator<String> keys = a.keys();
        while(keys.hasNext()){
            System.out.println(keys.next());
        }


//        for(String key :keys){
//
//        }
//        System.out.println(a.);
    }
}
