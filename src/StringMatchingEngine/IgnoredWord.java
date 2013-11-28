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
 * @author Gökhan Kul
 */
public class IgnoredWord {
    
    public String[] m_ignoredWords = null;
    
    /**
     * Class constructor setting up the default words to be ignored
     * (e.g. "THE", "FROM", "AND", "USING", "FOR")
     * If you need to change these words, use SetWordsToBeIgnored method
     */
    public IgnoredWord(){
        SetDefaultWordsToBeIgnored();
    }
    
    /**
     * This methods sets the given words to be ignored
     * @param wordsToIgnore if given null, the default words will be set
     */
    public void SetWordsToBeIgnored(String[] wordsToIgnore) {
        if (wordsToIgnore == null || wordsToIgnore.length == 0) {
            SetDefaultWordsToBeIgnored();
        }
        
        m_ignoredWords = wordsToIgnore;
    }
    
    /**
     * This method returns if the given text is a word that is set to be ignored 
     * @param text 
     * @return true if it is a word set to be ignored, false if not
     */
    public boolean Contains(String text){
        
        for (String i : m_ignoredWords) {
            if (i.equals(text))
                return true;
        }
        
        return false;
    }
    
    /**
     * This method sets the default words to be ignored
     */
    private void SetDefaultWordsToBeIgnored() {
        m_ignoredWords = new String[]{"THE", "FROM", "AND", "USING", "FOR"};
    }
}
