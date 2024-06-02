package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.infrastructure.db.database.model.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataConversationRepository extends JpaRepository<ConversationEntity, Long> {

    @Query("SELECT c FROM ConversationEntity c WHERE c.sender.id=:id or c.product.user.id=:id")
    List<ConversationEntity> findByUser(@Param("id") long id);


    @Query("SELECT c FROM ConversationEntity c WHERE c.product.id=:idProduct and c.sender.id=:idUser")
    ConversationEntity findByUserProduct(long idProduct,long idUser);
    @Query("SELECT c FROM  ConversationEntity c WHERE c.id=:id")
    ConversationEntity findById(@Param("id") long id);
}
