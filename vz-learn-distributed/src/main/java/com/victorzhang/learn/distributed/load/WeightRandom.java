package com.victorzhang.learn.distributed.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 负载均衡算法：加权随机法
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 20:35:20
 */
public class WeightRandom {

    public static void main(String[] args) {
        Map<String, Integer> serverMap = new HashMap<>(RoundRobin.serverWeightMap);
        List<String> serverList = new ArrayList<>(serverMap.size());

        for (Map.Entry<String, Integer> entry : serverMap.entrySet()) {
            String server = entry.getKey();
            int weight = entry.getValue();
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(serverList.size());

        String server = serverList.get(randomPos);
        System.out.println(server);
    }
}
