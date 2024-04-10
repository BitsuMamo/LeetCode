import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class DailyTempratures {
    public static int[] dailyTemperatures(int[] temperatures){
        int[] res = new int[temperatures.length];

        for(int i = 0 ; i < temperatures.length - 1; i++){
            int curTemp = temperatures[i];
            int j = i + 1;
            int days = 1;
            while(j < temperatures.length && curTemp > temperatures[j]){
                days++;
                j++;
            }
            // Check if we exhausted the list
            if(j >= temperatures.length)
                days = 0;
            res[i] = days;
        }

        return res;
    }

    public static int[] dailyTemperaturesStack(int[] temperatures){

        List<Integer[]> stack = new ArrayList<>();
        int[] res = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i ++){
            while(!stack.isEmpty() && temperatures[i] > stack.getLast()[0]){
                var top = stack.removeLast();
                var stackIdx = top[1];
                res[stackIdx] = (i - stackIdx);
            }
            stack.add(new Integer[]{temperatures[i], i});
        }

        return res;

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperaturesStack(new int[]{73,74,75,71,69,72,76,73})));
    }
}
