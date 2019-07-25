package problems.interviewbit.strings_problems;

public class CountAndSay {


    public String countAndSay(int A) {

        String sequence = String.valueOf(1);

        for (int i=0; i<A-1 ; i++){

            StringBuilder currentSequence= new StringBuilder();
            int numTimes = 1;
            char currentChar=sequence.charAt(0);
            for (int j = 1; j <= sequence.length(); j++) {
                if(j< sequence.length() && sequence.charAt(j) == currentChar)
                    numTimes++;
                else{
                    currentSequence.append(numTimes);
                    currentSequence.append(currentChar);
                    numTimes=1;
                    if(j< sequence.length())
                        currentChar = sequence.charAt(j);
                    else
                        break;
                }
            }
            sequence=currentSequence.toString();
        }
        return sequence;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(100));
    }
}
