package problems;

public class FraudulentActivityNotification {

    public static void countingSort(int[] input, int k) {
        // create buckets
        int counter[] = new int[k + 1];

        // fill buckets
        for (int i : input) {
            counter[i]++;
        }

        // sort array
        int ndx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (0 < counter[i]) {
                input[ndx++] = i;
                counter[i]--;
            }
        }
    }


    static int activityNotifications(int[] expenditure, int d) {
        int totalNotifications = 0;
        int maxNumber = -1;
        int[] subArray = new int[d];
        int pos=0;
        for(int j=0; j< d; j++){
            if(expenditure[j]> maxNumber)
                maxNumber = expenditure[j];
            subArray[pos]=expenditure[j];
            pos++;
        }
        //int[] subArray= Arrays.copyOfRange(expenditure, i-d, i-1);

        for (int i = d; i < expenditure.length - 1; i++) {
            int subArrayFirstNumber = expenditure[i-d];
            // System.out.println(subArray);
            //Arrays.sort(subArray);
            countingSort(subArray,maxNumber);
            int median = subArray[subArray.length / 2];
            if (expenditure[i] >= median * 2)
                totalNotifications++;
            //replace SubArrays FirstElement with next element
            for(int k=0; k< subArray.length; k++){
                if(subArray[k] == subArrayFirstNumber){
                    if(expenditure[i]> maxNumber)
                        maxNumber = expenditure[i];
                    subArray[k]= expenditure[i];
                }
            }

        }
        return totalNotifications;
    }

    public static void main(String[] args) {
        int[] expenditures = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
        System.out.println(FraudulentActivityNotification.activityNotifications(expenditures, 5));
    }
}
