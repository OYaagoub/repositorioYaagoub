import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './components/index/index.component';
import { MyProductsComponent } from './components/my-products/my-products.component';
import { ChatComponent } from './components/chat/chat.component';
import { NotificationsComponent } from './components/notifications/notifications.component';
import { ChatListComponent } from './components/chat-list/chat-list.component';

const routes: Routes = [
  // Add your routes here
  {
    path: '', component: IndexComponent, children: [

      {
        path: 'myProducts/:reload',
        component: MyProductsComponent,
      },
      {
        path: 'chats',
        component:ChatListComponent,
      },
      {
        path: 'chats/ct/:id',
        component:ChatComponent
      },
      {
        path: 'notifications',
        component:NotificationsComponent,
      }
    ]
  },
  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WorkspaceRoutingModule { }
