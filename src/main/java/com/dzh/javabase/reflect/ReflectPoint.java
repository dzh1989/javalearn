package com.dzh.javabase.reflect;

/**
 * Created by dongzihui on 16/6/26.
 */
public class ReflectPoint {
    public int x;
    private  int y;
    public String string="helloworld";

    public ReflectPoint(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public String  toString () {
        return "helloworld has changed to "+string;
    }
}