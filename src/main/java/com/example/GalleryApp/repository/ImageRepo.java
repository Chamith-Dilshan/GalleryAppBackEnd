package com.example.GalleryApp.repository;

import com.example.GalleryApp.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepo extends MongoRepository<Image,String> {

}
