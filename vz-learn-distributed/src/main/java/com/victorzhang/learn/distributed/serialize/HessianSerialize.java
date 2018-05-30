package com.victorzhang.learn.distributed.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * Hession 对象序列化，相较于Java内置序列化效率较高
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 16:10:20
 */
public class HessianSerialize {

    public static void main(String[] args) throws IOException {
        final Person person = new Person("zhangwei", "123456");
        HessianSerialize serializeUtil = new HessianSerialize();

        byte[] personBytes = serializeUtil.serialize(person);
        System.out.println(serializeUtil.deserialize(personBytes));
    }

    public byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(baos);
        ho.writeObject(object);

        return baos.toByteArray();
    }

    public Object deserialize(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        HessianInput bi = new HessianInput(bais);

        return bi.readObject();
    }
}
