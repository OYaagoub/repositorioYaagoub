import { Injectable } from "@angular/core";
import { MessageRepository } from "../repositories/message.repository";
import { Observable } from "rxjs";
import { Message } from "../../domain/model/message.model";



@Injectable({
  providedIn: "root",
})

export class MessageService{

constructor(private messageRespository: MessageRepository){}

getMessagesByConversation(idConversation: number):Observable<Message[]>{
  return this.messageRespository.getMessagesByConversation(idConversation);
}




}
