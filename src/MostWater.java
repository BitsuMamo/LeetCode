public class MostWater {
    public static int maxArea(int[] height){
        int left = 0, right = height.length - 1;

        int max = 0;
        while (left < right){
            int area = Integer.min(height[left], height[right]) * (right - left);
            if(Integer.min(height[left + 1], height[right]) * (right - left - 1) > area)
                left ++;
            else if(Integer.min(height[left], height[right - 1]) * (right - left - 1) > area)
                right --;
            else {
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            max = Integer.max(max, area);

        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
