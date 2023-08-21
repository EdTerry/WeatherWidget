package com.eddyt.weatherdashboard.web;

import reactor.core.publisher.Mono;

public interface ApiService {
  public <T> Mono<T> makeRequest(String uri, String path, Class<T> responseType, String... varargs);
}
