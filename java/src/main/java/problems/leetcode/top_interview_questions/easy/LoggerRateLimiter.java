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
}
