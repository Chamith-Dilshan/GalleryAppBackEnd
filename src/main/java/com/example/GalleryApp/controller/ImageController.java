package com.example.GalleryApp.controller;

import com.example.GalleryApp.model.Image;
import com.example.GalleryApp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService service;
    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public Image addImage(@RequestParam("file") MultipartFile file) {
        return service.addImageToDB(file);
    }
    @GetMapping
    public List<Image> getImages(){
        return service.getImagesFromDB();
    }
    @PutMapping
    public Image updateImage(@RequestBody Image imageRequest){
        return service.updateImageName(imageRequest);
    }
    @DeleteMapping("/{imageId}")
    public String deleteImage(@PathVariable String imageId){
        return service.deleteImageFromDB(imageId);
    }
}