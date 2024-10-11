package edu.bit.datastructures.string;

/**
 * Given a non-empty string like "Code" return a string like "CCoCodCode".
 * stringSplosion("Code") → "CCoCodCode"
 * stringSplosion("abc") → "aababc"
 * stringSplosion("ab") → "aab"
 */
public class StringSpolsion {

    public String stringSplosion(String str) {
        StringBuilder currentString = new StringBuilder();
        StringBuilder finalString = new StringBuilder();
        for (char c : str.toCharArray()) {
            currentString.append(c);
            finalString.append(currentString);
        }
        return finalString.toString();
    }
}
