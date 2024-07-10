package Algorithm;

import java.util.HashMap;
import java.util.StringTokenizer;

public class HashTest {
    public static HashMap<Integer, Integer> hm = new HashMap<>();
    public static int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i], i);
        }

        for(int j=0; j<nums.length; j++) {
            int needed_num = target - nums[j];
            if(hm.containsKey(needed_num) && hm.get(needed_num)!=j) {
                if(j < hm.get(needed_num)) {
                    return new int[]{j,hm.get(needed_num)};
                } else {
                    return new int[]{hm.get(needed_num), j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int [] nums = {4,1,9,7,8,2};
        int target = 14;
        for(int num : twoSum(nums, target)) {
            System.out.print(num + " ");
        };
        StringTokenizer st = new StringTokenizer("h i");
        System.out.println(st.countTokens());
    }
}
