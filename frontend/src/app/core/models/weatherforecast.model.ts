export interface WeatherForecast {
  temperatureAverage: number;
  temperatureUnit: string;
  precipitationProbabilities: WeatherForecastPrecipitationDetails[];
}

export interface WeatherForecastPrecipitationDetails {
  probability: number;
  period: string;
}
