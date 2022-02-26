package fr.blacroix.poc.multifront.frontendread.service;

import fr.blacroix.poc.multifront.frontendread.dto.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BackConsumer {

    private final RestTemplate restTemplate;

    @Value("${back-end}")
    private String backEndUrl;

    public List<Stock> getStock() {
        log.info("Backend url: {}", backEndUrl);
        ParameterizedTypeReference<List<Stock>> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<List<Stock>> resp = restTemplate.exchange(backEndUrl, HttpMethod.GET, null, responseType);
        return resp.getBody();
    }

}
