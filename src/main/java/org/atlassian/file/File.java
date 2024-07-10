package org.atlassian.file;

import java.util.ArrayList;
import java.util.List;

public class File {
    String fileName;
    List<String> collections; // collection // could be a list // optional
    int size; //

    public File(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
        this.collections = new ArrayList<>();
    }

    public File(String fileName, int size, List<String> collections) {
        this(fileName, size);
        this.collections = collections;
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getCollections() {
        return collections;
    }

    public int getSize() {
        return size;
    }


}