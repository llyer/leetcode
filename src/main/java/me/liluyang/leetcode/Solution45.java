package me.liluyang.leetcode;

class Solution45 {

    /**
     * 题目：45. 跳跃游戏 II
     * 链接：https://leetcode-cn.com/problems/jump-game-ii/
     * 标签：贪心算法
     *
     * 贪心算法的逻辑是怎样的？
     *      以数组 {2,3,1,1,4} 为例，我们从第一个节点 2 出发，可以到达 3,1 两个点，那么走发应该取决于节点 3,1 中选择之后可以走的更远的那个点，所以选择 3
     *      也就是说，对于点 2 来说，可以以（一步距离）到达的所有点中，应该选择的是可以以 （一步距离）的所有点中再走一步
     *      也就是（两步距离）可以走的最远的那个点
     *
     * 需要几次循环？
     *      一次循环
     *
     * 需要定义的几个关键变量？
     *      steps: 循环过程中，到达 i 节点时需要的步数
     *      end：循环过程中，步数为 steps 时，可以到达的最远距离（一步距离）
     *      maxPosition 循环过程中，步数为 steps 时可以到达的所有节点中，再走一步可以到达的最大距离（两步距离）
     *
     * 什么时候需要对步数 steps+1 ？
     *      遍历过程中走到每一个最大距离时需要对 steps+1
     *
     * @param nums 数组
     * @return 跳跃次数
     */
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,3,1,1,4,1,1,1,1,3,2,1};

        System.out.println(jump(nums));
    }

}

