package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.MessageRepository;
import com.yaagoub.misanuncios.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class MessageService {
    private  final MessageRepository messageRepository;



    public Message save(Message message){
       return  messageRepository.save(message);
    }
    public Message find(long id){
        return  messageRepository.find(id);
    }

    public void delete(Message message){
        messageRepository.delete(message);
    }

    public List<Message> getMessagesByConversation(long id){
        return (List<Message>) messageRepository.getMessagesByConversation(id);
    }

}
