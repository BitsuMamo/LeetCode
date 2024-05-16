public class SerachRotatedArray {

    public static int search(int[] nums, int target){
        int l = 0, r = nums.length - 1;

        while(l <= r){
            int m = l + ((r - l) / 2);

            if(nums[m] == target){
                return m;
            }

            if(target > nums[m] && nums[m] > nums[l]) {
                r = m - 1;
            }else if(target > nums[m] && nums[m] < nums[l]){
                l = m + 1;
            }else if(target < nums[m] && nums[m] > nums[l]){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }

       return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,4,10,11,0,1,2}, 2));
    }

}
