package Algorithm;

import java.util.Arrays;

public class TwoSum {
    public static int [] nums;
    public static boolean twoSum(int [] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        while(left < right) {
            if(nums[left] + nums[right] == target) return true;
            else if(nums[left] + nums[right] > target) right--;
            else if(nums[left] + nums[right] < target) left++;
        }
        return false;
    }

    public static void main(String[] args) {
        nums = new int [] {2,1,5,7};
        System.out.println(twoSum(nums, 4));

    }
}