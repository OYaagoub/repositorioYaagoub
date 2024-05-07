import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./modules/home/index.module').then(m => m.IndexModule) // lazy load the home module
  },
  {
    path: 'roles',
    loadChildren: () => import('./modules/roles/add-roles.module').then(m => m.AddRolesModule) // lazy load the home module
  },
  {
    path: 'products',
    loadChildren: () => import('./modules/products/products.module').then(m => m.ProductsModule) // lazy load the home module
  },
  {
    path: 'workspace',
    loadChildren: () => import('./modules/workspace/workspace.module').then(m => m.WorkspaceModule) // lazy load the home module
  },
  {
    path: 'about',
    loadChildren: () => import('./modules/about/about.module').then(m => m.AboutModule) // lazy load the home module
  },
  {
    path: 'auth',
    loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule) // lazy load the home module
  },
  {
    path: '**',
    redirectTo: ''
  },
];
