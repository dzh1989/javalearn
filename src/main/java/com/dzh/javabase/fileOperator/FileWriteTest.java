package com.dzh.javabase.fileOperator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by dongzihui on 16/6/18.
 */


/**
 * FileWriter
 *  FileWriter is meant for writing streams of characters. For writing streams of raw bytes, consider using a FileOutputStream.
 */
public class FileWriteTest {
    public static void main(String[] args) {
        try {
            String fileName = System.getProperty("user.dir") + "/src/main/java/com/dzh/javabase/fileOperator/fileWriter.txt";
            FileWriter f = new FileWriter(fileName);

            //使用BufferedWriter
            BufferedWriter bw = new BufferedWriter(f);
            for (int i = 0; i < 100; i++){
                bw.write(String.valueOf(i) + "\n");
            }
            bw.flush();   //不flush不会写文件
            f.close();


            //直接使用FilieWriter写
//            for(int i=0; i<100; i++){
//                f.write(String.valueOf(i) + "\n");
//            }
//            f.flush();    //flush之后才会写入文件
            //Closes the stream, flushing it first
//            f.close();          //如果不flush,则必须得close,否则写入的字符都在缓存,不会真正写入到文件中去.







        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
