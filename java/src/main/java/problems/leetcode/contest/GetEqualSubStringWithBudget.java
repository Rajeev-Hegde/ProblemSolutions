package problems.leetcode.contest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GetEqualSubStringWithBudget {


    public int equalSubstring(String s, String t, int maxCost) {
        int res=0;
        List<Integer> costList = new ArrayList<>();
        for(int i=0; i< s.length(); i++){
            costList.add(Math.abs(s.charAt(i)- t.charAt(i)));
        }
        for(int i=0; i< s.length(); i++){
            int len=0, j=i;
            int currentCost=maxCost;
            while(j< s.length() && costList.get(j)<= currentCost){
                currentCost-=Math.abs(s.charAt(j)- t.charAt(j));
                len++;
                j++;
            }
            if(len> res)
                res=len;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GetEqualSubStringWithBudget()
                .equalSubstring("abcd", "cdef", 0));
        //"krrgw"
        //"zjxss"
        //19
    }
}
