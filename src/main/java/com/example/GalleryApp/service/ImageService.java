package com.example.GalleryApp.service;

import com.example.GalleryApp.model.Image;
import com.example.GalleryApp.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {
    @Autowired
    private ImageRepo repository;

    //CRUD operations
    //Add Image to the DB
    public Image addImageToDB(MultipartFile file) {
        try {
            Image image = new Image();
            image.setImageId(UUID.randomUUID().toString().split("-")[0]);
            image.setImageName(file.getOriginalFilename());
            image.setImageData(file.getBytes());
            return repository.save(image);
        } catch (IOException e) {
            throw new RuntimeException("Failed to add image to the database: " + e.getMessage());
        }
    }

    //Get Images From DB
    public List<Image> getImagesFromDB(){
        return repository.findAll();
    }

    //Update Image Name
    public Image updateImageName(Image imageRequest){
        Image existingImage= repository.findById(imageRequest.getImageId()).get();
        existingImage.setImageName(imageRequest.getImageName());
        return repository.save(existingImage);
    }

    //Delete Image from DB
    public String deleteImages(List<String> imageIds) {
        StringBuilder result = new StringBuilder();

        for (String imageId : imageIds) {
            try {
                repository.deleteById(imageId);
                result.append(imageId).append(" Image deleted successfully\n");
            } catch (Exception e) {
                result.append("Failed to delete ").append(imageId).append(". Error: ").append(e.getMessage()).append("\n");
            }
        }

        return result.toString().trim();
    }
}