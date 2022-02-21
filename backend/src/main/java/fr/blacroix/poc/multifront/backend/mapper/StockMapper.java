package fr.blacroix.poc.multifront.backend.mapper;

import fr.blacroix.poc.multifront.backend.dto.StockDto;
import fr.blacroix.poc.multifront.backend.entity.StockEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockDto toDto(StockEntity entity);

    List<StockDto> toDtoList(List<StockEntity> entities);

    StockEntity toEntity(StockDto dto);

    List<StockEntity> toEnityList(List<StockDto> dtos);
}
