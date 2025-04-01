import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { PartnersComponent } from './partners/partners.component';
import { NewsComponent } from './news/news.component';
import { ContactComponent } from './contact/contact.component';
import { AuthComponent } from './auth/auth.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },  
  { path: 'about', component: AboutComponent },  
  { path: 'partners', component: PartnersComponent }, 
  { path: 'news', component: NewsComponent },  
  { path: 'contact', component: ContactComponent },  
  { path: 'auth', component: AuthComponent } 
];
