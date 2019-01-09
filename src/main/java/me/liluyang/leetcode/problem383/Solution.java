package me.liluyang.leetcode.problem383;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        canConstruct("djfjfhjf","aaigcbiafifghhdihcfdjjej");
    }


    /**
     * 问题分析：获取 a 字符串的元素加元素个数
     *
     * 解题思路：排序 + 双指针
     *
     * 其他思路：hash表也可以
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0 && magazine.length() == 0) return true;
        if (ransomNote == null && magazine == null) return true;
        if (magazine == null || magazine.length() == 0) return false;
        char[] chars0 = ransomNote.toCharArray();
        char[] chars1 = magazine.toCharArray();
        Arrays.sort(chars0);
        Arrays.sort(chars1);

        System.out.println(chars0);
        System.out.println(chars1);

        int j = 0;
        int i = 0;

        while ( i < chars0.length ) {
            if (j >= chars1.length) return false;
            if (chars0[i] == chars1[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return true;
    }

    /**
     * 该思路超时
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        ArrayList<Character> ransomList = new ArrayList<>();
        ArrayList<Character> magazineList = new ArrayList<>();
        for (int i = 0; i < ransomNote.toCharArray().length; i++) {
            ransomList.add(ransomNote.charAt(i));
        }
        for (int i = 0; i < magazine.toCharArray().length; i++) {
            magazineList.add(magazine.charAt(i));
        }

        for (int i = 0; i < ransomList.size(); i++) {
            if(magazineList.contains(ransomList.get(i))) {
                magazineList.remove(ransomList.get(i));
                continue;
            }
            else return false;
        }
        return true;
    }

}
