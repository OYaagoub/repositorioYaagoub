package com.yaagoub.misanuncios.infrastructure.db.database.repository;


import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {
}
