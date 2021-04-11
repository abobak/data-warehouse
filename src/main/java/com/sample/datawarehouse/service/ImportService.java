package com.sample.datawarehouse.service;

import com.sample.datawarehouse.dto.TrafficDataDto;
import com.sample.datawarehouse.mapper.CsvToDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImportService {

    private final CsvToDtoMapper csvToDtoMapper = new CsvToDtoMapper();

    public void importTrafficData(byte[] bytes) throws IOException {
        List<TrafficDataDto> dtos = csvToDtoMapper.csvToDtoList(bytes, TrafficDataDto.class);
    }
}
