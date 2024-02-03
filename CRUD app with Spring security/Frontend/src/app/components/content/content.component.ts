import { Component } from '@angular/core';
import { MenuService } from 'src/app/service/menu.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.scss']
})
export class ContentComponent {

  opened = true;
  constructor(private menuservice : MenuService){
    this.menuservice.isOpen.subscribe(data=>{
      this.opened = data;
    });
  }
 
}
