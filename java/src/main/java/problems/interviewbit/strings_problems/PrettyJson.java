package problems.interviewbit.strings_problems;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrettyJson {

    //TODO::check why it is not working
   /* public ArrayList<String> prettyJSON(String A) {

        ArrayList<String> res = new ArrayList<>();
        int offset =0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i)=='{'|| A.charAt(i)=='['){
                stringBuilder.append(A.charAt(i));
                offset++;
                res.add(stringBuilder.toString());
                stringBuilder= addOffset(new StringBuilder(),offset);
            }
            else if (i+1< A.length()&& A.substring(i,i+2).matches(":[^{\\[]")){
                stringBuilder.append(A.charAt(i));
                stringBuilder.append(A.charAt(i+1));
                i++;
            }
            else if(i+1< A.length()&& (A.substring(i,i+2).matches(":\\{")||A.substring(i,i+2).matches(":\\["))){
                stringBuilder.append(":");
                res.add(stringBuilder.toString());
                stringBuilder= addOffset(new StringBuilder(),offset);
                stringBuilder.append(A.charAt(i+1));
                offset++;
                res.add(stringBuilder.toString());
                stringBuilder = addOffset(new StringBuilder(),offset);
            }
            else if(A.charAt(i)==','){
                stringBuilder.append(",");
                res.add(stringBuilder.toString());
                stringBuilder = addOffset(new StringBuilder(),offset);
            }
            else if(i+1< A.length() && A.substring(i, i+2).matches("[^,}\\]][}\\]]")){
                stringBuilder.append(A.charAt(i));
                offset--;
                res.add(stringBuilder.toString());
                stringBuilder = addOffset(new StringBuilder(),offset);
                stringBuilder.append(A.charAt(i+1));
                i++;
            }
            else if(A.charAt(i)==']' ||A.charAt(i)=='}'){
                if (!stringBuilder.toString().isEmpty()) {
                    res.add(stringBuilder.toString());
                }
                offset--;
                stringBuilder = addOffset(new StringBuilder(),offset);
                stringBuilder.append(A.charAt(i));
                res.add(stringBuilder.toString());
                stringBuilder=new StringBuilder();
            }
            else{
                stringBuilder.append(A.charAt(i));
            }
        }

        return res;
    }*/

    public ArrayList<String> prettyJSON(String a) {
        ArrayList<String> result = new ArrayList<String>();
        int tabCounter = 0;
        StringBuffer current = new StringBuffer();
        for(int i=0; i<a.length(); i++) {
            char c = a.charAt(i);
            switch(c) {
                case '{':
                case '[':
                    if(current.length() > 0) {
                        result.add(current.toString());
                        current = new StringBuffer();
                    }
                    for(int j=0; j<tabCounter; j++) {
                        current.append('\t');
                    }
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuffer();
                    tabCounter++;
                    break;

                case ']':
                case '}':
                    if(current.length() > 0) {
                        result.add(current.toString());
                        current = new StringBuffer();
                    }
                    tabCounter--;
                    for(int j=0; j<tabCounter; j++) {
                        current.append('\t');
                    }
                    current.append(c);
                    break;

                case ',':
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuffer();
                    break;

                default:
                    if(current.length() == 0) {
                        for(int j=0; j<tabCounter; j++) {
                            current.append('\t');
                        }
                    }
                    current.append(c);
            }
        }

        if(current.length() > 0) {
            result.add(current.toString());
        }

        return result;
    }


    public StringBuilder addOffset(StringBuilder res, int numTimes){
        for (int i = 0; i < numTimes; i++) {
            res.append("\t");
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> res= new PrettyJson().prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
        for (String re : res) {
            System.out.println(re);
        }
    }
}
