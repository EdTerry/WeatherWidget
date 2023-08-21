package com.eddyt.weatherdashboard.fetch;

import reactor.core.publisher.Mono;

public interface ApiFetcher {
  public <T> Mono<T> getData(final String zipCode, Class<T> responseType);
}
