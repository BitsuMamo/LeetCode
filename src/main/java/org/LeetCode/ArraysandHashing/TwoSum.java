package org.LeetCode.ArraysandHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target){
        // Brute Force
        /*for(int i = 0; i < nums.length; i ++){
            for( int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};*/

        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) != null){
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i],i);
        }
        return new int[]{-1,-1};

    }
}
