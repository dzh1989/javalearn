package com.dzh.javabase.serializableOperator;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

/**
 * Created by dongzihui on 16/7/3.
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception {
//        String fileName = System.getProperty("user.dir") + "/src/main/java/com/dzh/javabase/fileOperator/fileOutputStream.txt";
//        String fileName = System.getProperty("java.class.path");
//        String fileName = Class.class.getClass().getResource("").getPath();
//        System.out.println(fileName);

//
//        File directory = new File("");//设定为当前文件夹
//        try{
//            System.out.println(directory.getCanonicalPath());//获取标准的路径
//            System.out.println(directory.getAbsolutePath());//获取绝对路径
//        }catch(Exception e){}

        SerializePerson();//序列化Person对象
        Person p = DeserializePerson();//反序列Perons对象
        System.out.println(MessageFormat.format("name={0},age={1},sex={2}",
                p.getName(), p.getAge(), p.getSex()));
    }

    /**
     * MethodName: SerializePerson
     * Description: 序列化Person对象
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @author xudp
     */
    private static void SerializePerson() throws FileNotFoundException,
            IOException {
                String fileName = System.getProperty("user.dir") + "/src/main/java/com/dzh/javabase/serializableOperator/person.txt";

        Person person = new Person();
        person.setName("gacl");
        person.setAge(25);
        person.setSex("男");
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File(fileName)));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    /**
     * MethodName: DeserializePerson
     * Description: 反序列Perons对象
     *
     * @return
     * @throws Exception
     * @throws IOException
     * @author xudp
     */
    private static Person DeserializePerson() throws Exception, IOException {
        String fileName = System.getProperty("user.dir") + "/src/main/java/com/dzh/javabase/serializableOperator/person.txt";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(fileName)));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }

}