package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.NotificationRepository;
import com.yaagoub.misanuncios.domain.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
public class NotificationService{
    private final NotificationRepository notificationRepository;


    public List<Notification> getNotificationsByUser(Long idUser) {
        return (List<Notification>) notificationRepository.getNotificationsByUser(idUser);
    }
}
