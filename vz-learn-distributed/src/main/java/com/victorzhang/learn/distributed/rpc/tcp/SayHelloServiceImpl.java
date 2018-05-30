package com.victorzhang.learn.distributed.rpc.tcp;

import org.apache.commons.lang3.StringUtils;

/**
 * 问好服务实现
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 16:45:27
 */
public class SayHelloServiceImpl implements SayHelloService {

    private static final String HELLO = "hello";
    private static final String BYE_BYE = "bye bye";

    @Override
    public String sayHello(String say) {
        if (StringUtils.equals(say, HELLO)) {
            return HELLO;
        }
        return BYE_BYE;
    }
}
