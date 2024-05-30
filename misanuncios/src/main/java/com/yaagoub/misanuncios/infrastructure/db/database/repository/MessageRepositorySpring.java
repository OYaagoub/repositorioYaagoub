package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.MessageRepository;
import com.yaagoub.misanuncios.domain.Message;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.MessageEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.model.MessageEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MessageRepositorySpring implements MessageRepository {

    private final CycleAvoidingMappingContext context=new CycleAvoidingMappingContext();
    private final MessageEntityMapper messageEntityMapper ;
    private final SpringDataMessageRepository springDataMessageRepository;
    @Override
    public Message save(Message message) {
        return messageEntityMapper.toDomain(springDataMessageRepository.save(messageEntityMapper.toEntity(message,context)),context);
    }

    @Override
    public void delete(Message message) {
        springDataMessageRepository.delete(messageEntityMapper.toEntity(message,context));

    }

    @Override
    public Message find(long id) {
        return messageEntityMapper.toDomain(springDataMessageRepository.find(id),context);
    }

    @Override
    public Iterable<Message> getMessagesByConversation(long id){
        return  springDataMessageRepository.findMessagesByConversation(id)
                .stream().map(messageEntity -> messageEntityMapper.toDomain(messageEntity,context))
                .collect(Collectors.toList());
    }
}
