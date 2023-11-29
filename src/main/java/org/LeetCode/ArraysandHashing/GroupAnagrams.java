package org.LeetCode.ArraysandHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs){
        // Brute Force
        List<List<String>> res = new ArrayList<>();
        List<String> newStr = new ArrayList<>(Arrays.stream(strs).toList());

        while(!newStr.isEmpty()){
            String cur = newStr.get(0);
            List<String> anagrams = new ArrayList<>();

            for(int i = 1; i < newStr.size(); i++){
                if(isAnagram(cur, newStr.get(i))){
                    anagrams.add(newStr.get(i));
                    newStr.remove(i);
                    i--;
                }
            }
            anagrams.add(cur);
            res.add(anagrams);
            newStr.remove(0);
        }



        return res;
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }
}
