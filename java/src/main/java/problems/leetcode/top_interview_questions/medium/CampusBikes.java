package problems.leetcode.top_interview_questions.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * IMPORTANT
 */
public class CampusBikes {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        boolean[] worker = new boolean[workers.length];
        boolean[] bike = new boolean[bikes.length];

        for(int i = 0; i < workers.length; ++i){
            for(int j = 0; j < bikes.length; ++j){
                int dis = getDis(workers[i], bikes[j]);
                if(map.containsKey(dis)){
                    List<int[]> tmp = map.get(dis);
                    int[] pair = new int[]{i, j};
                    tmp.add(pair);
                }
                else{
                    List<int[]> tmp = new ArrayList<>();
                    int[] pair = new int[]{i, j};
                    tmp.add(pair);
                    map.put(dis, tmp);
                }
            }
        }

        int[] result = new int[worker.length];
        for(int key: map.keySet()){
            List<int[]> tmp = map.get(key);
            for(int[] t: tmp){
                if(!worker[t[0]] && !bike[t[1]]){
                    result[t[0]] = t[1];
                    worker[t[0]] = true;
                    bike[t[1]] = true;
                }
            }
        }

        return result;
    }

    private int getDis(int[] worker, int[] bike){
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
