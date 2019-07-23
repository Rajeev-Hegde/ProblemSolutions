package com.core.contests;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceCapacity {


    static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {

        int agentsToAdd=0;

        for(int i=0; i< callsTimes.size(); i++){
            for(int j=0; j< callsTimes.size(); j++){
                if(j!=i){
                    if(callsTimes.get(i).get(1) >= callsTimes.get(j).get(0) &&
                            callsTimes.get(i).get(1) < callsTimes.get(j).get(1)){
                        agentsToAdd++;
                    }
                }
            }
        }
        return (agentsToAdd - noOfCurrentAgents)>0? agentsToAdd - noOfCurrentAgents : 0;
    }
}
