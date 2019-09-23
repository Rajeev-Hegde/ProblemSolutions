package problems.leetcode.top_interview_questions;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 Given an encoded string, return its decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    String getQueueContent(Deque<String> deque){
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }


    //Working solution, but not necessarily an efficient solution
    public String decodeString(String s) {
        Deque<String> deque = new LinkedList<>();
        int i=0;
        while(i< s.length()){
            char ch = s.charAt(i);
            if(ch==']'){
                StringBuilder st = new StringBuilder("");
                while(!deque.peekLast().equals("[")){
                    st.insert(0,deque.removeLast());
                }
                deque.removeLast();
                String currentString= st.toString();
                int repeatCount= Integer.valueOf(deque.removeLast());
                deque.addLast(new String(new char[repeatCount]).replace("\0", currentString));
            }
            else if(!String.valueOf(ch).matches("[a-zA-Z\\[\\]]")){
                String num="";
                while(true){
                    num+=ch;
                    ch= s.charAt(i+1);
                    if(String.valueOf(ch).matches("[a-zA-Z\\[\\]]")){
                        deque.addLast(num);
                        break;
                    }
                    i++;
                }
            }
            else
                deque.addLast(String.valueOf(ch));
            i++;
        }
        return getQueueContent(deque);
    }
}
