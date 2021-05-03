package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReplaceWordsTest {

    ReplaceWords replaceWords = new ReplaceWords();

    @Test
    void replaceWords() {
        Assertions.assertEquals("the cat was rat by the bat",
                replaceWords.replaceWords(List.of("cat", "bat", "rat"),
                        "the cattle was rattled by the battery"));

        Assertions.assertEquals("a a b c",
                replaceWords.replaceWords(List.of("a", "b", "c"),
                        "aadsfasf absbs bbab cadsfafs"));

        Assertions.assertEquals("a a a a a a a a bbb baba a",
                replaceWords.replaceWords(List.of("a", "aa", "aaa", "aaaa"),
                        "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));

        Assertions.assertEquals("the cat was rat by the bat",
                replaceWords.replaceWords(List.of("catt", "cat", "bat", "rat"),
                        "the cattle was rattled by the battery"));

        Assertions.assertEquals("it is ab that this solution is ac",
                replaceWords.replaceWords(List.of("ac", "ab"),
                        "it is abnormal that this solution is accepted"));
    }
}