package example;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    public static void main(String[] args) {
        
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookUp = new HashMap<>();

        for(int i = 0;i < nums.length; i++) {
            int remain = target - nums[i];

            if (lookUp.containsKey(remain)) {
                return new int[]{lookUp.get(remain), i};
            }

            lookUp.put(nums[i], i);
        }

        throw new IllegalArgumentException("no match given");
    }

}
