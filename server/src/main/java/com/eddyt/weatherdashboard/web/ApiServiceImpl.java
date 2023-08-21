package com.eddyt.weatherdashboard.web;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService {
  private final WebClient webClient;

  public ApiServiceImpl(final WebClient webClient) {
    this.webClient = webClient;
  }

  public <T> Mono<T> makeRequest(
      String uri, String path, Class<T> responseType, String... varargs) {
    return webClient
        .mutate()
        .baseUrl(uri)
        .build()
        .get()
        .uri(path, (Object []) varargs)
        .retrieve()
        .bodyToMono(responseType);
  }
}
