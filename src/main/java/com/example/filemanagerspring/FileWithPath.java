package com.example.filemanagerspring;

import jakarta.persistence.*;

@Entity
public class FileWithPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_path")
    private String filePath;

    public FileWithPath() {
    }

    public FileWithPath(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
