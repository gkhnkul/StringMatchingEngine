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
 * @author Gökhan Kul
 */
public class Util {
    
    /**
     * This method creates the regex syntax from a given character array
     * @param characters
     * @return regex string
     */
    private static String createRegex(char[] characters){
        
        String retVal = "";
        
        for (int i = 0; i < characters.length; i++) {
                retVal += characters[i];
        }
        
        return retVal;
    }
    
    public static String[] split(String s1, Delimiter delim) {
        StringTokenizer st = new StringTokenizer(s1, createRegex(delim.GetDelimiters()));
        ArrayList<String> tokens  = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        String[] retVal = new String[tokens.size()];
        for (int i = 0; i < tokens.size(); i++) {
            retVal[i] = tokens.get(i);
        }
        return retVal;
    }
}
