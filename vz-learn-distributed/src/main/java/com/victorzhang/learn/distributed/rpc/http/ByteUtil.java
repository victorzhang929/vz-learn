package com.victorzhang.learn.distributed.rpc.http;

/**
 * 字节工具
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 18:55:12
 */
public class ByteUtil {

    /**
     * byte转换为int
     *
     * @param bytes
     * @return
     */
    public static int bytes2Int(byte[] bytes) {
        int num = bytes[3] & 0xFF;
        num |= (bytes[2] << 8) & 0xFF00;
        num |= (bytes[1] << 16) & 0xFF0000;
        num |= (bytes[0] << 24) & 0xFF000000;

        return num;
    }

    /**
     * int转换为byte数组
     * @param i
     * @return
     */
    public static byte[] int2ByteArray(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i  & 0xFF);

        return result;
    }


}
