package com.sample.datawarehouse.mapper;

import com.sample.datawarehouse.dto.TrafficDataDto;
import com.sample.datawarehouse.model.TrafficData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CsvPayloadToTrafficDataDtoTest {

    CsvToDtoMapper mapperUnderTest = new CsvToDtoMapper();

    @Test
    void shouldMapCsvPayloadToExpectedDto() throws IOException {
        String expectedCampaing = "Adventmarkt Touristik";
        String expectedDatasource = "Google Ads";
        Integer expectedClicks = 7;
        Integer expectedImpressions = 22425;
        LocalDate expectedDate = LocalDate.of(2019, 11, 12);
        String minimumCsvPayload = "Datasource,Campaign,Daily,Clicks,Impressions\n" +
                "Google Ads,Adventmarkt Touristik,11/12/19,7,22425";
        TrafficDataDto computed = (TrafficDataDto) mapperUnderTest.csvToDtoList(minimumCsvPayload.getBytes(), TrafficDataDto.class).get(0);

        assertEquals(expectedCampaing, computed.getCampaign());
        assertEquals(expectedDatasource, computed.getDataSource());
        assertEquals(expectedClicks, computed.getClicks());
        assertEquals(expectedImpressions, computed.getImpressions());
        assertTrue(expectedDate.isEqual(computed.getDaily()));

    }

}
