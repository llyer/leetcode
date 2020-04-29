package me.liluyang.leetcode;

/**
 * 思路：字符串替换
 */
public class Solution1095 {


    /**
     * 1.心路历程
     *      数组是山峰数组，那么在这个数组中用二分查找去查找一个元素第一次出现的坐标，就会有很多种情况需要考虑
     *          1.(start + end) / 2 二分查找时用到标记节点 mid 是在山峰的左侧还是右侧是要怎么处理？
     *          2.如果查找的元素在山峰的左侧和右侧都有怎么处理？
     * 2.解题思路
     *      所以最佳的解法就是先找出山峰数组的峰值的坐标，山峰两侧就都是有序数组，两次二分查找搞定此题
     *      然后在山峰的左侧执行二分查找，如果找到返回元素的坐标，
     *      如果没有，再在右侧执行一次二分查找就可以了
     *
     * @param target 要获取的值
     * @param mountainArr 数组
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int length = mountainArr.length();
        int start = 0;
        int end =  length - 1;
        int result = -1;
        int maxIndex = -1;

        // 1. 查找峰值
        while (start < end) {

            int mid = (start + end) / 2;

            System.out.println(mid);

            int leftV = mountainArr.get(mid - 1);
            int midV = mountainArr.get(mid);
            int rightV = mountainArr.get(mid + 1);

            // 升序阶段
            if (leftV < midV &&  midV < rightV) {
                // 如果右侧到最右边了了，那就返回最后一个元素
                if (mid + 1 == length - 1) {
                    maxIndex = mid + 1;
                    break;
                } else {
                    start = mid;
                }
            }

            // 降序阶段
            if (leftV > midV &&  midV > rightV) {
                // 如果右侧到最右边了了，那就返回最后一个元素
                if (mid - 1 == 0) {
                    maxIndex = mid - 1;
                    break;
                } else {
                    end = mid;
                }
            }

            // 找到值了
            if (leftV < midV &&  midV > rightV) {
                maxIndex = mid;
                break;
            }
        }
        System.out.println("最大值坐标找到了" + maxIndex);


        // 1. 分别在峰值的左边和右边执行一次二分查找
        start = 0;
        end = maxIndex;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midV = mountainArr.get(mid);

            if (midV == target) return mid;
            if (midV < target) start = mid + 1;
            if (midV >target) end = mid - 1;
        }

        start = maxIndex;
        end = length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midV = mountainArr.get(mid);

            if (midV == target) return mid;
            if (midV < target) end = mid - 1;
            if (midV >target) start = mid + 1;
        }

        return result;
    }

    /**
     * leetcode 提供的 api
     */
    interface MountainArray {
        public int get(int index);

        public int length();
    }


    public static void main(String[] args) {
        System.out.println();
    }
}

