package com.core.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDates {


    public List<String> sortDates(List<String> dates){

        Collections.sort(dates, new Comparator<String>() {
            DateFormat f = new SimpleDateFormat("dd MMM yyyy");
            @Override
            public int compare(String o1, String o2) {
                try {
                    return f.parse(o1).compareTo(f.parse(o2));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return -1;
            }
        });
        return dates;
    }


    public static void main(String[] args) {

        List<String> dates = new ArrayList<>();
        dates.add("22 FEB 2017");
        dates.add("20 FEB 2017");
        dates.add("23 FEB 2016");

        List<String> sortedDates=  new SortDates().sortDates(dates);

        System.out.println(sortedDates);


    }
}
