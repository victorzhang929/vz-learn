package com.victorzhang.learn.distributed.rpc.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.lang3.StringUtils;

/**
 * Http服务端
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 19:19:11
 */
public class HttpServer {

    private static final String HELLO = "hello";
    private static final String BYE_BYE = "bye bye";

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(4567);

        while (true) {
            Socket client = server.accept();

            InputStream input = client.getInputStream();
            Request request = ProtocolUtil.readRequest(input);

            OutputStream output = client.getOutputStream();
            Response response = new Response();
            response.setEncode(Encode.UTF_8.getValue());
            if (StringUtils.equals(request.getCommand(), HELLO)) {
                response.setResponse(HELLO);
            } else {
                response.setResponse(BYE_BYE);
            }

            response.setResponseLength(response.getResponse().length());
            ProtocolUtil.writeResponse(output, response);
        }
    }
}
