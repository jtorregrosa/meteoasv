import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { WeatherForecastPrecipitationDetails } from '../../../core/models';

@Component({
  selector: 'app-precipitation-probability-widget',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['./precipitation-probability-widget.component.scss'],
  templateUrl: './precipitation-probability-widget.component.html',
})
export class PrecipitationProbabilityWidgetComponent {

  @Input()
  data: WeatherForecastPrecipitationDetails[]
}
