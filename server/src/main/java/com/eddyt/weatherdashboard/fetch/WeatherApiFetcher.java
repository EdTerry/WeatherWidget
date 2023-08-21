package com.eddyt.weatherdashboard.fetch;

import com.eddyt.weatherdashboard.model.Location;
import com.eddyt.weatherdashboard.web.ApiServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class WeatherApiFetcher implements ApiFetcher {
  @Value("${openweather.api-key}")
  private String apiKey;
  @Value("${openweather.base-url}")
  private String baseUrl;
  @Value("${openweather.path}")
  private String path;
  private static final Logger logger = LoggerFactory.getLogger(WeatherApiFetcher.class);
  private final ApiServiceImpl apiService;
  private final ZipApiFetcher zipApiFetcher;

  public WeatherApiFetcher(final ApiServiceImpl apiService, final ZipApiFetcher zipApiFetcher) {
    this.apiService = apiService;
    this.zipApiFetcher = zipApiFetcher;
  }

  public <T> Mono<T> getData(final String zipCode, Class<T> responseType) {
    logger.info("fetchWeather given zipCode {}", zipCode);
    Location location = zipApiFetcher.getData(zipCode, Location.class).block();
    logger.info("locationData - {}", location);

    String latitude = location.places()[0].latitude();
    String longitude = location.places()[0].longitude();

    return apiService.makeRequest(baseUrl, path, responseType, latitude, longitude, apiKey);
  }
}
