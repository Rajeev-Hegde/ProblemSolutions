package problems.interviewbit.strings_problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareVersionNumbers {


    public int compareVersion(String A, String B) {
        List<String>versionNumber1Details= Arrays.stream(A.split("\\.")).collect(Collectors.toList());
        List<String>versionNumber2Details= Arrays.stream(B.split("\\.")).collect(Collectors.toList());

        for (int i = 0; i < versionNumber1Details.size() && i< versionNumber2Details.size(); i++) {
            String str1=versionNumber1Details.get(i).replaceAll("^0*","");
            if (str1.equals(""))
                str1="0";
            String str2=versionNumber2Details.get(i).replaceAll("^0*","");
            if (str2.equals(""))
                str2="0";
            int j=new BigInteger(str1)
                    .compareTo(new BigInteger(str2));
            if (j== 0)
                continue;
            return j;
        }

        if(versionNumber1Details.size() == versionNumber2Details.size())
            return 0;
        else if(versionNumber1Details.size()> versionNumber2Details.size()) {
            return checkIfAllZero(versionNumber1Details, versionNumber2Details.size())? 0: 1;
        }
        return checkIfAllZero(versionNumber2Details,versionNumber1Details.size())? 0:-1;
    }

    private boolean checkIfAllZero(List<String> versionDetails, int fromIndex){
        String abc = String.join("",versionDetails.subList(fromIndex,versionDetails.size()));
        return abc.matches("0*");
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("445345435365654656547875647546765865756365467564543567463553467875676586576","445345435365654656547875647546765865756365467564543567463553467875676586577"));
    }
}
