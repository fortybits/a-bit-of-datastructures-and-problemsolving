package org.atlassian.file;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * For this system we would like to generate a report that lists:
 * <p>
 * The total size of all files stored; and
 * <p>
 * The top N collections (by file size)
 * <p>
 * <p>
 * where N can be a user-defined value
 * file1.txt (size: 100)
 * file2.txt (size: 200) in collection "collection1"
 * file3.txt (size: 200) in collection "collection1"
 * file4.txt (size: 300) in collection "collection2"
 * file5.txt (size: 10)
 */
public class FileSystemReporter {

    // List<File> files;

    public int totalFileSize(List<File> files) {
        int totalFileSize = 0; //
        for (File file : files) {
            int fileSize = file.getSize();
            totalFileSize = totalFileSize + fileSize;
        }
        return totalFileSize;
    }

    // collections with their corresponding total file size
    // sort this intermediate data in reverse order based on the size
    // limit the response to a size of n
    // runtime worst case: O(NlogN)
    // space complexity: O(N)
    public List<String> topNCollections(List<File> files, int n) {
        Map<String, Long> collectionsToFileSize = new TreeMap<>();
        for (File file : files) { // files runtime O(N)
            List<String> fileCollections = file.getCollections();
            for (String fileCollection : fileCollections) {
                if (!collectionsToFileSize.containsKey(fileCollection)) {
                    collectionsToFileSize.put(fileCollection, (long) file.getSize());
                } else {
                    Long existingCollectionSize = collectionsToFileSize.get(fileCollection);
                    collectionsToFileSize.put(fileCollection, existingCollectionSize + file.getSize());
                }
            }
        }
        // N entries worst case O(N(logN))
        return collectionsToFileSize.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // sorted reverse
                .limit(n) // limit number of response
                .map(Map.Entry::getKey) // collections name
                .collect(Collectors.toList());
    }
}