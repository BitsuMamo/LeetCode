import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReversePolishNotation {
    public static int evalRPN(String[] token){
        List<Integer> stack = new ArrayList<>();

        Set<String> arithmetic = Set.of("+", "-", "*", "/");

        for(String s: token){
            if(!arithmetic.contains(s)) {
                stack.add(Integer.valueOf(s));
            }else {
                Integer op2 = stack.removeLast();
                Integer op1 = stack.removeLast();
                switch (s){
                    case "+":
                        stack.add(op1 + op2);
                        break;
                    case "-":
                        stack.add(op1 - op2);
                        break;
                    case "*":
                        stack.add(op1 * op2);
                        break;
                    case "/":
                        stack.add(op1 / op2);
                        break;
                }
            }
        }
        return stack.getLast();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
