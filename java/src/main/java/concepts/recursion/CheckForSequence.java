package concepts.recursion;


//checks if numbers are in sequence
public class CheckForSequence {


    public static boolean isInSequence(int[] a, int pos){
        if(pos== a.length)
            return true;

        return (a[pos] == a[pos-1]+1) && isInSequence(a,pos+1);

    }



    public static void main(String[] args) {
        System.out.println(CheckForSequence.isInSequence(new int[]{1,2,3,4,5},1));
        System.out.println(CheckForSequence.isInSequence(new int[]{1,2,3,4,6},1));
    }
}
