package com.yaagoub.misanuncios.infrastructure.db.database.repository;


import com.yaagoub.misanuncios.infrastructure.db.database.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataMessageRepository extends JpaRepository<MessageEntity, Long> {

    @Query("SELECT c FROM MessageEntity c where c.id=:id")
    MessageEntity find(@Param("id") long id);

    @Query("SELECT c FROM MessageEntity c WHERE  c.conversation.id=:id")
    List<MessageEntity> findMessagesByConversation(@Param("id") long id);
}
