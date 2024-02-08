import { Component } from '@angular/core';

@Component({
  selector: 'app-kendo-datepicker',
  template: `
    <kendo-datepicker [(ngModel)]="value" [disabledDates]="disabledDates">
    </kendo-datepicker>
  `,
  styleUrls: ['./kendo-datepicker.component.css']
})
export class KendoDatepickerComponent {
  public value: Date | undefined;

  public disabledDates = (date: Date): boolean => {
    return date.getDate() % 2 === 0;
  };

}
