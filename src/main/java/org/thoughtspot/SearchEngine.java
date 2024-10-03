package org.thoughtspot;


// Design and implement a text search engine that can index a collection of billions of documents
// and retrieve results based on specific search terms.
// The search engine should support multi-word queries with proximity constraint.
// The proximity constraint specifies the maximum allowed distance between the search terms within a document.

// Example:

// Documents:[
//     "The apple juice in the store is freshly made every morning",
//     "A healthy diet includes apple slices and fresh juice",
//     "Orange juice is also a good source of vitamin C"
// ]
// Example Queries:

// query("juice", "apple", 1)
// Output: [0]

// query("apple", "juice", 4)
// Output: [0, 1]

// query("orange", "juice", 2)
// Output: [2]

// Constraints:
// Number of documents: > 10^9
// Maximum document length: 10^4 characters

// multiple occurrences -> either of the indexes shall satisfy the requirement
// search should be case insensitive
// complete word exists in the document

// [the -> 0,4 | apple -> 1, juice -> 2, in -> 3]
// [a -> 0]


// word: document : indexes
// apple : D1 : [1],  D2 : [4]
// juice : D2 : [7],  D1 : [2]

import java.util.*;

// {"apple": {1: [1], 2: [4]}
public class SearchEngine {

    public static void main(String[] args) {
        List<String> documents = List.of(
                "The apple juice in the store is freshly made every morning",
                "A healthy diet includes apple slices and fresh juice",
                "Orange juice is also a good source of vitamin C"
        );
        SearchEngine searchEngine = new SearchEngine(documents);
        System.out.println(searchEngine.query("juice", "apple", 1));
        System.out.println(searchEngine.query("apple", "juice", 4));
        System.out.println(searchEngine.query("orange", "juice", 2));
    }

    Map<String, Map<Integer, List<Integer>>> wordToDocumentIndexes;

    public SearchEngine(List<String> documents) {
        wordToDocumentIndexes = new HashMap<>();
        preProcessDocuments(documents);
    }

    void preProcessDocuments(List<String> documents) {
        for (int i = 0; i < documents.size(); i++) {
            addDocument(i, documents.get(i));
        }
    }

    // Method to add a document to the inverted index
    public void addDocument(int docId, String document) {
        String[] words = document.split("\\s+"); // Split document into words
        for (int pos = 0; pos < words.length; pos++) {
            String word = words[pos].toLowerCase(); // Convert words to lowercase for case insensitivity
            wordToDocumentIndexes.computeIfAbsent(word, k -> new HashMap<>())  // Create the map for the word if it doesn't exist
                    .computeIfAbsent(docId, k -> new ArrayList<>()) // Create the list for the docId if it doesn't exist
                    .add(pos); // Add the word position
        }
    }

    public List<Integer> query(String first, String second, Integer proximity) {
        // exception with one of the word not existing at all
        if (!wordToDocumentIndexes.containsKey(first) || !wordToDocumentIndexes.containsKey(second)) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> firstWordDocuments = wordToDocumentIndexes.get(first);
        Map<Integer, List<Integer>> secondWordDocuments = wordToDocumentIndexes.get(second);

        Set<Integer> documents = firstWordDocuments.keySet(); // only for these documents (has to be common)
        List<Integer> matchedDocuments = new ArrayList<>();

        for (Integer document : documents) {
            List<Integer> indexesForSecond = secondWordDocuments.getOrDefault(document, new ArrayList<>()); // ordered
            List<Integer> indexesForFirst = firstWordDocuments.get(document);

//            for (Integer integer : indexesForSecond) {
//                for (Integer value : indexesForFirst) {
//                    if (Math.abs(value - integer) <= proximity) {
//                        matchedDocuments.add(document);
//                        break;
//                    }
//                }
//            }
            boolean documentMatch = areWordsWithinProximity(indexesForFirst, indexesForSecond, proximity);
            if (documentMatch) matchedDocuments.add(document);
        }
        return matchedDocuments;
    }

    // Helper method to check if two lists of positions are within a given proximity
    private boolean areWordsWithinProximity(List<Integer> positions1, List<Integer> positions2, int proximity) {
        int i = 0;
        int j = 0;
        while (i < positions1.size() && j < positions2.size()) {
            int pos1 = positions1.get(i);
            int pos2 = positions2.get(j);
            if (Math.abs(pos1 - pos2) <= proximity) {
                return true; // Found words within proximity
            }
            // Move the pointer for the smaller position
            if (pos1 < pos2) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }

}
