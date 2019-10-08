package problems.leetcode.top_interview_questions.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerRateLimiter {

    Map<Integer, List<String>> timeStampVsMessages;
    Map<String,Integer> messageVsTimeStamp;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        this.timeStampVsMessages = new HashMap<>();
        this.messageVsTimeStamp = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(messageVsTimeStamp.containsKey(message) &&
                (timestamp- messageVsTimeStamp.get(message))<10)
            return false;
        else{
            timeStampVsMessages.putIfAbsent(timestamp, new ArrayList<>());
            timeStampVsMessages.get(timestamp).add(message);
            messageVsTimeStamp.put(message,timestamp);
            return true;
        }

    }

    private Map<String, Integer> ok = new HashMap<>();
    public boolean shouldPrintMessageFasterApproach(int timestamp, String message) {
        if (timestamp < ok.getOrDefault(message, 0))
            return false;
        ok.put(message, timestamp + 10);
        return true;
    }


    private Map<String, Integer> msgMap = new HashMap<>();
    private static final Object lock= new Object();
    public boolean shouldPrintMessageSynchronised(int timestamp, String message) {
        Integer ts = msgMap.get(message);
        if (ts == null || timestamp - ts >= 10) {
            synchronized (lock) {
                Integer ts2 = msgMap.get(message);
                if (ts == null || timestamp - ts2 >= 10) {
                    msgMap.put(message, timestamp);
                    return true;
                }
            }
        }
        return false;
    }
}
