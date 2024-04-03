import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums){

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] soln = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            prefix[i] = i == 0 ? nums[i] : nums[i] * prefix[i-1];
        }

        for(int i = nums.length - 1 ; i >= 0; i--){
            postfix[i] = i == nums.length - 1 ? nums[i] : nums[i] * postfix[i+1];
        }


        for(int i = 0; i < nums.length; i++){

            if(i == 0){
                soln[i] = postfix[i + 1];
            }else if(i == nums.length - 1){
                soln[i] = prefix[i - 1];
            }else{

                soln[i] = prefix[i - 1] * postfix[i + 1];
            }
        }

        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(postfix));

        return soln;
    }
}
