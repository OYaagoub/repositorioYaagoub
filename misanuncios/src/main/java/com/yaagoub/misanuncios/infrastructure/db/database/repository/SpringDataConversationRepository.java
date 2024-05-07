package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.infrastructure.db.database.model.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataConversationRepository extends JpaRepository<ConversationEntity, Long> {
}
