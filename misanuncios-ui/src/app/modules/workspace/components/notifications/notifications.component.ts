import { Component, Inject } from '@angular/core';
import { NotificationRepository } from '../../../../application/repositories/notification.repository';
import { NotificationRepositoryImpl } from '../../../../infrastructure/repositories/notification.repository.impl';
import { NotificationService } from '../../../../application/services/notification.service';
import { Notification } from '../../../../domain/model/notification.model';

@Component({
  selector: 'app-notifications',
  standalone: true,
  imports: [],
  templateUrl: './notifications.component.html',
  styleUrl: './notifications.component.scss',
  providers: [
    NotificationService,
    {provide:NotificationRepository,useClass:NotificationRepositoryImpl}

  ],
})
export class NotificationsComponent {
  notifications:Notification[] = [];

  constructor(private notificationService:NotificationService){

  }
  ngOnInit(): void {
    this.notificationService.getNotificationsByUser().subscribe(
      notifications=>this.notifications=notifications
    )
    // this.notifications=this.notificationService.get
  }


}
