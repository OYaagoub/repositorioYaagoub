import { Injectable } from "@angular/core";
import { MessageRepository } from "../../application/repositories/message.repository";
import { Observable } from "rxjs";
import { Message } from "../../domain/model/message.model";
import { MessageService } from "../services/message.service";



@Injectable({
  providedIn:"root",
})
export class MessageRepositoryImpl implements MessageRepository{



  constructor(private messageService: MessageService){}
  getMessagesByConversation(idConversation: number): Observable<Message[]> {
    return this.messageService.getMessagesByConversation(idConversation);
  }



}
