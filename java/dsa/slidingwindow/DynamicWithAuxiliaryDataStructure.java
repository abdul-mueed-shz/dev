package com.abdul;

import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     * A simple static inner class to hold our two return values.
     */
    public record SubstringResult(int length, Map<Character, Integer> frequencyMap) {

        public SubstringResult(int length, Map<Character, Integer> frequencyMap) {
            this.length = length;
            this.frequencyMap = new HashMap<>(frequencyMap);
        }

    }

    public static void main(String[] args) {
        String data = "AAAHHIBC";
        SubstringResult result = Main.findLongestSubstringWithKDistinct(data, 2);
        System.out.println(result);

    }

    /**
     * Finds the longest substring with at most k distinct characters.
     *
     * @param str The input string.
     * @param k   The maximum number of distinct characters allowed.
     * @return A SubstringResult object containing the length and the character map of the longest valid substring.
     */
    // 3. Change the return type to our new SubstringResult class
    public static SubstringResult findLongestSubstringWithKDistinct(String str, int k) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        Map<Character, Integer> longestWindowMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }

            int currentLength = windowEnd - windowStart + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestWindowMap = new HashMap<>(charFrequencyMap);
            }
        }
        return new SubstringResult(maxLength, longestWindowMap);
    }
}
