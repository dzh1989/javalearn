package com.dzh.javabase.fileOperator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dongzihui on 16/6/19.
 */
public class FileInputStreamTest {
    public static void main(String[] args){
        String fileName = System.getProperty("user.dir") + "/src/main/java/com/dzh/javabase/fileOperator/fileOutputStream.txt";
        try {
            FileInputStream fis=new FileInputStream(new File(fileName));//新建一个FileInputStream对象
            try {
                byte[] b=new byte[fis.available()];//新建一个字节数组
                fis.read(b);//将文件中的内容读取到字节数组中
                fis.close();

//                String str2=new String(b);//再将字节数组中的内容转化成字符串形式输出
//                System.out.println(str2);

                StringBuffer str2 = new StringBuffer();
                str2.append(new String(b));
                System.out.println(str2.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
