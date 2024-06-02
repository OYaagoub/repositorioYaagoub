import { Component } from '@angular/core';
import { Conversation } from '../../../../domain/model/conversation.model';
import { Product } from '../../../../domain/model/product.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ImageService } from '../../../../application/services/image.service';
import { ConversationService } from '../../../../application/services/conversation.service';
import { ConversationRepository } from '../../../../application/repositories/conversation.repository';
import { ConversationRepositoryImpl } from '../../../../infrastructure/repositories/conversation.repository.impl';
import { ImageRepositoryImpl } from '../../../../infrastructure/repositories/image.repository.impl';
import { ImageRepository } from '../../../../application/repositories/image.repository';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-chat-list',
  standalone: true,
  imports: [],
  templateUrl: './chat-list.component.html',
  styleUrl: './chat-list.component.scss',
  providers: [
    ConversationService,
    { provide: ConversationRepository, useClass: ConversationRepositoryImpl },
    ImageService,
    { provide: ImageRepository, useClass: ImageRepositoryImpl }
  ],
})
export class ChatListComponent {
  conversations: Conversation[] = [];
  copyConversations: Conversation[] = [];
  // product!:Product;
  product!: Product;
  isActive: boolean = false;
  idConversation!: number;
  isOpen: boolean = false;


  constructor(
    private route: ActivatedRoute,
    private conversationService: ConversationService,
    private router: Router,
    private spinner: NgxSpinnerService,
  ) {

  }

  ngOnInit(): void {
    this.spinner.show();
    this.conversationService.getConversationsByUser()
      .subscribe(res => {
        this.conversations = res;
        this.copyConversations = res;
        this.spinner.hide();
      })
  }

  currentProductConversation(id: number) {
    this.router.navigate(['/workspace/chats/ct/', id]);
  }

  onOpen() {
    this.isOpen = !this.isOpen;
  }
  searchChatting(event: Event) {
    const eventValue = event.target as HTMLInputElement;
    this.conversations.filter((conversation) => conversation.product.title.includes(eventValue.value))
    if (eventValue.value == "" || eventValue.value==" ") {
      this.conversations = this.copyConversations;
    }
  }
}
