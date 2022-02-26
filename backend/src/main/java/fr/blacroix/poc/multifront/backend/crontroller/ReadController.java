package fr.blacroix.poc.multifront.backend.crontroller;

import fr.blacroix.poc.multifront.backend.dto.StockDto;
import fr.blacroix.poc.multifront.backend.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReadController extends AbstractController {

    private final StockService stockService;

    @GetMapping("/stock")
    public List<StockDto> getStock() {
        return stockService.getStock();
    }


    @GetMapping("/stock/{id}")
    public StockDto getStock(@PathVariable Integer id) {
        if (id == null) {
            throw new RuntimeException("Id must not be null");
        }
        return stockService.getStock(id);
    }

}
