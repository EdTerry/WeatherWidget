package com.eddyt.weatherdashboard.fetch;

import com.eddyt.weatherdashboard.web.ApiServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ZipApiFetcher implements ApiFetcher {
  private static final Logger logger = LoggerFactory.getLogger(ZipApiFetcher.class);
  private final ApiServiceImpl apiService;

  @Value("${zippopotam.base-url}")
  private String baseUrl;

  @Value("${zippopotam.path}")
  private String path;

  public ZipApiFetcher(final ApiServiceImpl apiService) {
    this.apiService = apiService;
  }

  public <T> Mono<T> getData(final String zipCode, Class<T> responseType) {
    return apiService.makeRequest(baseUrl, path, responseType, zipCode);
  }
}
