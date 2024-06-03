import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { Conversation } from "../../domain/model/conversation.model";
import { config } from "../config/config";
import { ConversationDto } from "../dto/conversation.dto";
import { ConversationMapper } from "../mappers/conversation.mapper";




@Injectable({
  providedIn: "root"
})
export class ConversationService {
  constructor(private http: HttpClient) { }


  getConversationsByUser(): Observable<Conversation[]> {
    const url = `${config["contentUrl"]}/conversations/mine`;
    // const url = `${config.apiUrl}/conversations/user/${userId
    return this.http.get<ConversationDto[]>(url).pipe(
      map(conversations => conversations.map(conversation => ConversationMapper.toDomain(conversation)))
    );
  }
  save(idProduct:number):Observable<boolean>{
    const url = `${config["contentUrl"]}/conversations/save/${idProduct}`;
    return this.http.post<boolean>(url,null);
  }



}

