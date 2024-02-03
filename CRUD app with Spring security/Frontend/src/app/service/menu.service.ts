import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor() {}
  public isOpen = new BehaviorSubject<boolean>(false);
  public opened = false;

  public toggle(){
    this.opened = !this.opened;
    this.isOpen.next(this.opened);
   
  }
   
}
