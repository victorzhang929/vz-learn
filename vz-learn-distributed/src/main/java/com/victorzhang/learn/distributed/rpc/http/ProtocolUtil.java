package com.victorzhang.learn.distributed.rpc.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 协议工具
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 18:52:41
 */
public class ProtocolUtil {

    /**
     * 获取Request对象
     * @param input
     * @return
     * @throws IOException
     */
    public static Request readRequest(InputStream input) throws IOException {
        byte[] encodeByte = new byte[1];
        input.read(encodeByte);
        byte encode = encodeByte[0];

        byte[] commandLengthBytes = new byte[4];
        input.read(commandLengthBytes);
        int commandLength = ByteUtil.bytes2Int(commandLengthBytes);

        byte[] commandBytes = new byte[commandLength];
        input.read(commandBytes);
        String command;
        if (Encode.GBK.getValue() == encode) {
            command = new String(commandBytes, "GBK");
        } else {
            command = new String(commandBytes, "UTF8");
        }

        Request request = new Request();
        request.setEncode(encode);
        request.setCommand(command);
        request.setCommandLength(commandLength);

        return request;
    }

    /**
     * 获取Response对象
     * @param input
     * @return
     * @throws IOException
     */
    public static Response readResponse(InputStream input) throws IOException {
        byte[] encodeByte = new byte[1];
        input.read(encodeByte);
        byte encode = encodeByte[0];

        byte[] responseLengthByte = new byte[4];
        input.read(responseLengthByte);
        int responseLength = ByteUtil.bytes2Int(responseLengthByte);

        byte[] responseByte = new byte[responseLength];
        input.read(responseByte);
        String responseInfo;
        if (Encode.GBK.getValue() == encode) {
            responseInfo = new String(responseByte, "GBK");
        } else {
            responseInfo = new String(responseByte, "UTF8");
        }

        Response response = new Response();
        response.setEncode(encode);
        response.setResponseLength(responseLength);
        response.setResponse(responseInfo);

        return response;
    }

    /**
     * OutputStream写入Response对象
     * @param output
     * @param response
     * @throws IOException
     */
    public static void writeResponse(OutputStream output, Response response) throws IOException {
        output.write(response.getEncode());
        output.write(ByteUtil.int2ByteArray(response.getResponseLength()));
        if (Encode.GBK.getValue() == response.getEncode()) {
            output.write(response.getResponse().getBytes("GBK"));
        } else {
            output.write(response.getResponse().getBytes("UTF8"));
        }

        output.flush();
    }

    /**
     * OutStream写入Request对象
     * @param output
     * @param request
     * @throws IOException
     */
    public static void writeRequest(OutputStream output, Request request) throws IOException {
        output.write(request.getEncode());
        output.write(ByteUtil.int2ByteArray(request.getCommandLength()));
        if (Encode.GBK.getValue() == request.getEncode()) {
            output.write(request.getCommand().getBytes("GBK"));
        } else {
            output.write(request.getCommand().getBytes("UTF8"));
        }

        output.flush();
    }
}