package edu.bit.datastructures.string;

    /*
We are building a word processor and we would like to implement a "word-wrap" functionality.

Given a list of words followed by a maximum number of characters in a line, return a collection of strings where each string element represents a line that contains as many words as possible, with the words in each line being concatenated with a single '-' (representing a space, but easier to see for testing). The length of each string must not exceed the maximum character length per line.

Your function should take in the maximum characters per line and return a data structure representing all lines in the indicated max length.

Examples:

words1 = [ "The", "day", "began", "as", "still", "as", "the",
          "night", "abruptly", "lighted", "with", "brilliant",
          "flame" ]

wrapLines(words1, 13) "wrap words1 to line length 13" =>

  [ "The-day-began",
    "as-still-as",
    "the-night",
    "abruptly",
    "lighted-with",
    "brilliant",
    "flame" ]

wrapLines(words1, 12) "wrap words1 to line length 12" =>

  [ "The-day",
    "began-as",
    "still-as-the",
    "night",
    "abruptly",
    "lighted-with",
    "brilliant",
    "flame" ]


wrapLines(words1, 20) "wrap words1 to line length 20" =>

  [ "The-day-began-as",
    "still-as-the-night",
    "abruptly-lighted",
    "with-brilliant-flame" ]

words2 = [ "Hello" ]

wrapLines(words2, 5) "wrap words2 to line length 5" =>

  [ "Hello" ]


wrapLines(words2, 30) "wrap words2 to line length 30" =>

  [ "Hello" ]

words3 = [ "Hello", "Hello" ]

wrapLines(words3, 5) "wrap words3 to line length 5" =>

  [ "Hello",
  "Hello" ]

words4 = ["Well", "Hello", "world" ]

wrapLines(words4, 5) "wrap words4 to line length 5" =>

  [ "Well",
  "Hello",
  "world" ]

words5 = ["Hello", "HelloWorld", "Hello", "Hello"]

wrapLines(words5, 20) "wrap words 5 to line length 20 =>

  [ "Hello-HelloWorld",
    "Hello-Hello" ]


words6 = [ "a", "b", "c", "d" ]
wrapLines(words6, 20) "wrap words 6 to line length 20 =>

  [ "a-b-c-d" ]

wrapLines(words6, 4) "wrap words 6 to line length 4 =>

  [ "a-b",
    "c-d" ]

wrapLines(words6, 1) "wrap words 6 to line length 1 =>

  [ "a",
    "b",
    "c",
    "d" ]

All Test Cases:
          words,  max line length
wrapLines(words1, 13)
wrapLines(words1, 12)
wrapLines(words1, 20)
wrapLines(words2, 5)
wrapLines(words2, 30)
wrapLines(words3, 5)
wrapLines(words4, 5)
wrapLines(words5, 20)
wrapLines(words6, 20)
wrapLines(words6, 4)
wrapLines(words6, 1)

n = number of words OR total characters


*/

import java.util.ArrayList;
import java.util.List;

/**
 * words1 = [ "The", "day", "began", "as", "still", "as", "the",
 * "night", "abruptly", "lighted", "with", "brilliant",
 * "flame" ]
 * lengthOFWords [] = [3,3,5,2,5...]
 * <p>
 * 12 ->
 * <p>
 * words =
 * <p>
 * Assume: Words would always be less than the
 */

public class WordProcessor {

    public static void main(String[] argv) {
        String[] words1 = {"The", "day", "began", "as", "still", "as", "the", "night", "abruptly", "lighted", "with", "brilliant", "flame"};
        String[] words2 = {"Hello"};
        String[] words3 = {"Hello", "Hello"};
        String[] words4 = {"Well", "Hello", "world"};
        String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
        String[] words6 = {"a", "b", "c", "d"};

        System.out.println("Output :" + wrapLines(words1, 20));


        /**
         System.out.println("Output :" + wrapLines(words1, 13));
         System.out.println("Output :" + wrapLines(words1, 12));
         System.out.println("Output :" + wrapLines(words1, 20));

         System.out.println("Output :" + wrapLines(words2, 5));
         System.out.println("Output :" + wrapLines(words2, 13));

         System.out.println("Output :" + wrapLines(words3, 5));

         System.out.println("Output :" + wrapLines(words4, 5));

         System.out.println("Output :" + wrapLines(words5, 20));

         System.out.println("Output :" + wrapLines(words6, 20));
         System.out.println("Output :" + wrapLines(words6, 4));
         System.out.println("Output :" + wrapLines(words6, 1));

         */
    }

    private static List<String> wrapLines(String[] words, int wrapLength) {
        List<String> output = new ArrayList<>();
        if (words.length == 0) {
            return output;
        }

        String currentString = words[0];
        int currentLength = currentString.length(); // the
        String cursor = "";
        for (int i = 1; i < words.length; i++) {
            cursor = words[i];
            System.out.println("Processing word :" + cursor);
            if (wrapLength < currentLength + 1 + cursor.length()) {
                output.add(currentString);
                currentString = cursor;
                currentLength = currentString.length();
                System.out.println("Current String Size :" + currentLength);
            } else {
                currentString = currentString + "-" + cursor; // the-day
                currentLength = currentString.length();
                System.out.println("Current String : " + currentString);
            }
        }
        if (cursor.length() > 0) {
            output.add(cursor);
        }

        return output;
    }
}
