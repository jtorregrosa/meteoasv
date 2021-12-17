import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { PrecipitationProbabilityWidgetComponent } from './components/precipitation-probability-widget/precipitation-probability-widget.component';
import { TemperatureWidgetComponent } from './components/temperature-widget/temperature-widget.component';
import { WeatherForecastWidgetComponent } from './components/weather-forecast-widget/weather-forecast-widget.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule
  ],
  declarations: [
    PrecipitationProbabilityWidgetComponent,
    TemperatureWidgetComponent,
    WeatherForecastWidgetComponent
  ],
  exports: [
    PrecipitationProbabilityWidgetComponent,
    TemperatureWidgetComponent,
    WeatherForecastWidgetComponent
  ]
})
export class SharedModule {}
