package com.core.contests;

public class StartEncoding {


    public static String collapseString(String inputString) {
        if(inputString==null || inputString=="")
            return "";
        char currentChar=inputString.charAt(0);
        int currentCharRepeatCount=1;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < inputString.length(); i++) {
            if(currentChar!= inputString.charAt(i)){
                res.append(currentCharRepeatCount);
                res.append(currentChar);
                currentChar=inputString.charAt(i);
                currentCharRepeatCount=1;
            }
            else
                currentCharRepeatCount++;
        }
        res.append(currentCharRepeatCount);
        res.append(currentChar);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(StartEncoding.collapseString(""));
    }
}
