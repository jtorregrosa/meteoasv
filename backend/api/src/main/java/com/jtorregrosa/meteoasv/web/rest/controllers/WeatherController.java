/*
 * Copyright (c) 2021 Jorge Torregrosa
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.jtorregrosa.meteoasv.web.rest.controllers;

import com.jtorregrosa.meteoasv.aemet.exception.HttpAemetException;
import com.jtorregrosa.meteoasv.domain.Municipality;
import com.jtorregrosa.meteoasv.domain.TemperatureUnit;
import com.jtorregrosa.meteoasv.domain.WeatherForecast;
import com.jtorregrosa.meteoasv.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Validated
public class WeatherController {
    private final Logger log = LoggerFactory.getLogger(WeatherController.class);

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/municipalities")
    @ResponseBody
    public List<Municipality> getMunicipalities(@RequestParam(name = "name", required = false) String name) throws IOException, HttpAemetException {
        return this.weatherService.filterMunicipalitiesByName(name);
    }

    @GetMapping("/weatherforecast/{code}")
    @ResponseBody
    public WeatherForecast getDailyPrediction(
        @RequestParam(name = "temperatureUnit", defaultValue = "G_CEL", required = false) TemperatureUnit temperatureUnit,
        @PathVariable(name = "code") String code) throws IOException, HttpAemetException {
        return this.weatherService.getWeatherForecast(code, temperatureUnit);
    }
}
