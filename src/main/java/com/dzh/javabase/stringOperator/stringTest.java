package com.dzh.javabase.stringOperator;

/**
 * Created by dongzihui on 16/6/18.
 */
public class stringTest {


    public static  String modify(String s){
        s += "aaaa";
        return s;
    }
    public static void main(String[] args) {
        System.out.println("fdaf");

        String s = "[1]java.util.ArrayListxxxxxx";
//        String s1 = "";
        if(s.contains("[1]java.util.ArrayList")){
            s = s.replaceFirst("java.util.ArrayList", "java.util.List");
        }
        System.out.println(s);


        String s1 = "abc";
        s1 = modify(s1);
        s1 = modify(s1);
        System.out.println(s1);
    }
}
