package fr.blacroix.poc.multifront.frontendwrite.service;

import fr.blacroix.poc.multifront.frontendwrite.dto.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class BackConsumer {

    private final RestTemplate restTemplate;

    @Value("${back-end}")
    private String backEndUrl;

    public String addStock(Stock stock) {
        log.info("Backend url: {}", backEndUrl);
        try {
            restTemplate.postForLocation(backEndUrl, stock);
            return "success";
        } catch (Exception e) {
            log.error("Exception while adding item", e);
            return "error";
        }
    }

    public String deleteStock(int id) {
        log.info("Backend url: {}", backEndUrl);
        try {
            restTemplate.delete(backEndUrl + "/" + id);
            return "success";
        } catch (Exception e) {
            log.error("Exception while adding item", e);
            return "error";
        }
    }

}
