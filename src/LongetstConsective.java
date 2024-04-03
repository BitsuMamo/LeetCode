import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongetstConsective {
    public int longestConsecutive(int[] nums){

        HashSet<Integer> numSet = new HashSet<>();
        for(int num: nums)
            numSet.add(num);

        int max = 0;
        for(int i = 0; i < nums.length; i ++){
            int longest = 1;
            //check to see if it is the start of the sequence
            if(!numSet.contains(nums[i] - 1)){
                int curr = nums[i];
                while(numSet.contains(curr)){
                    curr += 1;
                    longest++;
                }
                max = Integer.max(longest, max);
            }
        }

        return max;



    }

}
