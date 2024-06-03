import { Injectable } from "@angular/core";
import { Conversation } from "../../domain/model/conversation.model";
import { Observable } from "rxjs";
import { ConversationRepository } from "../repositories/conversation.repository";






@Injectable({
  providedIn: 'root'
})
export class ConversationService {

  constructor(private conversationRepository : ConversationRepository ) {}


  getConversationsByUser():Observable<Conversation[]>{
    return this.conversationRepository.getConversationsByUser();
  }

  save(idProduct:number):Observable<boolean>{
    return this.conversationRepository.save(idProduct);
  }




}
