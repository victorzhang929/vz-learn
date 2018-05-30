package com.victorzhang.learn.distributed.rpc.http;

/**
 * Http Response模拟对象
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 17:27:10
 */
public class Response {

    /**
     * 编码
     */
    private byte encode;

    /**
     * 响应长度
     */
    private int responseLength;

    /**
     * 响应信息
     */
    private String response;

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public int getResponseLength() {
        return responseLength;
    }

    public void setResponseLength(int responseLength) {
        this.responseLength = responseLength;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "encode=" + encode +
                ", responseLength=" + responseLength +
                ", response='" + response + '\'' +
                '}';
    }
}
