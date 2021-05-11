package edu.bit.problemsolving.competitive.leet.weekly.april;

public class LongestBeautiful {


    public static void main(String[] args) {
        LongestBeautiful longestBeautiful = new LongestBeautiful();
//        System.out.println(longestBeautiful.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(longestBeautiful.longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        System.out.println(longestBeautiful.longestBeautifulSubstring("a"));

    }

    public int longestBeautifulSubstring(String word) {
        char[] characters = word.toCharArray();
        int maxCount = 0;

        StringBuilder subString = new StringBuilder();
        for (int i = 0; i < word.length() - 1; i++) {
            if ((characters[i + 1] == characters[i]) || isPreviousCharacter(characters[i], characters[i + 1])) {
                subString.append(characters[i]);
            } else {
                String sub = subString.toString();
                if (sub.length() > maxCount && (sub.charAt(0) == 'a' && sub.charAt(sub.length() - 1) == 'u')) {
                    maxCount = sub.length();
                }
                subString = new StringBuilder();
            }
        }
        return maxCount;
    }
//
//    public int longestBeautifulSubstring(String word) {
//        int result = 0, current = 0;
//        char currentVowel = 'a';
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < word.length(); i++)
//            if (word.charAt(i) < currentVowel) {
//                set.clear();
//                if (word.charAt(i) == 'a') {
//                    set.add('a');
//                    current = 1;
//                } else {
//                    current = 0;
//                }
//                currentVowel = 'a';
//            } else {
//                current++;
//                set.add(word.charAt(i));
//                if (set.size() == 5) {
//                    result = Math.max(result, current);
//                }
//            }
//        return result;
//    }

    private boolean isPreviousCharacter(char a, char b) {
        if (a == 'a' && b == 'e') return true;
        if (a == 'e' && b == 'i') return true;
        if (a == 'i' && b == 'o') return true;
        if (a == 'o' && b == 'u') return true;
        return false;
    }
}