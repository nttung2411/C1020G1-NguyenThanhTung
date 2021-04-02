import {AbstractControl, ValidationErrors} from '@angular/forms';

// @ts-ignore
export function numberValidate(control: AbstractControl): ValidationErrors | null {
  const value = + control.value;
  if (isNaN(value)) {
    return {'numberValidate': true};
  }
  return null;
}
