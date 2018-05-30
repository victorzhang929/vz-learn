package com.victorzhang.learn.distributed.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.victorzhang.learn.distributed.serialize.Person;

/**
 * Xml工具类
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 19:39:31
 */
public class XmlUtil {

    public static void main(String[] args) {
        Person person = new Person("zhangwei", "123456");

        XStream xStream = new XStream(new DomDriver());
        xStream.alias("person", Person.class);

        String personXml = xStream.toXML(person);
        System.out.println(personXml);

        Person personFromXml = (Person) xStream.fromXML(personXml);
        System.out.println(personFromXml);
    }
}
