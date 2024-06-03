import { Observable } from "rxjs";
import { Notification } from "../../domain/model/notification.model";

export abstract class NotificationRepository{

  // ...

  abstract getNotificationsByUser(): Observable<Notification[]>;


}
