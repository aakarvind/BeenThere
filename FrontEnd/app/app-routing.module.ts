import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserSearchComponent } from './user-search/user-search.component';
import { AdminDashBoardComponent } from './admin-dash-board/admin-dash-board.component';
import { AwaiComponent } from './awai/awai.component';
import { AdminAddCityComponent } from './admin-add-city/admin-add-city.component';
import { AdminAddPlaceComponent } from './admin-add-place/admin-add-place.component';
import { AdminUpdateComponent } from './admin-update/admin-update.component';
import { AdminDeleteComponent } from './admin-delete/admin-delete.component';
import { AdminViewPlaceTrafficStatsComponent } from './admin-view-place-traffic-stats/admin-view-place-traffic-stats.component';
import { AdminFeedbackComponent } from './admin-feedback/admin-feedback.component';
import { MeitohAwaiComponent } from './meitoh-awai/meitoh-awai.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { LootgayaComponent } from './lootgaya/lootgaya.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { HelpDeskComponent } from './help-desk/help-desk.component';
import { UserReviewComponent } from './user-review/user-review.component';
import { UserViewCityComponent } from './user-view-city/user-view-city.component';
import { UserViewPlaceComponent } from './user-view-place/user-view-place.component';
import { AdminViewUserProfileComponent } from './admin-view-user-profile/admin-view-user-profile.component';
import { UserSearchResultComponent } from './user-search-result/user-search-result.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { ConnectComponent } from './connect/connect.component';



export const routes: Routes = [
  { path: 'adminLogin', component: AdminLoginComponent },
  { path: 'userLogin', component: UserLoginComponent },
  { path: 'userRegister', component: UserRegisterComponent},
  { path: 'userHome', component: UserSearchComponent},
  { path: 'adminHome', component: AdminDashBoardComponent},
  { path: 'adminAddCity', component: AdminAddCityComponent},
  { path: 'adminAddPlace', component: AdminAddPlaceComponent},
  { path: 'adminUpdate', component: AdminUpdateComponent},
  { path: 'adminDelete', component: AdminDeleteComponent},
  { path: 'adminViewTraffic', component: AdminViewPlaceTrafficStatsComponent},
  { path: 'awaiawai', component: AwaiComponent},
  {path:'adminfeedback',component:AdminFeedbackComponent},
  {path:'meitohawai',component:MeitohAwaiComponent},
  {path:'userprofile',component:UserProfileComponent},
  {path:'awailootgaya',component:LootgayaComponent},
  {path:'viewuser',component:ViewUserComponent},
  {path:'helpdesk',component:HelpDeskComponent},
  {path:'userreview',component:UserReviewComponent},
  {path:'userviewcity',component:UserViewCityComponent},
  {path:'userviewplace',component:UserViewPlaceComponent},
  {path:'adminuserviewprofile',component:AdminViewUserProfileComponent},
  {path:'userSearchResult',component:UserSearchResultComponent},
  {path:'aboutus',component:AboutUsComponent},
  {path:'contactus',component:ContactUsComponent},
  {path:'connect',component:ConnectComponent}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
