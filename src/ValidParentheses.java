import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidParentheses {
    public static boolean isValid(String s){
        List<Character> stack = new ArrayList<>();

        if(s.length() <= 1 || s.length() % 2 != 0)
            return false;

        for(int i = 0; i < s.length(); i ++){
            var c = s.charAt(i);
            if(checkOpening(c)){
                stack.add(c);
            }else{
                if(stack.size() == 0) return false;
                Character opening = stack.removeLast();
                if(c == '}' && opening != '{') return false;
                if(c == ')' && opening != '(') return false;
                if(c == ']' && opening != '[') return false;
            }
        }

        return stack.size() == 0;
    }

    private static boolean checkOpening(Character c){
        return c.equals('{') || c.equals('(') || c.equals('[');
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

}
