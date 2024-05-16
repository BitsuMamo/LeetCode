public class MinRotatedArray {
    public  static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(left <= right){
            if(nums[left] < nums[right]){
                min = Math.min(min, nums[left]);
                break;
            }
            int mid = left + ((right - left) / 2);
            min = Math.min(min, nums[mid]);

            if(nums[mid] >= nums[left]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return min;

    }

    public static void main(String[] args){
        System.out.println(findMin(new int[]{3,4,10,11,0,1,2}));
    }

}
