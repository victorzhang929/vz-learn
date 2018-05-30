package com.victorzhang.learn.distributed.json;

import java.io.StringWriter;

import com.victorzhang.learn.distributed.serialize.Person;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * JSON工具类
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 19:30:54
 */
public class JsonUtil {

    public static void main(String[] args) throws Exception {
        Person person = new Person("zhangwei", "123456");
        String personJson;

        StringWriter sw = new StringWriter();
        JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(gen, person);
        gen.close();
        personJson = sw.toString();

        System.out.println(personJson);
    }
}
