import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserService } from './user.service';
import { AdminService } from './admin.service';
import { GuestService } from './guest.service';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AdminDashBoardComponent } from './admin-dash-board/admin-dash-board.component';
import { UserSearchComponent } from './user-search/user-search.component';
import { ScrollToTopComponent } from './scroll-to-top/scroll-to-top.component';
import { AwaiComponent } from './awai/awai.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
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
import { UserFeedbackComponent } from './user-feedback/user-feedback.component';
import { UserHelpDeskComponent } from './user-help-desk/user-help-desk.component';
import { UserViewCityComponent } from './user-view-city/user-view-city.component';
import { UserViewPlaceComponent } from './user-view-place/user-view-place.component';
import { AdminViewUserProfileComponent } from './admin-view-user-profile/admin-view-user-profile.component';
import { UserSearchResultComponent } from './user-search-result/user-search-result.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ConnectComponent } from './connect/connect.component';



@NgModule({
  declarations: [
    AppComponent,
    UserRegisterComponent,
    UserLoginComponent,
    AdminLoginComponent,
    AdminDashBoardComponent,
    UserSearchComponent,
    ScrollToTopComponent,
    AwaiComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    AdminAddCityComponent,
    AdminAddPlaceComponent,
    AdminUpdateComponent,
    AdminDeleteComponent,
    AdminViewPlaceTrafficStatsComponent,
    AdminFeedbackComponent,
    MeitohAwaiComponent,
    UserProfileComponent,
    LootgayaComponent,
    ViewUserComponent,
    HelpDeskComponent,
    UserReviewComponent,
    UserFeedbackComponent,
    UserHelpDeskComponent,
    UserViewCityComponent,
    UserViewPlaceComponent,
    AdminViewUserProfileComponent,
    UserSearchResultComponent,
    ContactUsComponent,
    AboutUsComponent,
    ConnectComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule
  ],
  providers: [UserService,AdminService,GuestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
