package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Notification;

public interface NotificationRepository {
    Iterable<Notification> getNotificationsByUser(Long idUser);
}
