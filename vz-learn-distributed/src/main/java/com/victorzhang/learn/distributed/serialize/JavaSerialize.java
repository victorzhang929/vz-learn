package com.victorzhang.learn.distributed.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * RPC 之 Java 内置对象序列化，相对而言效率较低
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 15:55:27
 */
public class JavaSerialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Person person = new Person("zhangwei", "123456");

        JavaSerialize serializeUtil = new JavaSerialize();
        byte[] personBytes = serializeUtil.serialize(person);
        System.out.println(serializeUtil.deserialize(personBytes));
    }

    public byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);

        return baos.toByteArray();
    }

    public Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bios = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bios);

        return ois.readObject();
    }

}
