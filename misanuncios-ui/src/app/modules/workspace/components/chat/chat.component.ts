import { Component, OnInit, OnDestroy } from '@angular/core';
import { ConversationService } from '../../../../application/services/conversation.service';
import { ConversationRepository } from '../../../../application/repositories/conversation.repository';
import { ConversationRepositoryImpl } from '../../../../infrastructure/repositories/conversation.repository.impl';
import { Conversation } from '../../../../domain/model/conversation.model';
import { ImageService } from '../../../../application/services/image.service';
import { ImageRepository } from '../../../../application/repositories/image.repository';
import { ImageRepositoryImpl } from '../../../../infrastructure/repositories/image.repository.impl';
import { Product } from '../../../../domain/model/product.model';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { WebSocketService } from '../../../../infrastructure/services/webSocket.service';
import { Message } from '../../../../domain/model/message.model';
import { MessageService } from '../../../../application/services/message.service';
import { MessageRepositoryImpl } from '../../../../infrastructure/repositories/message.repository.impl';
import { MessageRepository } from '../../../../application/repositories/message.repository';
import { UserService } from '../../../../infrastructure/services/user.service';
import { User } from '../../../../domain/model/user.model';
import { Subscription } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
  providers: [
    ConversationService,
    { provide: ConversationRepository, useClass: ConversationRepositoryImpl },
    ImageService,
    { provide: ImageRepository, useClass: ImageRepositoryImpl },
    MessageService,
    { provide: MessageRepository, useClass: MessageRepositoryImpl }
  ],
})
export class ChatComponent implements OnInit, OnDestroy {
  conversations: Conversation[] = [];
  product!: Product;
  isActive: boolean = false;
  idProductConversation!: number;
  message: string = '';
  conversation!: Conversation;
  messages: Message[] = [];
  user!: User;
  private routeSub!: Subscription;
  isConversationsListOpened: boolean = false;
  isOpen:boolean=false;
  constructor(
    private route: ActivatedRoute,
    private imageService: ImageService,
    private conversationService: ConversationService,
    private router: Router,
    private webSocketService: WebSocketService,
    private messageService: MessageService,
    private userService: UserService,
    private spinner: NgxSpinnerService,
  ) {

  }
  onOpen(){
    this.isOpen=!this.isOpen;
  }
  ngOnInit(): void {
    this.spinner.show();
    this.routeSub = this.route.params.subscribe(params => {
      this.idProductConversation = +params['id'];
      if (this.idProductConversation == null) {
        this.router.navigate(['/workspace/chats']);
      } else {
        this.currentProductConversation();
      }
    });

    this.conversationService.getConversationsByUser()
      .subscribe(res => {
        this.conversations = res;
        this.currentProductConversation();
        this.spinner.hide();
      });

    this.userService.getUser().subscribe(res => {
      if (res) {
        this.user = res;
      }
    });

    this.listnerMessage();
  }

  ngOnDestroy(): void {
    if (this.routeSub) {
      this.routeSub.unsubscribe();
    }

  }

  sendMessage() {
    const message = {
      message: this.message,
      sender: this.user,
    } as Message;


    this.webSocketService.sendMessage(this.conversation.id, message);
    this.message="";
  }

  setMessage(event: Event) {
    this.message = (event.target as HTMLInputElement).value;
    (event.target as HTMLInputElement).value="";

  }

  listnerMessage() {
    this.webSocketService.getMessage().subscribe(
      (resMessage: Message) => {
        this.messages.push(resMessage);
        this.messages=this.messages.filter((value, index, self) =>
          index === self.findIndex((t) => t.id === value.id));
      }
    );
  }

  currentProductConversation() {
    //console.log("entra currentProductConversation");
    if (this.conversations.length) {
      this.conversations.forEach((conversation) => {
        if (conversation.product.id == this.idProductConversation) {
          this.conversation = conversation;
          this.product = conversation.product;
          this.messageService.getMessagesByConversation(this.conversation.id).subscribe(res => {
            this.messages = res;
            //this.webSocketService.initConnectionSocket();
            this.webSocketService.joinRoom(this.conversation.id);
          });
        }
      });
    }
  }
  leaveRoom(conversationRoomId: number): void {
    this.webSocketService.leaveRoom(conversationRoomId);
  }
  routeredToLink(conversation: Conversation) {
    if(conversation.id != this.conversation.id){

      this.leaveRoom(this.conversation.id);
      this.router.navigate(['/workspace/chats/ct/', conversation.product.id]);
    }

  }

  isSenderNotCurrentUser(message: any): boolean {
    if (message.sender) {
      return typeof message.sender === 'object' ? message.sender.id !== this.user.id : message.sender !== this.user.id;
    }
    return false;
  }
  isConversationsListOpen(){
    this.isConversationsListOpened = !this.isConversationsListOpened;
  }

  onEnterPress(event: Event) {
    this.setMessage(event);
    this.sendMessage();
  }
}
