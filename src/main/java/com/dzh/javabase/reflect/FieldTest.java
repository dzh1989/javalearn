package com.dzh.javabase.reflect;

import java.lang.reflect.Field;

/**
 * Created by dongzihui on 16/6/26.
 */



public class FieldTest {
    public static void main(String[] args) throws Exception {


        /*
         * Field类解析 Field 提供有关类或接口的单个字段的信息，以及对它的动态访问权限。反射的字段可能是一个类（静态）字段或实例字段。
         * Array 允许在执行 get 或 set 访问操作期间进行扩展转换，但如果将发生收缩转换，则抛出一个
         * IllegalArgumentException。
         */
        System.out.println("Field类解析：");
        ReflectPoint reflectPoint=new ReflectPoint(1, 2);

        Field fieldX=reflectPoint.getClass().getField("x"); //x！=1对应到类字节码的变量，没有对应类对象身上。
        System.out.println(fieldX.get(reflectPoint)); //在reflectPoint具体对象中的变量

        Field fieldY=reflectPoint.getClass().getDeclaredField("y"); //y不可见
        fieldY.setAccessible(true); //暴力反射
        System.out.println(fieldY.get(reflectPoint));

        System.out.println("替换成员变量中的字符实验");
        replaceWord(reflectPoint); //替换成员变量中的字符。
        System.out.println(reflectPoint);

    }
    public static void replaceWord(Object object) throws Exception {
        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            if (field.getType() == String.class) { // 只有一份字节码，所以使用“==”比较，而非equals
                String oldWord = (String) field.get(object);
                String newWord = oldWord.replace("w", "W");
                field.set(object, newWord);
            }
        }
    }
}
