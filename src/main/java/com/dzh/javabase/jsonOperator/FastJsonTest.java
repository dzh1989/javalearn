package com.dzh.javabase.jsonOperator;

import com.alibaba.fastjson.*;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.json.*;
import sun.util.resources.CalendarData_ms_MY;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by dongzihui on 16/6/26.
 */
public class FastJsonTest {

    private Map<String, Object> map = new HashMap<String, Object>();


    public void MyParserClassObject(String parentName, Object obj) throws Exception{
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field:
             fields) {
//            System.out.println(field);
            int modifyiers = field.getModifiers();
            if(Modifier.isStatic(modifyiers)){
                continue;
            }
            String fieldName = null;
            if(!parentName.equals("")){
                fieldName = parentName + "." + field.getName();
            }else{
                fieldName = field.getName();

            }
            field.setAccessible(true);  //暴力反射
            Object value = field.get(obj);
//            if (!parentName.equals("")){

//            }
//            System.out.println(fieldName + " " + value + " " + value.getClass());

            if (value instanceof Collection) {
                Iterator it = ((Collection) value).iterator();
                int count = 0;
                while (it.hasNext()) {
                    MyParserClassObject(fieldName+"."+String.valueOf(count), it.next());
                    count ++ ;
                }
            }
            else if (value instanceof Map) {
//                Map<?,?> mapBuf = (Map<?,?>)value;
                System.out.println(value.getClass());
                for (Map.Entry<?,?> entry :((Map<?,?>)value).entrySet()){
                    System.out.println(entry.getKey().toString());
                    System.out.println(entry.getValue() + "type" + entry.getValue().getClass());
//                    MyParserClassObject(entry.getKey().toString(), entry.getValue());

                }
            }
            else {
                map.put(fieldName, value);
            }
        }

    }


    public void MyParserJsonObject(String parentName, Object obj) {
        String jsonString = JSONObject.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(jsonString);

        //decode to class object
//        Group decodeGroup = JSON.parseObject(jsonString, Group.class);
//        System.out.println(decodeGroup.getName());


        //decode string to jsonobject
//        JSONObject decodeGroupJsonObj = JSON.parseObject(jsonString);
        JSONObject decodeGroupJsonObj = JSONObject.parseObject(jsonString);
//        System.out.println(decodeGroupJsonObj.toString());
//        System.out.println(decodeGroupJsonObj.keySet().toString());
        for (JSONObject.Entry<String, Object> entry : decodeGroupJsonObj.entrySet()) {
            String name = null;
            if (!parentName.equals("")) {
                name = parentName + "." + entry.getKey();
            } else {
                name = entry.getKey();
            }
            Object value = entry.getValue();

            //            if(value instanceof List){
//                for(int i = 0; i<((List) value).size(); i++){
//                    MyParserJsonObject(name, ((List) value).get(i));
//                }
//
//            }

            if (value instanceof Collection) {
                Iterator it = ((Collection) value).iterator();
                int count = 0;
                while (it.hasNext()) {
                    MyParserJsonObject(name+"."+String.valueOf(count), it.next());
                    count ++ ;
                }
//
//                for(int i=0; i<((Collection)value).size(); i++){
//                    MyParserJsonObject(name, ((Collection) value).);  //为什么这种方式无法访问Collection
//                }
            } else if (value instanceof JSONObject) {
                MyParserJsonObject(name, value);
            } else {
                map.put(name, value);
            }
        }


//        JSONObject decodeGroupJsonObj = JSONObject.parseObject(jsonString);
//        该种遍历方法效率低
//        for (String key:
//                decodeGroupJsonObj.keySet()) {
////            System.out.println(key);
//            Object value = decodeGroupJsonObj.get(key);
////            System.out.println("key:"+key+ " -- value:"+ value + " -- valueType:" + value.getClass());
//            if(value instanceof List){
//                for(int i=0; i<((List) value).size(); i++) {
////                    System.out.println(((List) value).get(i));
////                    System.out.println(((List) value).get(i).getClass());
//                    MyParserJsonObject(key, ((List) value).get(i));
//                }
//            }else{
//                this.map.put(parentName + "." + key, value);
//            }
//
//        }
    }


    public void printMap() {
        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());

        }
    }

    public void clear(){
        this.map.clear();
    }

    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("testkey1", 100);
        Map<String, Map<String, Integer>> map2 = new HashMap<String, Map<String, Integer>>();
        map2.put("testkey2", map1);
        group.setMap(map2);
//

        System.out.println(group.getName());
        System.out.println(group.getMap());
        FastJsonTest a = new FastJsonTest();
        a.MyParserJsonObject("", group);
        a.printMap();
        a.clear();
        System.out.println("------------------------------------------");

        FastJsonTest b = new FastJsonTest();
        try {
            b.MyParserClassObject("", group);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        b.printMap();

    }
}
