package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.ConversationRepository;
import com.yaagoub.misanuncios.domain.Conversation;
import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.ConversationEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ConversationRepositorySpring implements ConversationRepository {
    private final SpringDataConversationRepository springDataConversationRepository;
    private  final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();
    private final ConversationEntityMapper conversationEntityMapper;

    @Override
    public Iterable<Conversation> getConversationsByUser(long id) {
        return springDataConversationRepository.findByUser(id).stream()
                .map(conversationEntity -> conversationEntityMapper.toDomain(conversationEntity,context))
                .collect(Collectors.toList());
    }

    @Override
    public Conversation save(Conversation conversation) {
        return conversationEntityMapper.toDomain(springDataConversationRepository.save(conversationEntityMapper.toEntity(conversation,context)),context);
    }
    @Override
    public Conversation findByUserProduct(long idProduct , long idUser){
        return conversationEntityMapper.toDomain(springDataConversationRepository.findByUserProduct(idProduct,idUser),context);
    }
}
