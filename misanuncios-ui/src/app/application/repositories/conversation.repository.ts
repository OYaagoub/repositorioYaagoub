import { Observable } from "rxjs";
import { Conversation } from "../../domain/model/conversation.model";




export abstract class ConversationRepository {
  abstract getConversationsByUser(): Observable<Conversation[]>;
  abstract save(idProduct:number):Observable<boolean>;
}
