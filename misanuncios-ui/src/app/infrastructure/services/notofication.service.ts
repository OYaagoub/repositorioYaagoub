import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { NotificationDto } from "../dto/notification.dto";
import { config } from "../config/config";
import { NotificationMapper } from "../mappers/notification.mapper";
import { Notification } from "../../domain/model/notification.model";



@Injectable({
  providedIn: 'root',
})
export class NotificationService{
  // ...
  constructor(private http: HttpClient) { }
  getNotificationsByUser(): Observable<Notification[]> {
    const url = `${config['contentUrl']}/notifications`; // Assuming the endpoint is `/notifications`
    return this.http.get<NotificationDto[]>(url).pipe(
      map((notificationDtos: NotificationDto[]) => notificationDtos.map(notificationDto => NotificationMapper.toDomain(notificationDto)))
    );
  }

}
