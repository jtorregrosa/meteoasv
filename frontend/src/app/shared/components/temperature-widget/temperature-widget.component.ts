import { ChangeDetectionStrategy, Component, Input } from '@angular/core';

@Component({
  selector: 'app-temperature-widget',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['./temperature-widget.component.scss'],
  templateUrl: './temperature-widget.component.html',
})
export class TemperatureWidgetComponent {

  @Input()
  value: number

  @Input()
  unit: string
}