package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Conversation;

public interface ConversationRepository {
    Iterable<Conversation> getConversationsByUser(long id);

    Conversation save(Conversation conversation);
    Conversation findByUserProduct(long idProduct , long idUser);
}
