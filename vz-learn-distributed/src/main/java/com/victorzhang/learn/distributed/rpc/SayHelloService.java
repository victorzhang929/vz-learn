package com.victorzhang.learn.distributed.rpc;

/**
 * Say Hello服务
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @create 2018-05-30 16:43:38
 */
public interface SayHelloService {

    /**
     * 问好接口
     * @param say
     * @return
     */
    String sayHello(String say);
}
