package com.sample.datawarehouse.mapper;

import com.sample.datawarehouse.dto.TrafficDataDto;
import com.sample.datawarehouse.model.TrafficData;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrafficDataMapper {

    TrafficData dtoToEntity(TrafficDataDto dto);

    List<TrafficData> dtoListToEntityList(List<TrafficDataDto> dtos);
}
