public class BestTimeToSellStock {
    public static int maxProfit(int[] prices){
        int max  = Integer.MIN_VALUE;

        int left = 0, right = 1;
        while(right < prices.length){
           max = Math.max(max, prices[right] - prices[left]);
           if(prices[left] > prices[right]){
               left = right;
           }
           right++;
        }

        return Math.max(max, 0);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
