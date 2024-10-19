package edu.bit.datastructures.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

class WordSquaresTest {

    WordSquares wordSquares = new WordSquares();

    @Test
    void testWordSquaresUsingTrie() {
        List<List<String>> lists = wordSquares.wordSquares(new String[]{
                "area", "lead", "wall", "lady", "ball"
        });
        System.out.println(lists);
    }

}