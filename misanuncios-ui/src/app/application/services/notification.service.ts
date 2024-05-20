import { Observable } from "rxjs";
import { NotificationRepository } from "../repositories/notification.repository";
import { Notification } from "../../domain/model/notification.model";
import { Injectable } from "@angular/core";


@Injectable({
  providedIn: 'root',
})
export  class NotificationService{

  // ...
  constructor(private notificationRepository: NotificationRepository){}

  getNotificationsByUser(): Observable<Notification[]>{
    return this.notificationRepository.getNotificationsByUser();
  }


}
