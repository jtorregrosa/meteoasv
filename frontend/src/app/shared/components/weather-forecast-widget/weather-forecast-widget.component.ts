import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { Municipality, WeatherForecast } from '../../../core';

@Component({
  selector: 'app-weather-forecast-widget',
  styleUrls: ['./weather-forecast-widget.component.scss'],
  templateUrl: './weather-forecast-widget.component.html',
})
export class WeatherForecastWidgetComponent {
  @Input()
  municipality: Municipality;

  @Input()
  forecast: WeatherForecast;

  tomorrow: Date;

  constructor() {
    const today = new Date()
    this.tomorrow = new Date(today)

    this.tomorrow.setDate(this.tomorrow.getDate() + 1)
  }

  public parseTemperatureUnit(unit: string) {
    switch(unit) {
      case 'G_CEL':
        return 'ºC';
      case 'G_FAH':
        return 'ºF';
      default:
        return 'UNKNOWN';
    }
  }
}
