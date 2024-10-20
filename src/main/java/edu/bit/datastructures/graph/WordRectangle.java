package edu.bit.datastructures.graph;

import edu.bit.datastructures.trie.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of millions of words, design an algorithm to create the largest possible rectangle of letters such that
 * every row forms a word(reading left to right) and every column forms a word (reading top to bottom).
 * The words need not be chosen consecutively from the list, but all rows must be the same length and
 * all columns must be the same height.
 */
public class WordRectangle {
    // Such questions require building up or pre-processing data.
    // To look at building the largest possible rectangle, start from largest to smallest and break immediately
    // One needs to identify that given all valid rows, the substrings of the column are present in the trie


    private final int maxWordLength;
    private final WordGroup[] groupList;
    private final Trie[] trieList;

    public WordRectangle(String[] list) {
        groupList = WordGroup.createWordGroups(list);
        maxWordLength = groupList.length;
        // Initialize trieList to store trie of groupList[i] at ith position.
        trieList = new Trie[maxWordLength];
    }

    // Test harness.
    public static void main(String[] args) {
        WordRectangle dict = new WordRectangle(new String[]{"abc", "def", "ghi"});
        Rectangle rect = dict.maxRectangle();
        if (rect != null) {
            rect.print();
        } else {
            System.out.println("No rectangle exists");
        }
    }

