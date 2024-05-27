package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Image;

public interface ImageRepository
{
    Iterable<Image> getImagesByProduct(long idProduct);
    Image save(Image image);
    void delete(Image image);

    Image findById(long id);


}
