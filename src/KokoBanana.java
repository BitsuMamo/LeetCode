import java.util.Arrays;

public class KokoBanana {

    public static int  minEatingSpeed(int[] piles, int h){

        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length - 1];
        int min = Integer.MAX_VALUE;

        while(start < end  + 1){
            int mid = start + ((end - start) / 2);

            int time = 0;

            for(int pile: piles){
                time += (int) Math.ceil((double)pile / mid);
            }

            if(time <= h && time >= 0){
                min = Math.min(min, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return min;

    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }

}
