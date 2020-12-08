package com.cqc.learning.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 两个整数加和等于目标值的下标
 * @author caoqingcong
 */
public class TwoNumSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[sc.nextInt()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(Arrays.toString(twoIntegerSum(nums, target)));
    }

    private static int[] twoIntegerSum(int[] nums, int target) {
        if (nums.length <= 0) {
            return null;
        }
        Arrays.sort(nums);
        int[] result = new int[2];
        int numLength = nums.length;
        int low = 0;
        int high = numLength - 1;
        for (int i = 0; i < numLength; i++) {
            if (nums[low] + nums[high] > target) {
                high--;
            } else if (nums[low] + nums[high] < target) {
                low++;
            } else {
                result[0] = low;
                result[1] = high;
            }
        }
        return result;
    }
}
