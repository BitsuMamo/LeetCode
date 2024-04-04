import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinStack {

    List<Integer> stack;
    int min;

    public MinStack() {
        stack = new ArrayList<>();
        min = 0;
    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
        }
        min = Integer.min(min, val);
        stack.add(val);
    }

    public void pop() {
        if(stack.size() <= 1) {
            stack.removeLast();
            return;
        }

        Integer popped = stack.removeLast();
        if(popped == min){
            reCalcMin();
        }

    }

    private void reCalcMin(){
        min = stack.getLast();
        for(int v: stack){
            min = Integer.min(min, v);
        }
    }

    public int top() {
        int top = stack.getLast();
        return top;
    }

    public int getMin() {
        return min;
    }

}
