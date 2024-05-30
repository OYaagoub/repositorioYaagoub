import { Observable } from "rxjs";
import { Message } from "../../domain/model/message.model";



export abstract class MessageRepository {
  abstract getMessagesByConversation(idConversation: number): Observable<Message[]>;
}
