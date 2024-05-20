import { Observable } from "rxjs";
import { NotificationRepository } from "../../application/repositories/notification.repository";
import { NotificationService } from "../services/notofication.service";
import { Notification } from "../../domain/model/notification.model";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root',
 })
export  class NotificationRepositoryImpl implements NotificationRepository{
  constructor(private notificationService: NotificationService){}

  getNotificationsByUser(): Observable<Notification[]> {
    return this.notificationService.getNotificationsByUser();
  }

  //TODO: implement the methods




}
