import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { Message } from "../../domain/model/message.model";
import { MessageDto } from "../dto/message.dto";
import { config } from "../config/config";
import { MessageMapper } from "../mappers/message.mapper";



@Injectable({
  providedIn: "root",
})
export class MessageService {
  constructor(private http: HttpClient) { }


  getMessagesByConversation(idConversation: number): Observable<Message[]> {
    return this.http.post<MessageDto[]>(`${config["contentUrl"]}/messages/${idConversation}`, {}).pipe(
      map(messages => messages.map(message => MessageMapper.toDomain(message))
      )
    );
  }
}
