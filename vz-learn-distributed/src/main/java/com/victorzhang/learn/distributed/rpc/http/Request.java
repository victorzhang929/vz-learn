package com.victorzhang.learn.distributed.rpc.http;

/**
 * Http Request模拟对象
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 17:25:11
 */
public class Request {

    /**
     * 编码
     */
    private byte encode;

    /**
     * 命令
     */
    private String command;

    /**
     * 命令长度
     */
    private int commandLength;

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getCommandLength() {
        return commandLength;
    }

    public void setCommandLength(int commandLength) {
        this.commandLength = commandLength;
    }

    @Override
    public String toString() {
        return "Request{" +
                "encode=" + encode +
                ", command='" + command + '\'' +
                ", commandLength=" + commandLength +
                '}';
    }
}
