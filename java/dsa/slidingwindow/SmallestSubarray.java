package com.abdul;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> data = List.of(4, 2, 1, 7, 8, 1, 2, 8, 1, 0);
        Integer maxSum = Main.smallestSubarray(data, 8);
        System.out.println(maxSum);
    }

    // Dynamic resize
    public static int smallestSubarray(List<Integer> data, Integer k) {
        int windowStart = 0;
        int currentWindowSum = 0;
        int minWindowSize = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < data.size(); windowEnd++) {
            currentWindowSum += data.get(windowEnd);
            while (currentWindowSum >= k) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= data.get(windowStart);
                windowStart++;
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? 0 : minWindowSize;
    }
}
