import { Component, NgZone, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { startWith, debounceTime, distinctUntilChanged, switchMap, filter, tap, map, take } from 'rxjs/operators';
import { ApiService, Municipality, WeatherForecast } from '../../core';
import { TemperatureUnit } from '../../core/models';

interface TemperatureUnitModel {
  displayName: string,
  value: TemperatureUnit
}
interface ViewModel {
  forecast: WeatherForecast,
  municipality: Municipality,
}

@Component({
  selector: 'app-home-page',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  formGroup: FormGroup;

  municipalityFilterInput: FormControl = new FormControl();

  filteredMunicipalities: Observable<Municipality[]>;

  model$: Observable<ViewModel>;

  availableUnits: TemperatureUnitModel[] = [
    { displayName: "", value: TemperatureUnit.G_CEL },
    { displayName: "ºC", value: TemperatureUnit.G_CEL },
    { displayName: "ºF", value: TemperatureUnit.G_FAH }
  ]

  selectedUnit: TemperatureUnitModel;

  constructor(
    private apiService: ApiService,
  ) {
    this.filteredMunicipalities = this.municipalityFilterInput.valueChanges
      .pipe(
        startWith(''),
        debounceTime(400),
        distinctUntilChanged(),
        filter(val => val !== ''),
        switchMap(val => this.apiService.filterMunicipalities(val || '')),
      );
  }

  ngOnInit() {
    this.selectedUnit = this.availableUnits[0];
  }

  public search() {
    this.model$ = this.apiService
      .findWeatherForecast(this.municipalityFilterInput.value, this.selectedUnit.value)
      .pipe(
        take(1),
      );
  }
}
