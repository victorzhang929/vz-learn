package com.victorzhang.learn.distributed.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 负载均衡算法：随机法
 * 在并发量足够的情况下，近似和轮询法一致，而且不用进行加锁，保证性能优先
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 20:18:48
 */
public class Random {

    public static void main(String[] args) {
        Map<String, Integer> serverMap = new HashMap<>(RoundRobin.serverWeightMap);

        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(keyList.size());

        String server = keyList.get(randomPos);
        System.out.println(server);
    }
}
