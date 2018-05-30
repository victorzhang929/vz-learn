package com.victorzhang.learn.distributed.rpc.http;

/**
 * 编码枚举
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @create 2018-05-30 17:30:31
 */
public enum Encode {
    UTF_8,
    GBK;

    private byte value;

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
