import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MenuService } from 'src/app/service/menu.service';
import { UserAuthService } from 'src/app/service/user-auth.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  constructor (
    private menuservice: MenuService,
    private userAuthservice : UserAuthService,
    private router : Router,
    public userService : UserService){

  }
  toggleMenu(){

    this.menuservice.toggle();
  }

  public isLoggedIn(){
    return this.userAuthservice.isLoggedIn();
  }

  public logout(){
    this.userAuthservice.clear();
    this.router.navigate(['/home'])
  }

}

