package me.liluyang.leetcode.problem860;

/**
 * https://leetcode-cn.com/problems/lemonade-change/description/
 * <p>
 * 860. 柠檬水找零
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(" ");

        int[] dollars = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        System.out.println(lemonadeChange(dollars));
    }


    /**
     * 贪心算法算法的最简单情况，每一种状态都唯一的由上一个状态决定
     *
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        int fiveDollars = 0;
        int tenDollars = 0;

        // 判断是否能够付款
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveDollars++;
            } else if (bills[i] == 10) {
                if (fiveDollars > 0) {
                    fiveDollars--;
                    tenDollars++;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (fiveDollars > 0 && tenDollars > 0) {
                    fiveDollars--;
                    tenDollars--;
                } else if (fiveDollars > 2) {
                    fiveDollars -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
