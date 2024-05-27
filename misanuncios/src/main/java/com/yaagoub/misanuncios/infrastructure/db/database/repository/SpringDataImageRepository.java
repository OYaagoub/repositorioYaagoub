package com.yaagoub.misanuncios.infrastructure.db.database.repository;


import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataImageRepository extends JpaRepository<ImageEntity, Long> {
    @Query("SELECT c FROM ImageEntity  c WHERE c.product.id=:idProduct")
    List<ImageEntity> getImagesByProduct(@Param("idProduct") long idProduct);

    @Query("SELECT c FROM ImageEntity  c WHERE c.id=:id")
    ImageEntity findById(@Param("id") long id);
}
