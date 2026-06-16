package com.pcstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcstore.model.Content;
import com.pcstore.repository.ContentRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    @Autowired
    private ContentRepository repo;

    @GetMapping("/{page}")
    public List<Content> getContent(@PathVariable String page) {
        return repo.findByPage(page);
    }

    @PostMapping
    public Content saveContent(@RequestBody Content c) {

        List<Content> existing = repo.findByPage(c.getPage());

        for(Content content : existing){
            if(content.getSection().equals(c.getSection())){
                content.setContent(c.getContent());
                return repo.save(content);  // UPDATE
            }
        }

        return repo.save(c); // INSERT
    }
    
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {

        try {

            String fileName = file.getOriginalFilename();

            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/image/";

            File saveFile = new File(uploadDir + fileName);

            file.transferTo(saveFile);

            return fileName;

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    
    
}
