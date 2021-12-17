import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { iif, Observable, of, throwError } from 'rxjs';

import { catchError, map, switchMap } from 'rxjs/operators';
import { Municipality, TemperatureUnit, WeatherForecast } from '../models';

@Injectable()
export class ApiService {

  private urls = {
    filterMunicipalities: () => `${environment.apiUrl}/municipalities`,
    getWeatherForecast: (code: string) => `${environment.apiUrl}/weatherforecast/${code}`,
  }

  constructor(private http: HttpClient) {}

  private formatErrors(error: any) {
    return throwError(error.error);
  }

  filterMunicipalities(name: string) : Observable<Municipality[]> {
    const params = this.parseFilterParams({name})

    return this.http
      .get<Municipality[]>(this.urls.filterMunicipalities(), { params })
      .pipe(
        catchError(this.formatErrors)
      );
  }

  getWeatherForecast(code: string, unit: TemperatureUnit): Observable<WeatherForecast> {
    const params = this.parseFilterParams({temperatureUnit: unit})

    return this.http
      .get<WeatherForecast>(this.urls.getWeatherForecast(code), { params })
      .pipe(
        catchError(this.formatErrors)
      );
  }

  findWeatherForecast(name: string, unit: TemperatureUnit): Observable<{forecast: WeatherForecast, municipality: Municipality} | null> {
    return this.filterMunicipalities(name)
      .pipe(
        switchMap(v =>
          iif(
            () => v.length > 0,
            this.getWeatherForecast(v[0].id.replace('id', ''), unit).pipe(map(v2 => <{forecast: WeatherForecast, municipality: Municipality}>{ forecast: v2, municipality: v[0]})),
            of(null),
          )
        ),
        catchError(this.formatErrors)
      )
  }

  /**
   * Parse query params from a FilterRequest.
   *
   * @protected
   * @param {any} filters the filters.
   * @return {HttpParams}
   * @memberof BaseEntityApiService
   */
   protected parseFilterParams(filters: any): HttpParams {
    let params = new HttpParams();

    Object.keys(filters).forEach(key => {
      const value = Reflect.get(filters, key);

      if (value instanceof Array) {
        value.forEach(element => {
          if ((element as string).split(':').filter(e => e.length !== 0).length >= 2) {
            params = params.append(key, element);
          }
        });
      } else {
        params = params.append(key, value);
      }
    });

    return params;
  }
}

