import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FontSizeEditorComponent} from './font-size-editor/font-size-editor.component';
import {PetComponent} from './pet/pet.component';
import {CalculatorComponent} from './calculator/calculator.component';
import {ColorPickerComponent} from './color-picker/color-picker.component';


const routes: Routes = [
  {path: 'font-size' , component: FontSizeEditorComponent},
  {path: 'pet' , component: PetComponent},
  {path: 'calculator' , component: CalculatorComponent},
  {path: 'colorPicker' , component: ColorPickerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
