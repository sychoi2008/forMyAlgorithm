package Algorithm;

import java.util.HashMap;

public class HashTest {
    public static HashMap<Integer, Boolean> hm = new HashMap<>();
    public static boolean checkCode(int [] nums, int target) {
        for(int num : nums) {
            hm.put(num, true);
        }

        for(int num : nums) {
            int needed_num = target - num;
            if(hm.containsKey(needed_num)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [] nums = {4,1,9,7,8,2};
        int target = 14;
        System.out.println(checkCode(nums, target));
    }
}
