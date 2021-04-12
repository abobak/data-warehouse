package com.sample.datawarehouse.service;

import com.sample.datawarehouse.dto.TrafficDataDto;
import com.sample.datawarehouse.mapper.CsvToDtoMapper;
import com.sample.datawarehouse.mapper.TrafficDataMapper;
import com.sample.datawarehouse.repository.TrafficDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImportService {

    private final CsvToDtoMapper csvToDtoMapper = new CsvToDtoMapper();

    private final TrafficDataMapper trafficDataMapper;

    private final TrafficDataRepository trafficDataRepository;

    public void importTrafficData(byte[] bytes) throws IOException {
        List<TrafficDataDto> dtos = csvToDtoMapper.csvToDtoList(bytes, TrafficDataDto.class);
        trafficDataRepository.saveAll(trafficDataMapper.dtoListToEntityList(dtos));
    }

    public void reset() {
        trafficDataRepository.deleteAll();
    }
}
