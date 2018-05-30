package com.victorzhang.learn.distributed.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 负载均衡算法：轮询法
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 20:10:20
 */
public class RoundRobin {

    public static final Map<String, Integer> serverWeightMap = new HashMap(16) {
        {
            put("192.168.0.100", 1);
            put("192.168.0.101", 1);
            put("192.168.0.102", 4);
            put("192.168.0.103", 1);
            put("192.168.0.104", 1);
            put("192.168.0.105", 3);
            put("192.168.0.106", 1);
            put("192.168.0.107", 2);
            put("192.168.0.108", 1);
            put("192.168.0.109", 1);
            put("192.168.0.110", 1);
        }
    };

    public static void main(String[] args) {
        Map<String, Integer> serverMap = new HashMap<>(serverWeightMap);
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        String server;
        Integer pos = 0;
        //重量级悲观锁影响程序性能
        synchronized (pos) {
            if (pos > keySet.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;
        }
        System.out.println(server);
    }
}