    /* This function finds a rectangle of letters of the largest
     * possible area (length x breadth) such that every row forms a
     * word (reading left to right) from the list and every column
     * forms a word (reading top to bottom) from the list.
     */
    public Rectangle maxRectangle() {
        // The dimensions of the largest possible rectangle.
        int maxSize = maxWordLength * maxWordLength;

        for (int z = maxSize; z > 0; z--) {
            // Find out all pairs i,j less than maxWordLength
            // such that i * j = z
            for (int i = 1; i <= maxWordLength; i++) {
                if (z % i == 0) {
                    int j = z / i;
                    if (j <= maxWordLength) {
                        // Check if a Rectangle of length i and height
                        // j can be created.
                        Rectangle rectangle = makeRectangle(i, j);
                        if (rectangle != null) {
                            return rectangle;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* This function takes the length and height of a rectangle as
     * arguments. It tries to form a rectangle of the given length and
     * height using words of the specified length as its rows, in which
     * words whose length is the specified height form the columns. It
     * returns the rectangle so formed, and null if such a rectangle
     * cannot be formed.
     */
    private Rectangle makeRectangle(int length, int height) {
        if (groupList[length - 1] == null || groupList[height - 1] == null) {
            return null;
        }
        if (trieList[height - 1] == null) {
            List<String> words = groupList[height - 1].getWords();
            trieList[height - 1] = new Trie(words);
        }
        return makePartialRectangle(length, height, new Rectangle(length));
    }

    /* This function recursively tries to form a rectangle with words
     * of length l from the dictionary as rows and words of length h
     * from the dictionary as columns. To do so, we start with an empty
     * rectangle and add in a word with length l as the first row. We
     * then check the trie of words of length h to see if each partial
     * column is a prefix of a word with length h. If so we branch
     * recursively and check the next word till we've formed a complete
     * rectangle. When we have a complete rectangle check if every
     * column is a word in the dictionary.
     */
    private Rectangle makePartialRectangle(int l, int h, Rectangle rectangle) {

        // Check if we have formed a complete rectangle by seeing if each column
        // is in the dictionary
        if (rectangle.height == h) {
            if (rectangle.isComplete(l, h, groupList[h - 1])) {
                return rectangle;
            } else {
                return null;
            }
        }

        // If the rectangle is not empty, validate that each column is a
        // substring of a word of length h in the dictionary using the
        // trie of words of length h.
        if (!rectangle.isPartialOK(l, trieList[h - 1])) {
            return null;
        }

        // For each word of length l, try to make a new rectangle by adding
        // the word to the existing rectangle.
        for (int i = 0; i < groupList[l - 1].length(); i++) {
            Rectangle orgPlus = rectangle.append(groupList[l - 1].getWord(i));
            Rectangle rect = makePartialRectangle(l, h, orgPlus);
            if (rect != null) {
                return rect;
            }
        }
        return null;
    }

    static class Rectangle {
        // Rectangle data.
        public int height;
        public int length;
        public char[][] matrix;

        public Rectangle(int len) {
            this.length = len;
        }

        /* Construct a rectangular array of letters of the specified length
         * and height, and backed by the specified matrix of letters. (It is
         * assumed that the length and height specified as arguments are
         * consistent with the array argument's dimensions.)
         */
        public Rectangle(int length, int height, char[][] letters) {
            this.height = letters.length;
            this.length = letters[0].length;
            matrix = letters;
        }

        /* Return the letter present at the specified location in the array.
         */
        public char getLetter(int i, int j) {
            return matrix[i][j];
        }

        public String getColumn(int i) {
            char[] column = new char[height];
            for (int j = 0; j < height; j++) {
                column[j] = getLetter(j, i);
            }
            return new String(column);
        }

        public boolean isComplete(int l, int h, WordGroup groupList) {
            // Check if we have formed a complete rectangle.
            if (height == h) {
                // Check if each column is a word in the dictionary.
                for (int i = 0; i < l; i++) {
                    String col = getColumn(i);
                    if (!groupList.containsWord(col)) {
                        return false; // Invalid rectangle.
                    }
                }
                return true; // Valid Rectangle!
            }
            return false;
        }

        public boolean isPartialOK(int l, Trie trie) {
            if (height == 0) {
                return true;
            }
            for (int i = 0; i < l; i++) {
                String col = getColumn(i);
                if (!trie.contains(col)) {
                    return false; // Invalid rectangle.
                }
            }
            return true;
        }

        /* If the length of the argument s is consistent with that of this
         * Rectangle object, then return a Rectangle whose matrix is constructed by
         * appending s to the underlying matrix. Otherwise, return null. The
         * underlying matrix of this Rectangle object is /not/ modified.
         */
        public Rectangle append(String s) {
            if (s.length() == length) {
                char[][] temp = new char[height + 1][length];
                for (int i = 0; i < height; i++) {
                    System.arraycopy(matrix[i], 0, temp[i], 0, length);
                }
                s.getChars(0, length, temp[height], 0);

                return new Rectangle(length, height + 1, temp);
            }
            return null;
        }

        /* Print the rectangle out, row by row. */
        public void print() {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println(" ");
            }
        }
    }

    static class WordGroup {
        private final Map<String, Boolean> lookup = new HashMap<String, Boolean>();
        private final List<String> group = new ArrayList<String>();

        public WordGroup() {

        }

        public static WordGroup[] createWordGroups(String[] list) {
            WordGroup[] groupList;
            int maxWordLength = 0;
            // Find out the length of the longest word
            for (int i = 0; i < list.length; i++) {
                if (list[i].length() > maxWordLength) {
                    maxWordLength = list[i].length();
                }
            }

            /* Group the words in the dictionary into lists of words of
             * same length.groupList[i] will contain a list of words, each
             * of length (i+1). */
            groupList = new WordGroup[maxWordLength];
            for (int i = 0; i < list.length; i++) {
                /* We do wordLength - 1 instead of just wordLength since this is used as
                 * an index and no words are of length 0 */
                int wordLength = list[i].length() - 1;
                if (groupList[wordLength] == null) {
                    groupList[wordLength] = new WordGroup();
                }
                groupList[wordLength].addWord(list[i]);
            }
            return groupList;
        }

        public boolean containsWord(String s) {
            return lookup.containsKey(s);
        }

        public void addWord(String s) {
            group.add(s);
            lookup.put(s, true);
        }

        public int length() {
            return group.size();
        }

        public String getWord(int i) {
            return group.get(i);
        }

        public List<String> getWords() {
            return group;
        }
    }
}