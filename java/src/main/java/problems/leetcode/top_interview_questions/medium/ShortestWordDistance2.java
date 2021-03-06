package problems.leetcode.top_interview_questions.medium;


/**
 * IMPORTANT
 */
public class ShortestWordDistance2 {

    public int shortestWordDistance(String[] words, String word1, String word2) {

        int index1 = -1,index2=-1, shortDist = Integer.MAX_VALUE;

        for(int i = 0;i<words.length;i++)
        {
            if(words[i].equals(word1))
            {
                index1 = i;

                if(index2 > -1 && index1 != index2)
                    shortDist = Math.min(shortDist,Math.abs(index1-index2));
            }

            if(words[i].equals(word2))
            {
                index2 = i;

                if(index1 > -1 && index1 != index2)
                    shortDist = Math.min(shortDist,Math.abs(index1-index2));

            }


        }

        return shortDist;
    }
}
