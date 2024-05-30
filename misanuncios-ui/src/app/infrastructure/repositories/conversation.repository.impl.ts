import { Injectable } from "@angular/core";
import { ConversationRepository } from "../../application/repositories/conversation.repository";
import { Observable } from "rxjs";
import { Conversation } from "../../domain/model/conversation.model";
import { ConversationService } from "../services/conversation.service";




@Injectable({
  providedIn: 'root'
})
export class ConversationRepositoryImpl implements ConversationRepository{

  constructor(private conversationService : ConversationService) { }
  save(idProduct: number): Observable<boolean> {
      return this.conversationService.save(idProduct);
  }
  getConversationsByUser(): Observable<Conversation[]> {
      return  this.conversationService.getConversationsByUser();
  }


}
