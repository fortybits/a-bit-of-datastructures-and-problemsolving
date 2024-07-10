package org.atlassian.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// * file1.txt (size: 100)
// * file2.txt (size: 200) in collection "collection1"
// * file3.txt (size: 200) in collection "collection1"
// * file4.txt (size: 300) in collection "collection2"
// * file5.txt (size: 10)
class FileSystemReporterTest {

    FileSystemReporter fileStorage = new FileSystemReporter();

    List<File> files = Arrays.asList(
            new File("file1.txt", 100),
            new File("file2.txt", 200, List.of("collection1")),
            new File("file3.txt", 200, List.of("collection1")),
            new File("file4.txt", 300, List.of("collection2")),
            new File("file5.txt", 10),
            new File("file6.txt", 100, List.of("collection2")),
            new File("file7.txt", 150, Arrays.asList("collection3", "collection1", "collection2"))
    );

    @Test
    void testTotalFileSize() {
        Assertions.assertEquals(1060, fileStorage.totalFileSize(files));
    }

    @Test
    void topNCollections() {
        Assertions.assertEquals(List.of("collection1"), fileStorage.topNCollections(files, 1));
        Assertions.assertEquals(Arrays.asList("collection1", "collection2"),
                fileStorage.topNCollections(files, 2));
        Assertions.assertEquals(Arrays.asList("collection1", "collection2", "collection3"),
                fileStorage.topNCollections(files, 3));
        Assertions.assertEquals(Arrays.asList("collection1", "collection2", "collection3"),
                fileStorage.topNCollections(files, 4));
    }
}