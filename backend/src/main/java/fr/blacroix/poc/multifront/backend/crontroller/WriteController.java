package fr.blacroix.poc.multifront.backend.crontroller;

import fr.blacroix.poc.multifront.backend.dto.StockDto;
import fr.blacroix.poc.multifront.backend.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WriteController extends AbstractController {

    private final StockService stockService;

    @PutMapping("/stock")
    public String addStock(@RequestBody StockDto dto) {
        if (dto == null || dto.getId() != null || dto.getLabel() == null) {
            log.error("Malformed received dto: {}", dto.toString());
            throw new RuntimeException("Dto object malformed");
        }
        return stockService.addStock(dto);
    }

    @DeleteMapping("/stock/{id}")
    public String deleteStock(@PathVariable Integer id) {
        if (id == null) {
            throw new RuntimeException("Id must not be null");
        }
        return stockService.deleteStock(id);
    }
}
