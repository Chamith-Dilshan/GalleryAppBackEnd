package com.example.GalleryApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Document(collection = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    private String imageId;
    private String imageName;
    private byte[] imageData;

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName(){
        return imageName;
    }
    public byte[] getImageData() {
        return imageData;
    }
    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

}
