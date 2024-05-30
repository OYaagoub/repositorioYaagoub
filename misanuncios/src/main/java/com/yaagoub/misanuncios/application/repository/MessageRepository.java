package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Message;

public interface MessageRepository {

    Message save(Message message);

    void delete(Message message);

    Message find(long id);

    Iterable<Message> getMessagesByConversation(long id);
}
