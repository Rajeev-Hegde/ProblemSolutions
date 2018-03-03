import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    //Checks if two strings are anagrams
    public static boolean isTwoStringsAnagram(String s1, String s2,boolean caseSensitive){
        char[] seq1= s1.toCharArray();
        char[] seq2= s2.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : seq1) {
            Character finalCh= caseSensitive? ch: Character.toLowerCase(ch);
            map.putIfAbsent(finalCh, 0);
            map.computeIfPresent(finalCh, (k,v) -> v+1);
        }
        int i=0;
        while (i<seq2.length){
            Character finalCh= caseSensitive?seq2[i]:Character.toLowerCase(seq2[i]);
            if (map.get(finalCh)==null|| (map.get(finalCh)-1)<0)
                return false;
            map.put(finalCh,map.get(finalCh)-1);
            i++;
        }
        final boolean[] valid = {true};
        map.forEach((key,value)->{
            if(value!=0){
                valid[0] =false;
            }
        });
        return valid[0];
    }

    public static void main(String[] args) {
        String s1="Abul";
        String s2="BulA";

        System.out.println(isTwoStringsAnagram(s1,s2,false)? "Anagrams": "Not Anagrams");
    }
}
