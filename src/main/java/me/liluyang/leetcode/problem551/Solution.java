package me.liluyang.leetcode.problem551;

/**
 *
 * 551
 *
 */
public class Solution {

    /**
     * 检查出勤记录
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {

        int absentCount = 0;
        int lateCount = 0;

        for (int i = 0; i < s.toCharArray().length; i++) {
            char char01 = s.charAt(i);
            if (char01 == 'A') absentCount++;
            if (char01 == 'L') {
                if (lateCount == 0) lateCount = 1;
                if (lateCount > 0 && i > 0 && s.charAt(i-1) == 'L') lateCount++;
                if (lateCount > 0 && i > 0 && s.charAt(i-1) != 'L') lateCount = 0;
            }
            if (absentCount > 1) return false;
            if (lateCount > 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("");
    }

}
