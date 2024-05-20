package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.infrastructure.db.database.model.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataNotificationRepository extends JpaRepository<NotificationEntity, Long> {

    @Query("SELECT c FROM NotificationEntity c WHERE c.user.id=:idUser ORDER BY c.sendAt DESC ")
    List<NotificationEntity> getNotificationsByUser(@Param("idUser") Long idUser);
}
