package me.liluyang.leetcode;

public class Solution33 {

    /**
     * 1. 为什么要先判断 mid 左边有序还是右边有序，之后再判断 target 是在 mid 左边还是右边？
     *      因为判断 target 的位置在有序的那一段子数组中很好判断，只要判断 start <= target < mid 或者 mid < target <= end 就可以了。（不包含 mid 是因为，如果 target == mid 就证明已经找到元素了，直接返回就可以了）
     *      而如果要在无序的那一段子数组中进行判断，例如 2, 3, X，1 这种情况，遍历这一个侧面的所有元素，不是很方便
     * 2. 如何判断是 mid 左侧有序还是右侧有序？
     *      根据题目中的描述，是有序数组旋转，那么数据的格式就很简单，数组只能变成了两部分有序的数组 4,5,6,1,2,3 这种情况
     *      不论二分查找过程中 start, mid， end 三个值怎么变，判断 mid 节点左边是有序数据还是右边是有序数组，都可以直接判断 nums[0] < nums[mid] 是否正确，如果是就是左边有序，如果不是就是右边有序
     *
     * 
     * @param nums 可能存在翻转的数组
     * @param target 要查询的目标数据
     * @return 返回目标数据所在的索引
     */
    public static int search(int[] nums, int target) {

        if (nums.length < 0) return  -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int start = 0;
        int end = nums.length - 1;

        // 当开始节点小于结束节点时持续查找
        while (start <= end) {
            int mid = (start + end) / 2;
            // 如果此时 target 和 mid 相同，那么 mid 就是要返回的位置
            if (nums[mid] == target) return mid;

            // 判断数组左边是否是有序数组
            if (nums[0] <= nums[mid]) {
                // 判断 target 是在左边还是在右边
                if (nums[0] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(search(nums, 3));
    }
}