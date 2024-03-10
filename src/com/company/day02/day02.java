package com.company.day02;

import java.util.HashSet;
import java.util.Set;

public class day02 {


    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n <= 2) {
                return n;
            }
            int slow = 2, fast = 2;
            while (fast < n) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow] = nums[fast];
                    ++slow;
                }
                ++fast;
            }
            return slow;
        }
    }

    /**
     * 接水问题
     *
     * @param height
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Set a = new HashSet();
        Set b = new HashSet();
        for (int i = 0; i < ransomNote.length(); i++) {
            a.add(ransomNote.charAt(i));
        }
        for (int j = 0; j < magazine.length(); j++) {
            b.add(magazine.charAt(j));
        }
        return b.containsAll(a);
    }
}