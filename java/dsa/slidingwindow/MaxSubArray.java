package com.abdul;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> data = List.of(4, 2, 1, 7, 8, 1, 2, 8, 1, 0);
        Integer maxSum = Main.maxSumOfSubArray(data, 3);
        System.out.println(maxSum);
    }

    public static int maxSumOfSubArray(List<Integer> data, Integer k) {
        int currentMaxSum = Integer.MIN_VALUE;
        int currentRunningSum = 0;
        for (int i = 0; i < data.size(); i++) {
            currentRunningSum += data.get(i);
            if (i >= k - 1) {
                currentMaxSum = Math.max(currentMaxSum, currentRunningSum);
                currentRunningSum -= data.get(i - (k - 1));
            }
        }
        return currentMaxSum;
    }
}
