package com.sample.datawarehouse.mapper;

import com.sample.datawarehouse.dto.TrafficDataDto;
import com.sample.datawarehouse.model.TrafficData;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrafficDataMapper {

    TrafficData dtoToEntity(TrafficDataDto dto);

    @AfterMapping
    default void calculateCtr(TrafficDataDto dto, @MappingTarget TrafficData target) {
        Double ctr = (Double.valueOf(dto.getClicks()) / Double.valueOf(dto.getImpressions())) * 100;
        target.setCtr(ctr);
    }

    List<TrafficData> dtoListToEntityList(List<TrafficDataDto> dtos);
}
