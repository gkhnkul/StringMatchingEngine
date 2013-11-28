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

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 28.11.2013
 * This class is a variation on Jaccard Index focusing on string similarity
 * @author Gökhan Kul
 */
public class JaccardSimilarity implements StringMatchingAlgorithm {

    Delimiter m_delimiter = null;
    IgnoredWord m_ignoredWord = null;

    private int SHORTEST_WORD_LENGTH = 2;

    /**
     * Class constructor setting up the default delimiters and words to be
     * ignored
     */
    public JaccardSimilarity() {
        m_delimiter = new Delimiter();
        m_ignoredWord = new IgnoredWord();
    }

    /**
     * Class constructor setting up the user provided delimiters and words to be
     * ignored
     */
    public JaccardSimilarity(Delimiter delimiter, IgnoredWord ignoredWord) {
        m_delimiter = delimiter;
        m_ignoredWord = ignoredWord;
    }

    /**
     * This method returns the similarity between two texts
     *
     * @param s1 first text
     * @param s2 second text
     * @return the similarity ratio between two texts (from 0 -lowest- to 1 -highest-)
     */
    @Override
    public double Similarity(String s1, String s2) {
        s1 = CharacterCheck(s1);
        s2 = CharacterCheck(s2);

        String[] wordList1 = Util.split(s1, m_delimiter);
        String[] wordList2 = Util.split(s2, m_delimiter);
        if (wordList1.length < wordList2.length) { // s1 should always be bigger
            String[] swap = wordList1;
            wordList1 = wordList2;
            wordList2 = swap;
        }

        ArrayList<String> wordList = new ArrayList<String>();
        int hitCount = 0;
        int wordCount = 1;

        for (String s : wordList1) {
            if (s.length() > SHORTEST_WORD_LENGTH) {
                if (!m_ignoredWord.Contains(s)) {
                    wordList.add(s);
                }
            }
        }
        for (String s : wordList2) {
            if (s.length() > SHORTEST_WORD_LENGTH) {
                if (!m_ignoredWord.Contains(s)) {

                    if (wordList.contains(s)) {
                        hitCount++;
                    }
                }
            }
        }

        if (!wordList.isEmpty()) {
            wordCount = wordList.size();
        }

        return (double) hitCount / (double) wordCount;

    }

    /**
     * This method replaces some unicode characters with a more common usage of
     * that character
     *
     * @param s1
     * @return string
     */
    private String CharacterCheck(String s1) {
        s1 = s1.toUpperCase();
        s1 = s1.replace('İ', 'I');
        s1 = s1.replace('Ö', 'O');
        s1 = s1.replace('Ş', 'S');
        s1 = s1.replace('Ğ', 'G');
        s1 = s1.replace('Ç', 'C');
        s1 = s1.replace('Ü', 'U');

        return s1;
    }

}
