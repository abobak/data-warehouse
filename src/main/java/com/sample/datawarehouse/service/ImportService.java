package com.sample.datawarehouse.service;

import com.sample.datawarehouse.dto.TrafficDataDto;
import com.sample.datawarehouse.mapper.CsvToDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImportService {

    private final CsvToDtoMapper csvToDtoMapper = new CsvToDtoMapper();

    public void importTrafficData(byte[] bytes) throws IOException {
        csvToDtoMapper.csvToDtoList(bytes, TrafficDataDto.class);
    }
}
