package com.victorzhang.learn.distributed.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Tcp Rpc 服务提供者
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 16:57:17
 */
public class TcpRpcProvider {

    /**
     * 获取具体服务对象，可以通过webservice方式，或者Http方式获取
     */
    private static final Map<String, String> SERVICES = new HashMap(2) {
        {
            put("com.victorzhang.learn.distributed.rpc.SayHelloService", new SayHelloServiceImpl());
        }
    };

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String interfaceName = ois.readUTF();
            String methodName = ois.readUTF();
            Class<?>[] parameterTypes = (Class<?>[]) ois.readObject();
            Object[] arguments = (Object[]) ois.readObject();

            Class serviceInterfaceClass = Class.forName(interfaceName);
            Method method = serviceInterfaceClass.getMethod(methodName, parameterTypes);
            Object result = method.invoke(SERVICES.get(interfaceName), arguments);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(result);
        }
    }
}
