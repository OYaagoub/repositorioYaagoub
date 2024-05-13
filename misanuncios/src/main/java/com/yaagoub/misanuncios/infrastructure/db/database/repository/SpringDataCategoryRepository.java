package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.infrastructure.db.database.model.CategoryEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query("SELECT c FROM CategoryEntity c WHERE c.name LIKE %:name%")
    CategoryEntity getByName(@Param("name") String name);
}
