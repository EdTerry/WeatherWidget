package com.eddyt.weatherdashboard.rest;

import com.eddyt.weatherdashboard.fetch.WeatherApiFetcher;
import com.eddyt.weatherdashboard.model.WeatherRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherInfoController {
  private static final Logger logger = LoggerFactory.getLogger(WeatherInfoController.class);
  private final WeatherApiFetcher weatherApiFetcher;

  public WeatherInfoController(final WeatherApiFetcher weatherApiFetcher) {
    this.weatherApiFetcher = weatherApiFetcher;
  }

  @PostMapping("/weatherForZip")
  private Mono<WeatherRecord> getWeatherForZip(@RequestParam("zipCode") String zipCode) {
    logger.info("Received POST /weatherForZip with zipCode {}", zipCode);

    return weatherApiFetcher.getData(zipCode, WeatherRecord.class);
  }
}
