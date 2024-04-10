import java.lang.reflect.Array;
import java.util.*;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed){
        List<Integer[]> input = new ArrayList<>();
        for (int i = 0; i < position.length; i++){
            input.add(new Integer[]{position[i], speed[i]});
        }

        input.sort(Comparator.comparing(p -> -p[0]));

        input.forEach(in -> System.out.println(Arrays.toString(in)));

        List<Double> stack = new ArrayList<>();
        for (Integer[] integers : input) {
            stack.addLast((double) (target - integers[0]) / integers[1]);
            if (stack.size() >= 2 && stack.getLast() <= stack.get(stack.size() - 2)) {
                stack.removeLast();
            }
        }

        return stack.size();

    }

    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
    }
}
