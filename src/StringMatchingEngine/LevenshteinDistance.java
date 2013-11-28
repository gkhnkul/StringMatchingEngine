/*
 * The MIT License
 *
 * Copyright 2013 Gökhan Kul.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package StringMatchingEngine;

/**
 * 28.11.2013
 * This class is the implementation of Levenshtein Distance to find string similarity
 * @author Gökhan Kul
 */
public class LevenshteinDistance implements StringMatchingAlgorithm {

    /**
     * This method returns the similarity between two texts
     *
     * @param s1 first text
     * @param s2 second text
     * @return the similarity ratio between two texts (from 0 -lowest- to 1 -highest-)
     */
    @Override
    public double Similarity(String s1, String s2) {
        if (s1.length() < s2.length()) { // s1 should always be bigger
            String swap = s1;
            s1 = s2;
            s2 = swap;
        }
        int bigLen = s1.length();
        if (bigLen == 0) {
            return 1.0; /* both strings are zero length */ }
        return (bigLen - ComputeEditDistance(s1, s2)) / (double) bigLen;
    }

    /**
     * This method computes the distance between two texts
     *
     * @param s1 first text
     * @param s2 second text
     * @return the distance between two texts
     */
    private int ComputeEditDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;
                } else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (!s1.substring(i - 1, i).equals(s2.substring(j - 1, j))) {
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        }
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0) {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }

}
