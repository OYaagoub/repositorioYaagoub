package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.ImageRepository;
import com.yaagoub.misanuncios.domain.Image;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ImageService  {

    private  final  ImageRepository imageRepository;
    public List<Image> getImagesByProduct(long idProduct) {
        return (List<Image>) imageRepository.getImagesByProduct(idProduct);
    }


    public Image save(Image image) {
        return imageRepository.save(image);
    }


    public void delete(Image image) {
         imageRepository.delete(image);
    }
    public  Image findById(long id){
        return imageRepository.findById(id);
    }
}
