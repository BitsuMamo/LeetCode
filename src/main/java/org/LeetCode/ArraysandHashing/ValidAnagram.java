package org.LeetCode.ArraysandHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {

    }

    public boolean  isAnagram(String s, String t){
        // Map method
        /*if(s.length()!=t.length()) return false;

       Map<Character, Integer> map_s = new HashMap<>();
        Map<Character, Integer> map_t = new HashMap<>();

       for(int i = 0; i < s.length(); i++){


           map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) + 1);
           map_t.put(t.charAt(i), map_t.getOrDefault(t.charAt(i), 0) + 1);

       }

        return map_s.equals(map_t);*/

        // Sort Method

        char s_char[] = s.toCharArray();
        Arrays.sort(s_char);
        char t_char[] = t.toCharArray();
        Arrays.sort(t_char);

        return Arrays.equals(s_char, t_char);


    }
}
