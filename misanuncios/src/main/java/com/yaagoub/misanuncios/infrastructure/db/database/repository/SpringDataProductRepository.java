package com.yaagoub.misanuncios.infrastructure.db.database.repository;


import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p WHERE p.title  LIKE %:search%")
    List<ProductEntity> findAllBySearch(@Param("search") String search);

    @Query("SELECT p FROM ProductEntity p WHERE  p.user.id= :idUser ")
    List<ProductEntity> getProductsEntityByUser(@Param("idUser")  Long idUser);
    @Query("SELECT p FROM ProductEntity p WHERE p.category.name Like %:name%")
    List<ProductEntity> getProductsByCategoryName(@Param("name") String name);
}
