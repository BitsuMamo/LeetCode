import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++){
            if( i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = nums.length-1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right --;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left ++;
                }else{
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left ++;
                    while (nums[left] == nums[left-1] && left < right){
                        left ++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0}).toString());
    }
}
