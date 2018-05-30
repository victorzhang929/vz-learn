package com.victorzhang.learn.distributed.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Tcp Rpc消费者
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 16:52:43
 */
public class TcpRpcConsumer {

    public static void main(String[] args) throws NoSuchMethodException, IOException, ClassNotFoundException {
        String interfaceName = SayHelloService.class.getName();
        Method method = SayHelloService.class.getMethod("sayHello", String.class);
        Object[] argruments = {"hello"};

        Socket socket = new Socket("127.0.0.1", 1234);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeUTF(interfaceName);
        oos.writeUTF(method.getName());
        oos.writeObject(method.getParameterTypes());
        oos.writeObject(argruments);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Object result = ois.readObject();
    }
}
