package com.dzh.javabase.fileOperator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by dongzihui on 16/6/18.
 */
public class FileReaderTest {
    public static void main(String[] args) {
        String fileName = System.getProperty("user.dir") + "/src/main/java/com/dzh/javabase/fileOperator/fileWriter.txt";
        File file = new File(fileName);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);   //把数据读入缓存,读取更高效,否则直接用reader读取每次read都要读取文件

            //readline
            String line = br.readLine();
            System.out.println(line);
            line = br.readLine();
            System.out.println(line);
            System.out.println("\n");
            //循环读取每一行
//            while ((line = br.readLine()) != null){
//                System.out.println(line);
//
//            }

            //readchar. 换行符也会被当做字符
            char[] chs = new char[1];
            br.read(chs);
            System.out.println(chs);    //一次读取一个字符
            br.read(chs);
            System.out.println(chs);    //读到了一个换行符

            br.read(chs);
            System.out.println(chs);
            br.read(chs);
            System.out.println(chs);

            //循环读取字符
//            StringBuffer sb = new StringBuffer();
//            int len = 0;
//            while(len != -1){
//                len = br.read(chs);
//                sb.append(chs);
//            }
//            System.out.println(sb.toString());
//
//            System.out.println();

        } catch (Exception e) {

        }

    }
}
