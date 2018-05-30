package com.victorzhang.learn.distributed.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 负载均衡算法：源地址Hash
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 20:23:37
 */
public class Hash {

    public static void main(String[] args) {
        System.out.println(consumerHash("10.0.30.198"));
    }

    /**
     * 根据请求地址Ip进行HashCode，查找对应的服务器地址。
     * 一般情况，如果服务器的集群没有变动的话，一个请求Ip基本上永远对应着固定的服务器地址
     * @param remoteIp
     * @return
     */
    public static String consumerHash(String remoteIp) {
        Map<String, Integer> serverMap = new HashMap<>(RoundRobin.serverWeightMap);

        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int hashCode = remoteIp.hashCode();
        int serverListSize = keyList.size();

        int serverPos = hashCode % serverListSize;
        return keyList.get(serverPos);
    }
}
