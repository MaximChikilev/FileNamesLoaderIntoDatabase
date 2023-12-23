package com.example.filemanagerspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MyController {
    @Autowired
    private FilePathLoader filePathLoader;
    @Autowired
    private FileWithPathRepository repository;
    @GetMapping("/")
    public String onIndex() {
        return "index";
    }

    @PostMapping("/submitFolderPath")
    public String onTest(Model model, @RequestParam String folderPath){
        filePathLoader.putAllFilesPathFromFolderToList(folderPath);
        List<FileWithPath> list = filePathLoader.getFilePathList();
        repository.saveAll(list);
        model.addAttribute("totalFiles", list.size());
        model.addAttribute("subfolders", filePathLoader.getNestedFolders());
        return "result";
    }
}
