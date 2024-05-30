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


@Component({
  selector: 'app-chat-list',
  standalone: true,
  imports: [],
  templateUrl: './chat-list.component.html',
  styleUrl: './chat-list.component.scss',
  providers: [
    ConversationService,
    {provide:ConversationRepository,useClass:ConversationRepositoryImpl},
    ImageService,
    {provide:ImageRepository,useClass:ImageRepositoryImpl}
  ],
})
export class ChatListComponent {
  conversations:Conversation[]=[];
  product!:Product;
  isActive:boolean=false;
  idConversation!:number;
  isOpen:boolean=false;


  constructor(
      private route: ActivatedRoute,
      private conversationService:ConversationService,
      private router:Router,
    ){

  }

  ngOnInit(): void {
    this.conversationService.getConversationsByUser()
    .subscribe(res=>{
      this.conversations=res;
    })
  }

  currentProductConversation(id:number){
    this.router.navigate(['/workspace/chats/ct/',id]);
  }

  onOpen(){
    this.isOpen=!this.isOpen;
  }
}
