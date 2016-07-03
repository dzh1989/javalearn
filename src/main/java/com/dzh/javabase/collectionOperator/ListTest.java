package com.dzh.javabase.collectionOperator;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by dongzihui on 16/6/22.
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<String>();
        lst.add("abd");
        lst.add("ddg");
        lst.add("bgd");
        Collections.sort(lst);
        String s = "";
        for(String i : lst){
            s += "_" + i;
        }
        s = StringUtils.strip(s, "_");
        s = s.substring(0,4);
        System.out.println(s);

        String a = "a.b.c.d";
        String[] l = a.split("\\.");
        System.out.println(Arrays.toString(l));
        System.out.println(l.length);

        for(int i=0; i<l.length; i++){
            if (!l[i].equals("a") && !l[i].equals("c") && !l[i].equals("d")) {

                System.out.println(l[i]);
            }
        }


    }
}
