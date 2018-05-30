package com.victorzhang.learn.distributed.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 负载均衡算法：加权轮询法
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 20:29:10
 */
public class WeightRoundRobin {

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

        Integer pos = 0;
        String server;
        synchronized (pos) {
            if(pos > serverList.size()) {
                pos = 0;
            }
            server = serverList.get(pos);
            pos++;
        }
        System.out.println(server);
    }
}
