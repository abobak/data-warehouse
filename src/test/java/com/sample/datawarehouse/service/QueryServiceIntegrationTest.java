package com.sample.datawarehouse.service;

import com.sample.datawarehouse.dto.CtrPerCampaignAndDatasource;
import com.sample.datawarehouse.dto.TotalClicksDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class QueryServiceIntegrationTest {

    @Autowired
    private ImportService importService;

    @Autowired
    private QueryService queryService;

    @BeforeEach
    void setUp() throws IOException {
        String payload = "Datasource,Campaign,Daily,Clicks,Impressions\n" +
                "Google Ads,Adventmarkt Touristik,11/12/19,7,22425\n" +
                "Google Ads,Adventmarkt Touristik,11/13/19,16,45452\n" +
                "Google Ads,Imaginecup,11/12/19,8,400\n" +
                "Google Ads,Imaginecup,11/13/19,16,320\n" +
                "Google Ads,Adventmarkt Touristik,11/14/19,147,80351\n";
        importService.importTrafficData(payload.getBytes());
    }

    @ParameterizedTest
    @MethodSource("getDatesAndExpectedClicks")
    void shouldCountClicksInCampaignForExpectedDateRange(LocalDate from, LocalDate to, Integer expectedClicks) {
        String campaignParam = "Adventmarkt Touristik";

        TotalClicksDto clicks = queryService.getTotalClicksForCampaign(campaignParam, from, to);
        assertEquals(expectedClicks, clicks.getTotalClicks());
    }

    @Test
    void shouldCountAverageCtrForCampaignAndDatasource() {
        String campaignParam = "Imaginecup";
        String dataSource = "Google Ads";
        Double expectedCtr = 3.5; // ((8/400 + 16/320)/2) * 100
        CtrPerCampaignAndDatasource res = queryService.getCtrPerCampaignAndDatasource(campaignParam, dataSource);
        assertEquals(expectedCtr, res.getCtr());
    }

    private static Stream<Arguments> getDatesAndExpectedClicks() {
        return Stream.of(
                Arguments.of(LocalDate.of(2019,11,12), LocalDate.of(2019,11,12), 7),
                Arguments.of(LocalDate.of(2019,11,12), LocalDate.of(2019,11,13), 23),
                Arguments.of(LocalDate.of(2019,11,12), LocalDate.of(2019,11,21), 170)
        );
    }
}
