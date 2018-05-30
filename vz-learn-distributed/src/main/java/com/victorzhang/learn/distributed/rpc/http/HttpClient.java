package com.victorzhang.learn.distributed.rpc.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Http 客户端模拟
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 17:29:16
 */
public class HttpClient {

    public static void main(String[] args) throws Exception {
        Request request = new Request();
        request.setEncode(Encode.UTF_8.getValue());
        request.setCommand("HELLO");
        request.setCommandLength(request.getCommand().length());

        Socket client = new Socket("127.0.0.1", 4567);
        OutputStream output = client.getOutputStream();

        ProtocolUtil.writeRequest(output, request);

        InputStream input = client.getInputStream();
        Response response = ProtocolUtil.readResponse(input);
        System.out.println(response);
    }
}
