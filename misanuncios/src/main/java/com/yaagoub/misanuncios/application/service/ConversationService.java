package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.ConversationRepository;
import com.yaagoub.misanuncios.domain.Conversation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public List<Conversation> getConversationsByUser(long id){
        return (List<Conversation>) conversationRepository.getConversationsByUser(id);
    }
    public Conversation save(Conversation conversation){
        return  this.conversationRepository.save(conversation);
    }

    public  Conversation findByUserProduct(long idProduct , long idUser){
        return this.conversationRepository.findByUserProduct(idProduct,idUser);
    }
    public Conversation findById(long id){
        return conversationRepository.findById(id);
    }
}
