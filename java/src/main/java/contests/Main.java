package contests;

import java.util.*;
import java.io.*;

public class Main {



   /* public static final String SHARED_CODE="5";
    public static final String NON_SHARED_CODE="4";
    public static final String NO_CALLS_CODE="9";

    static class UserPhoneDetails{
        public Set<String> sharedPhoneNumbers;
        public Set<String> nonSharedPhoneNumbers;

        UserPhoneDetails(Set<String> sharedPhoneNumbers,Set<String> nonSharedPhoneNumbers){
            this.sharedPhoneNumbers=sharedPhoneNumbers;
            this.nonSharedPhoneNumbers = nonSharedPhoneNumbers;
        }
    }


    public static class ProgramOutputStatistics{
        public String adherenceString="";
        List<Integer> flaggedDays = new ArrayList<Integer>();


    }

    public static UserPhoneDetails getSharedNonSharedPhNumDetails(List<PhoneRecord> phoneRecords,int userId){
        Set<String> sharedNumbers= new ArrayList<>();
        Set<String> nonSharedNumbers= new ArrayList<>();
        Set<String> checkedPhoneNumbers = new ArrayList<>();
        for(PhoneRecord phoneRecord: phoneRecords){
            String currentPhoneNumber =phoneRecord.phoneNumber;
            if(phonerecord.patiendId == userId){
                if(checkedPhoneNumbers.contains(currentPhoneNumber))
                    sharedNumbers.add(currentPhoneNumber);
                else{
                    nonSharedNumbers.add(currentPhoneNumber);
                }
            }
            else if(nonSharedNumbers.contains(currentPhoneNumber)){
                nonSharedNumbers.remove(currentPhoneNumber);
                sharedNumbers.add(currentPhoneNumber);
            }
            checkedPhoneNumbers.add(phoneRecord.phoneNumber);
        }
        return new UserPhoneDetails(sharedNumbers,nonSharedNumbers);
    }

    // This method calculates output statistics by taking callLogs as input
    public static ProgramOutputStatistics calculateStatistics(List<CallLog> callLogs, UserPhoneDetails userPhoneDetails){
        if(callLods == null || callLogs.isEmpty())
            return new ProgramOutputStatistics();

        List<Integer> flaggedDays = new ArrayList<Integer>();
        StringBuilder adherenceBuilder = new StringBuilder();
        int prevDay = 0;
        int userRepeatCount= 0;
        List<Integer> prevUsedPhoneNumbers= new ArrayList<>();
        for(int i=0; i<callLogs.size(); i++){

            String codeToUse="";
            List<String> currentTollFreeNumbers = new ArrayList<>();
            while(i<callLogs.size() && prevDay==callLogs.get(i).day){
                currrentTollFreeNumbers.add(callLogs.get(i).numberDialed);
                if(!codeToUse.equals(SHARED_CODE)){
                    if(userPhoneDetails.sharedPhoneNumbers.contains(callLogs.get(i).callerId))
                        codeToUse=SHARED_CODE;
                    else(userPhoneDetails.nonSharedPhoneNumbers.contains(codeToUse))
                    codeToUse=NON_SHARED_CODE;
                }
            }

            for(int missingDay=prevDay+1; missingDay< callLogs.get(missingDay).day && missingDay< callLogs.size(); missindDay++){
                adherenceBuilder.append(callLogs.get(missingDay).day);
            }

            if(i== callLogs.size())
                i--;

            if(prevUsedPhoneNumbers.containsAll(currentTollFreeNumbers))
                userRepeatCount++;

            if(userRepeatCount>=3)
                flaggedDays.add(callLogs.get(i).day);

        }
        ProgramOutputStatistics statistics= new ProgramOutputStatistics();
        statistics.adherenceString = adherenceBuilder.toString();
        statistics.flaggedDays = flaggedDays;

        return statistics;
    }

    public static void main(String args[]) throws IOException {
        ProgramInput input = readInput();

        // Fill in code here
        UserPhoneDetails phoneTypeDetails= getSharedNonSharedPhNumDetails(input.phonerecords,input.patiendId);
        ProgramOutputStatistics statistics= calculateStatistics();
        printOutput(statistics.adherenceString, statistics.flaggedDays);
    }

    public static ProgramInput readInput() throws IOException {
        ProgramInput input = new ProgramInput();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        input.patientId = Integer.parseInt(in.readLine());
        input.startDay  = Integer.parseInt(in.readLine());
        input.endDay    = Integer.parseInt(in.readLine());

        int numPhoneRecords = Integer.parseInt(in.readLine());
        input.phoneRecords = new ArrayList<PhoneRecord>();
        for (int i = 0; i < numPhoneRecords; i++) {
            PhoneRecord pr = new PhoneRecord();
            String[] tokens = in.readLine().split("\\s+");
            pr.patientId = Integer.parseInt(tokens[0]);
            pr.phoneNumber = tokens[1];
            input.phoneRecords.add(pr);
        }

        int numCallLogs = Integer.parseInt(in.readLine());
        input.callLogs = new ArrayList<CallLog>();
        for (int i = 0; i < numCallLogs; i++) {
            CallLog call = new CallLog();
            String[] tokens = in.readLine().split("\\s+");
            call.numberDialled = tokens[0];
            call.callerId = tokens[1];
            call.day = Integer.parseInt(tokens[2]);
            input.callLogs.add(call);
        }

        return input;
    }

    public static void printOutput(String adherenceString, Collection<Integer> flaggedDays) {
        System.out.println(adherenceString);

        List<Integer> days = new ArrayList<Integer>(flaggedDays);
        Collections.sort(days);
        for (Integer day : days) {
            System.out.println(day);
        }
    }

    public static class PhoneRecord {
        public int patientId;
        public String phoneNumber;
    }

    public static class CallLog {
        public String numberDialled;
        public String callerId;
        public int day;
    }

    public static class ProgramInput {
        public int patientId;
        public int startDay;
        public int endDay;
        public List<PhoneRecord> phoneRecords;
        public List<CallLog> callLogs;
    }
*/
}