package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.NotificationRepository;
import com.yaagoub.misanuncios.domain.Notification;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.NotificationEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Repository
public class NotificationRepositorySpring implements NotificationRepository {
    private final NotificationEntityMapper notificationEntityMapper;
    private final SpringDataNotificationRepository springDataNotificationRepository;
    private final CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
    @Override
    public Iterable<Notification> getNotificationsByUser(Long idUser) {
        return springDataNotificationRepository.getNotificationsByUser(idUser)
                .stream().map(notificationEntity -> notificationEntityMapper.toDomain(notificationEntity,context))
                .collect(Collectors.toList());
    }

    @Override
    public Notification save(Notification notification) {
        return notificationEntityMapper.toDomain(springDataNotificationRepository.save(notificationEntityMapper.toEntity(notification,context)),context);
    }
}
