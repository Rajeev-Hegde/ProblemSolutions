package contests;

import java.util.*;

public class MaximumConsecutiveCharacters {


    private static char getMaxOccurredCharacter(String charactersStr){

        char[] charArray = charactersStr.toCharArray();
        Character overAllMaxChar = null;
        int overAllMaxCount=0;
        Character currentMaxCharacter = null;
        int currentMaxCount=0;
        for(char ch: charArray){
            if(currentMaxCharacter == null){
                currentMaxCharacter = ch;
                currentMaxCount=1;
            }
            if(ch == currentMaxCharacter)
                currentMaxCount++;
            else{
                if(currentMaxCount > overAllMaxCount) {
                    overAllMaxCount = currentMaxCount;
                    overAllMaxChar = currentMaxCharacter;

                    currentMaxCount = 1;
                    currentMaxCharacter = ch;
                }
            }
        }
        if(currentMaxCount> overAllMaxCount)
            return currentMaxCharacter;
        return overAllMaxChar;
    }

    public static void main(String[] args) {
        System.out.println(MaximumConsecutiveCharacters.getMaxOccurredCharacter("geeekk"));
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        map.entrySet().stream().filter(entry-> entry.getValue()==1).findFirst().get().getValue();
    }
}
