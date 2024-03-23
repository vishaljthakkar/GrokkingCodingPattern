package com.educative.io.pattern.o6mergeintervals.leetcode;

// https://leetcode.com/problems/determine-if-two-events-have-conflict/
public class O0_TwoEventConflict_2446 {
    public static boolean haveConflict(String[] event1, String[] event2) {

        int event1StartTime = timeInMinutes(event1[0]);
        int event1EndTime = timeInMinutes(event1[1]);

        int event2StartTime = timeInMinutes(event2[0]);
        int event2EndTime = timeInMinutes(event2[1]);

        if (event1StartTime <= event2EndTime && event2StartTime <= event1EndTime) {
            return true;
        }
        return false;

    }

    public static int timeInMinutes(String str) {
        int hour = Integer.parseInt(str.substring(0, 2));
        int minutes = Integer.parseInt(str.substring(3));
        return hour * 60 + minutes;
    }

    public static void main(String[] args) {
        String[] event1 = new String[]{"01:15","02:00"};
        String[] event2 = new String[]{"02:00","03:00"};
        System.out.println(haveConflict(event1, event2)); // true

        event1 = new String[]{"10:00","11:00"};
        event2 = new String[]{"14:00","15:00"};
        System.out.println(haveConflict(event1, event2)); // false
    }
}
