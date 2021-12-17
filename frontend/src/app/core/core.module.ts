import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
  ApiService,
} from './services';

@NgModule({
  imports: [
    CommonModule
  ],
  providers: [
    ApiService,
  ],
  declarations: []
})
export class CoreModule { }
