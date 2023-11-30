package org.LeetCode.ArraysandHashing;

import java.sql.Array;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs){
        // Brute Force
//        List<List<String>> res = new ArrayList<>();
//        List<String> newStr = new ArrayList<>(Arrays.stream(strs).toList());
//
//        while(!newStr.isEmpty()){
//            String cur = newStr.get(0);
//            List<String> anagrams = new ArrayList<>();
//
//            for(int i = 1; i < newStr.size(); i++){
//                if(isAnagram(cur, newStr.get(i))){
//                    anagrams.add(newStr.get(i));
//                    newStr.remove(i);
//                    i--;
//                }
//            }
//            anagrams.add(cur);
//            res.add(anagrams);
//            newStr.remove(0);
//        }

        Map<String, List<String>> res = new HashMap<>();

        for(String str: strs){
            Integer[] count = new Integer[26];
            Arrays.fill(count, 0);
            for(int i = 0; i < str.length(); i++){
                count[Character.getNumericValue(str.charAt(i)) - Character.getNumericValue('a')] += 1;
            }

            String coutStr = Arrays.toString(count);

            res.computeIfAbsent(coutStr, k -> new ArrayList<>());
            res.get(coutStr).add(str);
        }

        return new ArrayList<List<String>>(res.values());

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
