package problems.interviewbit.strings_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIpAddresses {



    /*public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> ipAddresses = new ArrayList<>();

        for (int i = 1; i <= 12 - A.length(); i++) {
                String regexToConsider="";
                switch (i){
                    case 1: regexToConsider="[1-2][0-5][0-5]?[1-2][0-5][0-5]?[1-2][0-5][0-5]?[1-2][0-5][0-5]?";
                        break;
                    case 2: regexToConsider="[1-2][0-5]?[0-5]?[1-2][0-5]?[0-5]?[1-2][0-5]?[0-5]?[1-2][0-5]?[0-5]?";
                        break;
                    case 3: regexToConsider="(0|[1-2][0-5]?[0-5]?)(0|[1-2][0-5]?[0-5]?)(0|[1-2][0-5]?[0-5]?)(0|[1-2][0-5]?[0-5]?)";
                        break;
                }

                Pattern pattern = Pattern.compile(regexToConsider);
                Matcher matcher= pattern.matcher(A);
                while(matcher.find()){
                    String currentAddress= matcher.group(0);
                    System.out.println(matcher.pattern());
                    if(currentAddress.length()== A.length())
                        ipAddresses.add(currentAddress);
                }
        }
        return ipAddresses;
    }
    
    public List<String> formAddresses(String A){
        List<String> possibleAddresses = new ArrayList<>();
        for (int i = 0; i < ; i++) {
            
        }
    }*/

    public  ArrayList<String> restoreIpAddresses(String s) {
        int len = s.length();
        ArrayList<String> res = new ArrayList<>();
        if (len > 12) {
            return res;
        }

        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,len);

                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }

        return res;
    }

    private static boolean isValid(String s){
        return s.length() <= 3 && !s.isEmpty() && (s.charAt(0) != '0' || s.length() <= 1) && Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        System.out.println(new ValidIpAddresses().restoreIpAddresses("25525511135"));
    }
}
