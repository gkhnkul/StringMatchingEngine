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
public class Delimiter {
    
    private char[] m_textDelimiters = null;
    
    /**
     * Class constructor setting up the default string delimiters
     * (e.g. ",", " ", ".", "-", "/", "\", "'")
     * If you need to change delimiters, use SetStringDelimiters method
     */
    public Delimiter() {
        SetDefaultStringDelimiters();
    }
    /**
     * This method sets the given string delimiter characters
     * @param charactersToSplit if given null, the default delimiters will be set
     */
    public void SetStringDelimiters(char[] charactersToSplit) {
        if (charactersToSplit == null || charactersToSplit.length == 0) {
            SetDefaultStringDelimiters();
        }
         
        m_textDelimiters = charactersToSplit;
    }
    
    /**
     * This method returns previously set delimiters
     * @return text delimiters
     */
    public char[] GetDelimiters() {
        return m_textDelimiters;
    }
    
    /**
     * This method sets the default delimiters
     */
    private void SetDefaultStringDelimiters() {
        m_textDelimiters = new char[]{',', ' ', '.', '-', '/', '\\', '\''};
    }
    
}
