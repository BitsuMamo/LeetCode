import java.util.Arrays;

public class TrappingRainWater {

    public static int trapBruteForce(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            //boundary
            if (i == 0) {
                maxLeft[i] = 0;
                continue;
            }
            maxLeft[i] = Integer.max(maxLeft[i-1], height[i - 1]);
        }

        for (int i = height.length - 1; i >= 0; i--) {
            //boundary
            if (i == height.length - 1) {
                maxRight[i] = 0;
                continue;
            }
            maxRight[i] = Integer.max(maxRight[i+1], height[i + 1]);
        }

        int res = 0;

        for(int i = 0; i < height.length; i ++) {
            int sum = Integer.min(maxRight[i], maxLeft[i]) - height[i];

            if (sum > 0) {
                res += sum;
            }
        }
        System.gc();
        return res;
    }

    public static int trapTwoPointer(int[] height){

       int l = 0, r = height.length - 1;
       int leftMax = height[l], rightmax = height[r];
       int res = 0;

       while(l < r){
           if(leftMax < rightmax){
               l++;
               leftMax = Integer.max(leftMax, height[l]);
               res += leftMax - height[l];
           }else{
               r--;
               rightmax = Integer.max(rightmax, height[r]);
               res += rightmax - height[r];
           }
       }
       return res;
    }

    public static void main(String[] args) {
        System.out.println(trapTwoPointer(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
