package com.dzh.javabase.fileOperator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by dongzihui on 16/6/18.
 */
public class FileOutputStreamTest {
    public static void main(String[] args){
        String fileName = System.getProperty("user.dir") + "/src/main/java/com/dzh/javabase/fileOperator/fileOutputStream.txt";

        try {
            FileOutputStream fos=new FileOutputStream(fileName);

            fos.write("fafaf".getBytes());          //没有缓存,直接写入到文件中去了
            for (int i = 0; i < 100; i++) {
                fos.write((String.valueOf(i) + "\n").getBytes());
            }
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
