package com.example.filemanagerspring;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilePathLoader {
    List<FileWithPath> fileWithPathList = new ArrayList<>();
    private int nestedFolders = 0;

    public void putAllFilesPathFromFolderToList(String folderPath) {
        File directoryPath = new File(folderPath);
        File filesList[] = directoryPath.listFiles();
        for (File file : filesList) {
            if (file.isFile()) {
                fileWithPathList.add(new FileWithPath(file.getName(),file.getPath()));
            } else {
                putAllFilesPathFromFolderToList(file.getPath());
                nestedFolders++;
            }
        }
    }

    public List<FileWithPath> getFilePathList() {
        return fileWithPathList;
    }

    public int getNestedFolders() {
        return nestedFolders;
    }
}
