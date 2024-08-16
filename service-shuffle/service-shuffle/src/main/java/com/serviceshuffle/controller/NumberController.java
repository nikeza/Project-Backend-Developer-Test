package com.serviceshuffle.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.serviceshuffle.dto.NumberDto;
import com.serviceshuffle.service.NumberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping
public class NumberController {

    @Value("${endpoint}")
    private String endpoint;
    private final NumberService numberService;
    private final WebClient webClient;

    public NumberController(NumberService numberService, WebClient.Builder webClientBuilder) {
        this.numberService = numberService;
        this.webClient = webClientBuilder.baseUrl(endpoint).build();
    }

    @PostMapping("/shuffle")
    public List<Integer> shuffleNumber(@Valid @RequestBody NumberDto numberDto) {
        logRequestAsync(numberDto);
        return numberService.shuffleNumber(numberDto.getNumber());
    }

    private void logRequestAsync(NumberDto numberDto) {
        webClient.post()
                .uri("/log")
                .bodyValue(numberDto)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}
