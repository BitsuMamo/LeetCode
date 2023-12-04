package org.LeetCode.ArraysandHashing;

import java.util.*;

public class KMostFreq {
    public static void main(String[] args) {

    }
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.putIfAbsent(num, 0);
            freq.put(num, freq.get(num) + 1);
        }


        return freq.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();


    }
}
