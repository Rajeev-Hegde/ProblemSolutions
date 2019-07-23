package problems.interviewbit.arrays;

import java.util.*;

public class HotelBookingsPossible {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int roomsRequired=0,i=0,j=0;
        while(i<arrive.size()  && j<arrive.size() && roomsRequired<=K){
            if(arrive.get(i)<depart.get(j) ){
                i++;
                roomsRequired++;
            }else{
                j++;
                roomsRequired--;
            }
        }
        return roomsRequired <= K;
    }


    public static void main(String[] args) {
        System.out.println(new HotelBookingsPossible()
                .hotel(new ArrayList<>(Arrays.asList(41, 10, 12, 30, 0, 17, 38, 36, 45, 2, 33, 36, 39, 25, 22, 5, 41, 24, 12, 33, 19, 30, 25, 12, 36, 8 )),
                        new ArrayList<>(Arrays.asList(47, 20, 15, 65, 35, 51, 38, 36, 94, 30, 50, 38, 67, 64, 67, 24, 62, 38, 18, 59, 20, 74, 33, 43, 56, 32)),12));
    }

}
