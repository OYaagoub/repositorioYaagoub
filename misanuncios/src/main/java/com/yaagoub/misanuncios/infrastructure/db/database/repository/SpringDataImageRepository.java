package com.yaagoub.misanuncios.infrastructure.db.database.repository;


import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataImageRepository extends JpaRepository<ImageEntity, Long> {
}
