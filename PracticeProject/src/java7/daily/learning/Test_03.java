package java7.daily.learning;

import java.util.*;

/**
 * @ClassName Test_04
 * @Description TODO
 * @Author yuisama
 * @Date 2020/3/6 21:25
 */


public class Test_03 {

}

//给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
//
//换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
//
//以数组形式返回答案。
//
class Solution_3{
    //方法一：暴力法
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) { // 枚举所有元素
            for (int j = 0; j < len; j++) { // 枚举其他元素
                if (i == j) continue;
                if (nums[i] > nums[j]) res[i]++;
            }
        }
        return res;
    }


    //排序+映射
    public int[] smallerNumbersThanCurrent_02(int[] nums) { // 8, 1, 2, 2, 3
        int len = nums.length;
        Map<Integer, Set<Integer>> valueIndex = new HashMap<>(len); // 预存每个值与索引对应
        for (int i = 0; i < len; i++) {
            if (!valueIndex.containsKey(nums[i])) valueIndex.put(nums[i], new HashSet<>());
            valueIndex.get(nums[i]).add(i);
        }
        int[] sortedArr = Arrays.copyOf(nums, len), res = new int[len];
        Arrays.sort(sortedArr); // 1, 2, 2, 3, 8
        for (int si = len - 1; si >= 0; si--) {
            for (int i : valueIndex.get(sortedArr[si])) res[i] = si; // 同值的所有索引都更新
        }
        return res;
    }

}
