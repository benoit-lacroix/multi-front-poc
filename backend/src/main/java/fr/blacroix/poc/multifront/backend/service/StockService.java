package fr.blacroix.poc.multifront.backend.service;

import fr.blacroix.poc.multifront.backend.dto.StockDto;
import fr.blacroix.poc.multifront.backend.entity.StockEntity;
import fr.blacroix.poc.multifront.backend.mapper.StockMapper;
import fr.blacroix.poc.multifront.backend.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public List<StockDto> getStock() {
        return stockMapper.toDtoList(StreamSupport.stream(stockRepository.findAll().spliterator(), false).toList());
    }

    public StockDto getStock(Integer id) {
        return stockRepository.findById(id).map(stockMapper::toDto).orElse(null);
    }

    public String addStock(StockDto dto) {
        stockRepository.save(stockMapper.toEntity(dto));
        return "Object added successfully";
    }

    public String deleteStock(Integer id) {
        stockRepository.deleteById(id);
        return "Object deleted successfully";
    }
}
