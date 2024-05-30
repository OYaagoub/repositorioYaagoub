import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Client, Frame, StompSubscription, Stomp } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { config } from '../config/config';
import { CookieService } from 'ngx-cookie-service';
import { MessageDto } from '../dto/message.dto';
import { Message } from '../../domain/model/message.model';
import { NavigationEnd, Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  private stompClient!: any;
  private connected: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  private messageSubject:BehaviorSubject<Message> = new BehaviorSubject<Message>(new Message({}));
  private roomSubscriptions: { [roomId: number]: StompSubscription } = {};
  constructor(private cookieService: CookieService,private router: Router) {
    this.initConnectionSocket();
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Close WebSocket connection when navigating away
        /**
        this.closeConnection();
        */

      }
    });
  }


  leaveRoom(conversationRoomId: number): void {
    if (this.connected.getValue()) {
      const subscription = this.roomSubscriptions[conversationRoomId];
      if (subscription) {
        subscription.unsubscribe();
        delete this.roomSubscriptions[conversationRoomId];
        console.log(`Left room: ${conversationRoomId}`);
      } else {
        console.error(`Not subscribed to room: ${conversationRoomId}`);
      }
    } else {
      console.error('Cannot leave room. No connection established.');
    }
  }

  initConnectionSocket() {
    const socket = new SockJS(config['socketUrl']);
    this.stompClient = Stomp.over(socket);

    const token = this.cookieService.get('token');
    this.stompClient.connect({ 'Authorization': `Bearer ${token}` }, (frame: Frame) => {
      console.log('Connected: ' + frame);
      this.connected.next(true);
    }, (error: string) => {
      console.error('Error: ' + error);
      this.connected.next(false);
      // Optionally add reconnection logic here
    });
  }

  joinRoom(conversationRoomId: number) {
    if (this.connected.getValue()) {
      const subscription=this.stompClient.subscribe(`/topic/${conversationRoomId}`, (message: any) => {
        const body = JSON.parse(message.body);
        const messagefinal = new Message(body.body);
        // console.log("eso es el mensaje")
        console.log(messagefinal);
        this.messageSubject.next(messagefinal)
        this.roomSubscriptions[conversationRoomId] = subscription;

      });
    } else {
      console.error('Cannot join room. No connection established.');
    }
  }

  sendMessage(conversationRoomId: number, message: any) {
    if (this.connected.getValue()) {
      this.stompClient.send(`/app/conversation/${conversationRoomId}`, {}, JSON.stringify(message));
    } else {
      console.error('Cannot send message. No connection established.');
    }
  }

  // Optional: Add method to handle reconnection
  reconnect() {
    if (!this.connected.getValue()) {
      this.initConnectionSocket();
    }
  }

  // Optional: Add method to check connection status
  isConnected(): boolean {
    return this.connected.getValue();
  }

  getMessage():Observable<Message>{
    return this.messageSubject.asObservable();
  }


 // Close WebSocket connection
 /**
 closeConnection() {
  if (this.connected.getValue()) {
    this.stompClient.disconnect(() => {
      console.log('WebSocket connection closed.');
      this.connected.next(false);
    });
  }
}
 */















}
