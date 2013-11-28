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
 *
 * @author Gökhan Kul
 */
public class StringMatcher {

    private double SIMILARITY_TRESHOLD = 0.6;
    private Delimiter m_delimiter = null;
    private IgnoredWord m_ignoredWord = null;

    public StringMatcher() {
        SIMILARITY_TRESHOLD = 0.6;
        m_delimiter = new Delimiter();
        m_ignoredWord = new IgnoredWord();
    }

    public double LevenshteinSimilarity(String s1, String s2) {
        LevenshteinDistance similarityMethod = new LevenshteinDistance();
        return similarityMethod.Similarity(s1, s2);
    }

    public boolean IsSimilarLevenshtein(String s1, String s2) {
        LevenshteinDistance similarityMethod = new LevenshteinDistance();
        return (similarityMethod.Similarity(s1, s2) >= SIMILARITY_TRESHOLD);
    }

    public double JaccardSimilarity(String s1, String s2) {
        JaccardSimilarity similarityMethod = new JaccardSimilarity();
        return similarityMethod.Similarity(s1, s2);
    }

    public double JaccardSimilarity(String s1, String s2, Delimiter delimiter, IgnoredWord ignoredWord) {
        JaccardSimilarity similarityMethod = new JaccardSimilarity(delimiter, ignoredWord);
        return similarityMethod.Similarity(s1, s2);
    }

    public boolean IsSimilarJaccard(String s1, String s2) {
        JaccardSimilarity similarityMethod = new JaccardSimilarity();
        return (similarityMethod.Similarity(s1, s2) >= SIMILARITY_TRESHOLD);
    }

    public boolean IsSimilarJaccard(String s1, String s2, Delimiter delimiter, IgnoredWord ignoredWord) {
        JaccardSimilarity similarityMethod = new JaccardSimilarity(delimiter, ignoredWord);
        return (similarityMethod.Similarity(s1, s2) >= SIMILARITY_TRESHOLD);
    }

}
