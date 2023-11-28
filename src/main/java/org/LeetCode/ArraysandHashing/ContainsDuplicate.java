package org.LeetCode.ArraysandHashing;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums){
        // Set Method
        /*HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            s.add(nums[i]);
        }

        return nums.length > s.size();
        */

        var dict = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
            if(dict.get(nums[i]) == null){
                dict.put(nums[i], 1);
            }else{
                return true;
            }
        }

        return false;
    }
}
