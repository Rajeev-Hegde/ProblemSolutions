package problems.interviewbit.strings_problems;

public class ReverseWordsString {


    public String reverseWords(String a) {
        StringBuilder finalString= new StringBuilder();
        char[] charArray = a.toCharArray();
        int i= charArray.length-1;
        while (i>0 && charArray[i]==' ')
            i--;
        for (; i >=0; i--) {
            int j=i;
            while(j>=0 && charArray[j]!=' ')
                j--;
            int pos=j+1;
            for(int l=j+1; l<= i; l++)
                finalString.append(charArray[l]);
            i=pos-1;
            if(i>0)
                finalString.append(" ");
        }
        return finalString.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsString().reverseWords("the sky is blue"));
    }
}
