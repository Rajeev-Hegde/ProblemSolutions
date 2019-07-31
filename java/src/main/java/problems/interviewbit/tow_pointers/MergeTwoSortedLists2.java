package problems.interviewbit.tow_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedLists2 {

    /* Solution if Space constraint is specified. i.e if no other array has to be used.
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (b.size() != 0) {

            //corner case
            if (a.size() == 0 || a.get(a.size() - 1) < b.get(0))
                a.addAll(b);
            else {
                int posb = 0;
                int prevElementInsetPosition = 0;
                while (posb < b.size()) {
                    int num = b.get(posb);
                    int posa = prevElementInsetPosition;
                    if (posa >= a.size())
                        a.add(num);
                    else {
                        boolean performedBreak=false;
                        while (posa < a.size()) {
                            if (a.get(posa) > num) {
                                shiftValue(a, posa);
                                a.set(posa, num);
                                prevElementInsetPosition = posa + 1;
                                performedBreak=true;
                                break;
                            } else
                                posa++;
                        }
                        if (!performedBreak)
                            a.add(num);
                    }
                    posb++;
                }
            }
        }
    }


    public void shiftValue(ArrayList<Integer> a, int pos) {
        int i = pos, temp1 = a.get(i), temp2;
        while (i < a.size()) {
            if ((i+1) < a.size()) {
                temp2 = a.get(i + 1);
                a.set(i + 1, temp1);
                temp1 = temp2;
            }
            i++;
        }
        a.add(temp1);

    }*/


    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) > b.get(j)) {
                a.add(i, b.get(j));
                i++;
                j++;
            } else {
                i++;
            }
        }

        while (j < b.size()) {
            a.add(b.get(j));
            j++;
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1 ,5 ,8));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(6 ,9));
        new MergeTwoSortedLists2().merge(a, b);
        System.out.println(a);
    }
}
